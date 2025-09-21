package services;

import dao.QuestionDao;
import dao.QuizDao;
import model.Participation;
import model.Question;
import model.Quiz;

import java.util.List;

public class QuizService implements facade.QuizDao {

    // TODO same communication logic with the dao classes as we did the playerService class

    private final QuizDao quizDao;

    public QuizService(QuizDao quizDao) {
        this.quizDao = quizDao;
    }

    public Quiz findOne(Long id) {
        if (id == null) {
            return null;
        }

        return quizDao.findOne(id);
    }

    public List<Quiz> findAll() {
        return quizDao.findAll();
    }

    public void save(Quiz entity) {
        if (entity == null) {
            return;
        }

        quizDao.save(entity);
    }

    public Quiz update(Quiz entity) {
        if (entity == null) {
            return null;
        }

        return quizDao.update(entity);
    }

    public void delete(Quiz entity) {
        if (entity == null) {
            return;
        }

        quizDao.delete(entity);
    }

    public void deleteById(Long entityId) {
        if (entityId == null) {
            return;
        }

        quizDao.deleteById(entityId);
    }

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
