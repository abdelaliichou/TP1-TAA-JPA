package model;

import dao.AbstractJpaDao;
import org.hsqldb.lib.List;

public class DepartmentDao extends AbstractJpaDao<Long, Department> {
    public DepartmentDao() {
        super(Department.class);
    }

    // here we add the custom queries that we want en plus
}
