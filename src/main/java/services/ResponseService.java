package services;

import model.Response;

import java.util.List;

public class ResponseService implements  facade.ResponseDao {

    // TODO same communication logic with the dao classes as we did the playerService class

    @Override
    public List<Response> findByQuestion(Long questionId) {
        return List.of();
    }

    @Override
    public List<Response> findCorrectResponsesByQuestion(Long questionId) {
        return List.of();
    }
}
