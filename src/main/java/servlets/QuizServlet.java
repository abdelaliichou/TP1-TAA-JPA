package servlets;

import dao.PlayerDao;
import dao.QuizDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Player;
import model.Quiz;
import services.PlayersService;
import services.QuizService;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name="quizservlet",
        urlPatterns={"/QuizServlet"}
)
public class QuizServlet extends HttpServlet {
    private QuizService quizService;
    private PlayersService playersService;

    @Override
    public void init() {
        quizService = new QuizService(
                new QuizDao()
        );
        playersService = new PlayersService(
                new PlayerDao()
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");

        if ("form".equals(action)) {
            // Load authors
            List<Player> players = playersService.findAll();
            req.setAttribute("players", players);

            req.getRequestDispatcher("/quizForm.jsp").forward(req, resp);
        } else {
            // Show all quizzes
            List<Quiz> quizzes = quizService.findAll();
            req.setAttribute("quizzes", quizzes);

            req.getRequestDispatcher("/allQuizzes.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            Long id = Long.valueOf(req.getParameter("id"));
            quizService.deleteById(id);
        } else {

            String title = req.getParameter("title");
            String desc = req.getParameter("description");
            Long authorId = Long.valueOf(req.getParameter("authorId"));
            Player author = playersService.findOne(authorId);
            Quiz quiz = new Quiz();

            quiz.setTitle(title);
            quiz.setDescription(desc);
            quiz.setAuthor(author);

            quizService.save(quiz);
        }

        // Always redirect back to quizzes list
        resp.sendRedirect("QuizServlet");
    }

}

