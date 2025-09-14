package jpa;


import dao.EntityManagerHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Player;
import services.PlayersService;

public class JpaTest {

    private EntityManager manager;
    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }

    public static void main(String[] args) {

        EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        JpaTest test = new JpaTest(manager);

        tx.begin();
        try {

            for (Player p : PlayersService.insertEmployees()){
                manager.persist(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        tx.commit();

        // get all players with name = ichou
        PlayersService.showPlayers(
                PlayersService.getPlayersByName(
                        manager,
                        "ichou"
                )
        );

        manager.close();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(".. done");
    }

}
