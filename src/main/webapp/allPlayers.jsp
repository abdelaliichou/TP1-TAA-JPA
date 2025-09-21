<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Liste des joueurs</title>
        <link rel="stylesheet" type="text/css" href="allPlayersForm.css">
    </head>
    <body>
        <div class="container">
            <div class="logo-container"><img src="istic.png" alt="Logo"></div>
            <h2>Liste des joueurs</h2>

            <!-- bouton ajouter -->
            <div class="actions">
                <a href="PlayerServlet?action=form" class="add-btn">+ Ajouter un joueur</a>
            </div>

            <div class="card-grid">
                <c:forEach var="p" items="${players}">
                    <div class="card">
                        <h3>${p.name}</h3>
                        <p><strong>Email:</strong> ${p.email}</p>
                        <p><strong>Rôle:</strong> ${p.role}</p>

                        <form method="POST" action="PlayerServlet">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="id" value="${p.id}">
                            <button type="submit" class="delete-btn">Supprimer</button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
