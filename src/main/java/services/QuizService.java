package services;

import model.Participation;
import model.Question;
import model.Quiz;

import java.util.List;

public class QuizService implements facade.QuizDao {

    // TODO same communication logic with the dao classes as we did the playerService class

    @Override
    public List<Quiz> findByAuteur(Long auteurId) {
        return List.of();
    }

    @Override
    public List<Question> findQuestionsByQuiz(Long quizId) {
        return List.of();
    }

    @Override
    public List<Participation> findParticipationsByQuiz(Long quizId) {
        return List.of();
    }

    @Override
    public Quiz createQuiz(Long authorId, String titre, String description) {
        return null;
    }

    @Override
    public void addQuestionToQuiz(Long quizId, Question question) {

    }

    @Override
    public void removeQuestionFromQuiz(Long quizId, Long questionId) {

    }
}
