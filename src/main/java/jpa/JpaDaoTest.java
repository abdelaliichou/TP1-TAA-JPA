package jpa;


import dao.EntityManagerHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Department;
import model.Player;
import model.PlayerDao;
import model.Utils;
import services.PlayersService;

public class JpaDaoTest {

    public static void main(String[] args) {

        try {

            Player ichou = new Player(
                    "abdelali",
                    Utils.Roles.STUDENT.name(),
                    new Department(
                            "Rennes",
                            35000
                    )
            );

            PlayerDao playerDao = new PlayerDao();
            playerDao.save(ichou);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
