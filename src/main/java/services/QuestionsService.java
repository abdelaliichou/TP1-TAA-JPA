package services;

import model.Question;
import model.Response;

import java.util.List;

public class QuestionsService implements facade.QuestionDao {

    // TODO same communication logic with the dao classes as we did the playerService class

    @Override
    public List<Question> findByQuiz(Long quizId) {
        return List.of();
    }

    @Override
    public List<Response> findResponsesByQuestion(Long questionId) {
        return List.of();
    }

    @Override
    public void addResponseToQuestion(Long questionId, Response response) {

    }

    @Override
    public void removeResponseFromQuestion(Long questionId, Long responseId) {

    }

    @Override
    public boolean checkAnswer(Long questionId, Long responseId) {
        return false;
    }
}
