package interfaces;

import entities.Absence;
import entities.Session;

import java.util.List;

public interface AbsenceInterface {

    //sessions'crud
    public void addSession(Session session);
    public void removeSession(int index);
    public void UpdateSession(int index, Absence.SessionComponents featureToUpdate, Object newInfo);
    public Session GetSession(int index);

    public List<Session> GetByCriteriaSession(Absence.SessionComponents criteria, Object criteriaContent);
}
