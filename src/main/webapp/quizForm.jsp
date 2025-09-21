<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="playerForm.css">
    </head>
    <body>
        <form method="POST" action="/QuizServlet">
            <div class="logo-container"><img src="istic.png" alt="Logo"></div>
            <h2>Creer un Quiz</h2>

            <label for="title">Titre :</label>
            <input type="text" id="title" name="title" required>

            <label for="description">Description :</label>
            <input type="text" id="description" name="description" required>

            <label for="author">Auteur :</label>
            <select name="authorId" id="author" required>
                <c:forEach var="player" items="${players}">
                    <option value="${player.id}">${player.name}</option>
                </c:forEach>
            </select>

            <input type="submit" value="Ajouter Quiz">
        </form>
    </body>
</html>
