package facade;

import model.Response;

import java.io.Serializable;
import java.util.List;

public interface ResponseDao<K, T extends Serializable> {

    List<Response> findByQuestion(Long questionId);

    List<Response> findCorrectResponsesByQuestion(Long questionId);

}
