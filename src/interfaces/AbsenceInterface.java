package interfaces;

import entities.Session;

import java.util.List;

public interface AbsenceInterface {

    //sessions' crud
    public void addSession(Session session);
    public void removeSession(int id);
    public void updateSession(int id);
    public Session getSession(int id);
    public List<Session> getAllSessions();
    public List<Session> getSessionByCriteria(Object criteria);
}
