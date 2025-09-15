package dao;

import model.Question;

public class QuestionDao extends AbstractJpaDao<Long, Question> {
    public QuestionDao() {
        super(Question.class);
    }
}
