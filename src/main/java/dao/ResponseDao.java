package dao;

import model.Response;

public class ResponseDao extends AbstractJpaDao<Long, Response> {
    public ResponseDao() {
        super(Response.class);
    }
}
