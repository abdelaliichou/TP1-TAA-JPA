package services;

import dao.PlayerDao;
import facade.IGenericDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.JPQLQueries;
import model.Participation;
import model.Player;
import model.Quiz;

import java.util.List;

public class PlayersService implements facade.PlayerDao {

    // TODO create & add exceptions to every unwanted return

    private final PlayerDao playerDao;

    public PlayersService(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    private void executeTransaction(Runnable action) {
    //    EntityTransaction tx = playerDao.entityManager.getTransaction();
    //    try {
    //        tx.begin();
            action.run();
    //        tx.commit();
    //    } catch (RuntimeException e) {
    //        if (tx.isActive()) tx.rollback();
    //        throw e;
    //    }
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

    public void save(Player player) {
        if (player == null) return;

        // Integrity 1: Email must be unique
        if (playerDao.existsByEmail(player.getEmail())) {
            throw new IllegalStateException("Email already exists: " + player.getEmail());
        }

        // Integrity 2: Email must be valid format
        if (!player.getEmail().matches(JPQLQueries.EMAIL_REGEX)) {
            throw new IllegalArgumentException("Invalid email format: " + player.getEmail());
        }

        // Integrity 3: Role must be AUTHOR or PLAYER
        if (!JPQLQueries.Roles.TEACHER.name().equals(player.getRole())
                && !JPQLQueries.Roles.STUDENT.name().equals(player.getRole()))
        {
            throw new IllegalArgumentException("Invalid role: " + player.getRole());
        }

        // Integrity 4: Nickname must not be empty
        if (player.getName() == null || player.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Nickname cannot be empty.");
        }

        executeTransaction(() -> playerDao.save(player));
    }

    public Player update(Player player) {
        if (player == null) return null;

        // Integrity 1: Email must be unique
        if (playerDao.existsByEmail(player.getEmail())) {
            throw new IllegalStateException("Email already exists: " + player.getEmail());
        }

        // Integrity 2: Email must be valid format
        if (!player.getEmail().matches(JPQLQueries.EMAIL_REGEX)) {
            throw new IllegalArgumentException("Invalid email format: " + player.getEmail());
        }

        // Integrity 3: Role must be AUTHOR or PLAYER
        if (!JPQLQueries.Roles.TEACHER.name().equals(player.getRole())
                && !JPQLQueries.Roles.STUDENT.name().equals(player.getRole()))
        {
            throw new IllegalArgumentException("Invalid role: " + player.getRole());
        }

        // Integrity 4: Nickname must not be empty
        if (player.getName() == null || player.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Nickname cannot be empty.");
        }

        final Player[] result = new Player[1];
        executeTransaction(() -> result[0] = playerDao.update(player));
        return result[0];
    }

    public void delete(Player entity) {
        if (entity == null) {
            return;
        }

        executeTransaction(() -> playerDao.delete(entity));
    }

    public void deleteById(Long entityId) {

        if (entityId == null) return;

        Player player = playerDao.findOne(entityId);

        // Integrity 5: Prevent deleting if still author of quizzes
        if (!playerDao.findQuizByPlayer(entityId).isEmpty()) {
            throw new IllegalStateException("Cannot delete player: still author of quizzes.");
        }

        executeTransaction(() -> playerDao.delete(player));
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
