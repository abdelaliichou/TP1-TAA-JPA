package facade;

import model.Participation;

import java.io.Serializable;
import java.util.List;

public interface ParticipationDao<K, T extends Serializable> {

    List<Participation> findByPlayer(Long playerId);

    List<Participation> findByQuiz(Long quizId);

    int calculateScore(Long participationId);

}
