package dao;

import model.Quiz;

public class QuizDao extends AbstractJpaDao<Long, Quiz> {
    public QuizDao() {
        super(Quiz.class);
    }
}
