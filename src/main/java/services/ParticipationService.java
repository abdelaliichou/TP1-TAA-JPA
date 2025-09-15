package services;

import model.Participation;

import java.util.List;

public class ParticipationService implements facade.ParticipationDao {

    // TODO same communication logic with the dao classes as we did the playerService class

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
