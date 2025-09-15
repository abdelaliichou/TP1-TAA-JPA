package jpa;


import dao.PlayerDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.JPQLQueries;
import model.Player;
import services.PlayersService;

public class JpaTest {

    private final PlayersService servicePlayer;

    public JpaTest() {
        PlayerDao playerDao = new PlayerDao();
        servicePlayer = new PlayersService(playerDao);
    }

    public static void main(String[] args) {

        JpaTest test = new JpaTest();

        try {

            testingPlayerService(test);

        } catch (Exception e) {
            e.printStackTrace();
        }

        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(".. done");
    }


    private static void testingPlayerService(JpaTest test) {

        // Create Player
        Player player = new Player();
        player.setName("ichou");
        player.setEmail("ichou@abdelali.fr");
        player.setRole(JPQLQueries.Roles.STUDENT.name());

        test.servicePlayer.save(player);
        System.out.println("Player saved: " + player.getName());

        // Find by email
        Player found = test.servicePlayer.findByEmail("ichou@abdelali.fr");
        if (found != null) {
            System.out.println("Found player: " + found.getName());
        } else {
            System.out.println("Player not found");
        }

        // Authenticate
        boolean authOk = test.servicePlayer.authenticate("ichou@abdelali.fr");
        boolean authFail = test.servicePlayer.authenticate("wrong@user.fr");

        System.out.println("Auth success? " + authOk);
        System.out.println("Auth fail? " + authFail);

    }

}

