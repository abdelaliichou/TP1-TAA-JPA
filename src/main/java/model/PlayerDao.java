package model;

import dao.AbstractJpaDao;
import org.hsqldb.lib.List;

public class PlayerDao extends AbstractJpaDao<Long, Player> {
    public PlayerDao() {
        super(Player.class);
    }

    // here we add the custom queries that we want en plus, for exemple
    public List<Player> getMembershipPlayers(){
        return (List<Player>) this.entityManager.createQuery(Utils.allPlayersQuery).getResultList();
    }
}
