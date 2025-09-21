<html>
    <head>
        <meta charset="UTF-8">
        <title>Ajouter un joueur</title>
        <link rel="stylesheet" type="text/css" href="playerForm.css">
    </head>
    <body>
        <form method="POST" action="/PlayerServlet">
            <div class="logo-container">
                <img src="istic.png" alt="Logo">
            </div>

            <h2>Ajouter un joueur</h2>

            <label for="name">Nom :</label>
            <input type="text" id="name" name="name" required>

            <label for="role">Role :</label>
            <input type="text" id="role" name="role" required>

            <label for="email">Email :</label>
            <input type="email" id="email" name="email" required>

            <input type="submit" value="Ajouter">
        </form>
    </body>
</html>
