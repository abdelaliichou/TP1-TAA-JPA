package facade;

import model.Participation;
import model.Question;
import model.Quiz;

import java.io.Serializable;
import java.util.List;

public interface QuizDao<K, T extends Serializable> {

    List<Quiz> findByAuteur(Long auteurId);

    List<Question> findQuestionsByQuiz(Long quizId);

    List<Participation> findParticipationsByQuiz(Long quizId);

    Quiz createQuiz(Long authorId, String titre, String description);

    void addQuestionToQuiz(Long quizId, Question question);

    void removeQuestionFromQuiz(Long quizId, Long questionId);

}
