package services;

import dao.PlayerDao;
import facade.IGenericDao;
import jakarta.persistence.EntityManager;
import model.Participation;
import model.Player;
import model.Quiz;

import java.util.List;

public class PlayersService implements facade.PlayerDao {

    // TODO create & add exceptions to every unwanted return
    // TODO create & add transactions logic with the entity manager

    private final PlayerDao playerDao;

    public PlayersService(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }
    
    public Player findOne(Long id) {
        if (id == null) {
            return null;
        }

        return playerDao.findOne(id);
    }

    public List<Player> findAll() {
        return playerDao.findAll();
    }

    public void save(Player entity) {
        if (entity == null) {
            return;
        }

        playerDao.save(entity);
    }

    public Player update(Player entity) {
        if (entity == null) {
            return null;
        }

        return playerDao.update(entity);
    }

    public void delete(Player entity) {
        if (entity == null) {
            return;
        }

        playerDao.delete(entity);
    }

    public void deleteById(Long entityId) {
        if (entityId == null) {
            return;
        }

        playerDao.deleteById(entityId);
    }

    @Override
    public Player findByEmail(String email) {
        if (email == null || email.isEmpty()) {
            return null;
        }

        return playerDao.findByEmail(email);
    }

    @Override
    public List<Quiz> findQuizByPlayer(Long playerId) {
        if (playerId == null) {
            return List.of();
        }

        return playerDao.findQuizByPlayer(playerId);
    }

    @Override
    public List<Participation> findParticipationsByPlayer(Long playerId) {
        if (playerId == null) {
            return List.of();
        }

        return playerDao.findParticipationsByPlayer(playerId);
    }

    @Override
    public boolean authenticate(String email) {
        if (email == null || email.isEmpty()) {
            System.out.println("Login failed for email: " + email);
            return false;
        }

        return playerDao.authenticate(email);
    }
}
