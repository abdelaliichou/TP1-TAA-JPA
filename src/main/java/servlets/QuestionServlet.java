package servlets;

import dao.QuestionDao;
import dao.QuizDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Question;
import model.Quiz;
import services.QuestionsService;
import services.QuizService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="questionservlet", urlPatterns={"/QuestionServlet"})
public class QuestionServlet extends HttpServlet {
    private QuestionsService questionService;
    private QuizService quizService;

    @Override
    public void init() {
        questionService = new QuestionsService(
                new QuestionDao()
        );
        quizService = new QuizService(
                new QuizDao()
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // Get quizId from request (optional, null if not selected yet)
        Long quizId = req.getParameter("quizId") != null ? Long.valueOf(req.getParameter("quizId")) : null;

        // Fetch all quizzes for the <select>
        List<Quiz> quizzes = quizService.findAll();

        // If quizId is provided, fetch the quiz and its questions
        Quiz selectedQuiz = null;
        List<Question> questions = null;
        if (quizId != null) {
            selectedQuiz = quizService.findOne(quizId);
            questions = questionService.findByQuiz(quizId);
        }

        // Begin HTML
        out.println("<html><head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<link rel='stylesheet' href='playerForm.css'>");
        out.println("<title>Gestion des Questions</title>");
        out.println("</head><body>");
        out.println("<div class='container'>");
        out.println("<div class='logo-container'><img src='istic.png' alt='Logo'></div>");
        out.println("<h2>Ajouter une Question</h2>");

        // Form to add a question
        out.println("<form method='POST' action='/QuestionServlet'>");

        // Quiz select
        out.println("<label for='quiz'>Quiz:</label>");
        out.println("<select name='quizId' id='quiz' required>");
        for (Quiz q : quizzes) {
            String selected = (quizId != null && quizId.equals(q.getId())) ? "selected" : "";
            out.println("<option value='" + q.getId() + "' " + selected + ">" + q.getTitle() + "</option>");
        }
        out.println("</select>");

        // Question body
        out.println("<label for='body'>Question:</label>");
        out.println("<input type='text' id='body' name='body' required>");

        // Time limit
        out.println("<label for='timeLimit'>Temps limite (sec):</label>");
        out.println("<input type='text' id='timeLimit' name='timeLimit' required>");

        out.println("<input type='submit' value='Ajouter Question'>");
        out.println("</form>");

        // If a quiz is selected, show its questions
        if (selectedQuiz != null && questions != null && !questions.isEmpty()) {
            out.println("<h2>Questions du Quiz: " + selectedQuiz.getTitle() + "</h2>");
            out.println("<div class='card-grid'>");

            for (Question q : questions) {
                out.println("<div class='card'>");
                out.println("<p><strong>Question:</strong> " + q.getBody() + "</p>");
                out.println("<p><strong>Temps limite:</strong> " + q.getTimeLimit() + " sec</p>");
                out.println("<a href='ResponseServlet?questionId=" + q.getId() + "' class='add-btn'>Voir Réponses</a>");
                out.println("<form method='POST'>");
                out.println("<input type='hidden' name='action' value='delete'>");
                out.println("<input type='hidden' name='id' value='" + q.getId() + "'>");
                out.println("<input type='hidden' name='quizId' value='" + quizId + "'>"); // Keep quizId on delete
                out.println("<button type='submit' class='delete-btn'>Supprimer</button>");
                out.println("</form>");
                out.println("</div>");
            }

            out.println("</div>"); // end card-grid
        }

        out.println("</div>"); // end container
        out.println("</body></html>");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        if("delete".equals(action)){
            Long id = Long.valueOf(req.getParameter("id"));
            questionService.deleteById(id);
            resp.sendRedirect("QuestionServlet?quizId=" + req.getParameter("quizId"));
            return;
        }

        // Process adding a new question
        Long quizId = Long.valueOf(req.getParameter("quizId")); // Comes from the <select>
        String body = req.getParameter("body");
        int timeLimit = Integer.parseInt(req.getParameter("timeLimit"));

        Question q = new Question();
        q.setBody(body);
        q.setTimeLimit(timeLimit);

        quizService.addQuestionToQuiz(quizId, q);

        resp.sendRedirect("QuestionServlet?quizId=" + quizId);
    }
}

