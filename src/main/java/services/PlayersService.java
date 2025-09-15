package services;

import jakarta.persistence.EntityManager;
import model.Player;
import model.Utils;

import java.util.ArrayList;
import java.util.List;

public class PlayersService {

    // getSingleResult() -> we're sur that the result is 1 element
    // getResultList() -> we're sur that the result is > 1 element
    // setFirstResult(int departPosition)
    // setMaxResults(int resultsNumber)
    // setFlushMode(FlushModeType mode)

    // return a list of 2 dimension objects containing name and role
    public static List<Object[]> getPlayersNameAndRole(EntityManager manager) {
        List<Object[]> players = (List<Object[]>)
                manager.createQuery(
                        Utils.playerNameAndRoleQuery
                ).getResultList();

        for (Object[] info : players) {
            System.out.println("Player name => " + info[0]);
            System.out.println("Player role => " + info[1]);
        }
        return players;
    }

    public static List<Player> getAllPlayers(EntityManager manager) {
        List<Player> players = manager.createQuery(
                Utils.allPlayersQuery,
                Player.class
        ).getResultList();
        return players;
    }

    public static List<Player> getPlayersByDepartment(
            EntityManager manager,
            String dep
    ) {
        List<Player> players = manager.createQuery(
                Utils.playersByDepartmentQuery,
                Player.class
        ).setParameter(
                "departmentName",
                dep
        ).getResultList();
        return players;
    }

    public static List<Player> getPlayersByName(
            EntityManager manager,
            String name
    ) {
        List<Player> players = manager.createQuery(
                Utils.playerByNameQuery,
                Player.class
        ).setParameter(
                "name",
                name
        ).getResultList();
        return players;
    }

    public static ArrayList<Player> insertEmployees() {
        return new ArrayList<Player>() {{
            add(new Player(
                            "raynaud",
                            Utils.Roles.TEACHER.name()
                    )
            );
            add(new Player(
                            "ichou",
                            Utils.Roles.STUDENT.name()
                    )
            );
            add(new Player(
                            "olivier",
                            Utils.Roles.TEACHER.name()
                    )
            );
        }};
    }

    public static void showPlayers(List<Player> players) {
        for (Player p : players) {
            System.out.println(p.toString());
        }
    }
}
