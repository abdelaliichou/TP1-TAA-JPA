package facade;

import model.Participation;
import model.Player;
import model.Quiz;

import java.io.Serializable;
import java.util.List;

public interface PlayerDao<K, T extends Serializable> {

    Player findByEmail(String email);

    List<Quiz> findQuizByPlayer(Long playerId);

    List<Participation> findParticipationsByPlayer(Long playerId);

    boolean authenticate(String email);

}
