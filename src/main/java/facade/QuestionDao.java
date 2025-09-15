package facade;

import model.Question;
import model.Response;

import java.io.Serializable;
import java.util.List;

public interface QuestionDao<K, T extends Serializable> {

    List<Question> findByQuiz(Long quizId);

    List<Response> findResponsesByQuestion(Long questionId);

    void addResponseToQuestion(Long questionId, Response response);

    void removeResponseFromQuestion(Long questionId, Long responseId);

    boolean checkAnswer(Long questionId, Long responseId);

}
