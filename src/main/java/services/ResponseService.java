package services;

import dao.QuizDao;
import dao.ResponseDao;
import model.Quiz;
import model.Response;

import java.util.List;

public class ResponseService implements  facade.ResponseDao {

    // TODO same communication logic with the dao classes as we did the playerService class

    private final ResponseDao responseDao;

    public ResponseService(ResponseDao responseDao) {
        this.responseDao = responseDao;
    }

    public Response findOne(Long id) {
        if (id == null) {
            return null;
        }

        return responseDao.findOne(id);
    }

    public List<Response> findAll() {
        return responseDao.findAll();
    }

    public void save(Response entity) {
        if (entity == null) {
            return;
        }

        responseDao.save(entity);
    }

    public Response update(Response entity) {
        if (entity == null) {
            return null;
        }

        return responseDao.update(entity);
    }

    public void delete(Response entity) {
        if (entity == null) {
            return;
        }

        responseDao.delete(entity);
    }

    public void deleteById(Long entityId) {
        if (entityId == null) {
            return;
        }

        responseDao.deleteById(entityId);
    }

    @Override
    public List<Response> findByQuestion(Long questionId) {
        return List.of();
    }

    @Override
    public List<Response> findCorrectResponsesByQuestion(Long questionId) {
        return List.of();
    }
}
