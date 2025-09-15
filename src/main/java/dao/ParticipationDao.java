package dao;

import model.Participation;
import model.Player;
import model.Utils;
import org.hsqldb.lib.List;

public class ParticipationDao extends AbstractJpaDao<Long, Participation> {
    public ParticipationDao() {
        super(Participation.class);
    }
}
