package services;

import dao.ParticipationDao;
import dao.PlayerDao;
import model.Participation;
import model.Player;

import java.util.List;

public class ParticipationService implements facade.ParticipationDao {

    // TODO same communication logic with the dao classes as we did the playerService class

    private final ParticipationDao participationDao;

    public ParticipationService(ParticipationDao participationDao) {
        this.participationDao = participationDao;
    }

    public Participation findOne(Long id) {
        if (id == null) {
            return null;
        }

        return participationDao.findOne(id);
    }

    public List<Participation> findAll() {
        return participationDao.findAll();
    }

    public void save(Participation entity) {
        if (entity == null) {
            return;
        }

        participationDao.save(entity);
    }

    public Participation update(Participation entity) {
        if (entity == null) {
            return null;
        }

        return participationDao.update(entity);
    }

    public void delete(Participation entity) {
        if (entity == null) {
            return;
        }

        participationDao.delete(entity);
    }

    public void deleteById(Long entityId) {
        if (entityId == null) {
            return;
        }

        participationDao.deleteById(entityId);
    }

    @Override
    public List<Participation> findByPlayer(Long playerId) {
        return List.of();
    }

    @Override
    public List<Participation> findByQuiz(Long quizId) {
        return List.of();
    }

    @Override
    public int calculateScore(Long participationId) {
        return 0;
    }
}
