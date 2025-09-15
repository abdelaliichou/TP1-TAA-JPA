package jpa;


import model.Player;
import dao.PlayerDao;
import model.Utils;

public class JpaDaoTest {

    public static void main(String[] args) {

        try {

            Player ichou = new Player(
                    "abdelali",
                    Utils.Roles.STUDENT.name()
            );

            PlayerDao playerDao = new PlayerDao();
            playerDao.save(ichou);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
