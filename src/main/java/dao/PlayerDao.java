package dao;

import model.Participation;
import model.Player;
import model.Quiz;
import model.JPQLQueries;

import java.util.List;

public class PlayerDao extends AbstractJpaDao<Long, Player> implements facade.PlayerDao {

    // here we add the custom queries that we want en plus

    public PlayerDao() {
        super(Player.class);
    }

    @Override
    public Player findByEmail(String email) {
        try {
            return entityManager.createQuery(
                    JPQLQueries.playerFindByEmail,
                    Player.class
            ).setParameter(
                    "email",
                    email
            ).getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<Quiz> findQuizByPlayer(Long playerId) {
        return entityManager.createQuery(
                JPQLQueries.playerFindQuizByPlayer,
                Quiz.class
        ).setParameter(
                "playerId",
                playerId
        ).getResultList();
    }

    @Override
    public List<Participation> findParticipationsByPlayer(Long playerId) {
        return entityManager.createQuery(
                JPQLQueries.playerFindParticipationsByPlayer,
                Participation.class
        ).setParameter(
                "playerId",
                playerId
        ).getResultList();
    }

    @Override
    public boolean authenticate(String email) {
        return entityManager.createQuery(
                JPQLQueries.playerAuthenticate,
                Long.class
        ).setParameter(
                "email",
                email
        ).getSingleResult() > 0;
    }

    public boolean existsByEmail(String email){
        return false;
    }

}
