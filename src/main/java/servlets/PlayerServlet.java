package servlets;

import dao.PlayerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Player;
import services.PlayersService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(
        name = "playerservlet",
        urlPatterns = {"/PlayerServlet"}
)
public class PlayerServlet extends HttpServlet {

    private PlayersService playersService;

    @Override
    public void init() throws ServletException {
        super.init();
        playersService = new PlayersService(
                new PlayerDao()
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");

        if ("form".equals(action)) {
            // Aller vers la page formulaire
            req.getRequestDispatcher("/playerForm.jsp").forward(req, resp);
        } else {
            // Liste des joueurs
            List<Player> players = playersService.findAll();
            req.setAttribute("players", players);
            req.getRequestDispatcher("/allPlayers.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            Long id = Long.valueOf(req.getParameter("id"));
            playersService.deleteById(id);
        } else {
            // Ajout
            String name = req.getParameter("name");
            String role = req.getParameter("role");
            String email = req.getParameter("email");

            Player newPlayer = new Player();
            newPlayer.setName(name);
            newPlayer.setRole(role);
            newPlayer.setEmail(email);
            playersService.save(newPlayer);
        }

        // Toujours revenir vers la liste
        resp.sendRedirect("PlayerServlet");
    }
}

