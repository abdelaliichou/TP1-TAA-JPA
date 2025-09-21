<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Liste des quizzes</title>
        <link rel="stylesheet" type="text/css" href="allPlayersForm.css">
    </head>
    <body>
        <div class="container">
            <div class="logo-container"><img src="istic.png" alt="Logo"></div>
            <h2>Liste des quizzes</h2>

            <!-- bouton ajouter -->
            <div class="actions">
                <a href="QuizServlet?action=form" class="add-btn">+ Ajouter un quiz</a>
            </div>

            <div class="card-grid">
                <c:forEach var="quiz" items="${quizzes}">
                    <div class="card">
                        <h3>${quiz.title}</h3>
                        <p><strong>Description:</strong> ${quiz.description}</p>
                        <p><strong>Auteur:</strong> ${quiz.author.name}</p>

                        <form method="POST" action="QuizServlet">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="id" value="${quiz.id}">
                            <button type="submit" class="delete-btn">Supprimer</button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
