package services;

import dao.QuestionDao;
import model.Question;
import model.Response;

import java.util.List;

public class QuestionsService implements facade.QuestionDao {

    // TODO same communication logic with the dao classes as we did the playerService class

    private final QuestionDao questionDao;

    public QuestionsService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public Question findOne(Long id) {
        if (id == null) {
            return null;
        }

        return questionDao.findOne(id);
    }

    public List<Question> findAll() {
        return questionDao.findAll();
    }

    public void save(Question entity) {
        if (entity == null) {
            return;
        }

        questionDao.save(entity);
    }

    public Question update(Question entity) {
        if (entity == null) {
            return null;
        }

        return questionDao.update(entity);
    }

    public void delete(Question entity) {
        if (entity == null) {
            return;
        }

        questionDao.delete(entity);
    }

    public void deleteById(Long entityId) {
        if (entityId == null) {
            return;
        }

        questionDao.deleteById(entityId);
    }

    @Override
    public List<Question> findByQuiz(Long quizId) {
        return List.of();
    }

    @Override
    public List<Response> findResponsesByQuestion(Long questionId) {
        return List.of();
    }

    @Override
    public void addResponseToQuestion(Long questionId, Response response) {}

    @Override
    public void removeResponseFromQuestion(Long questionId, Long responseId) {}

    @Override
    public boolean checkAnswer(Long questionId, Long responseId) {
        return false;
    }
}
