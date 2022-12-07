package interfaces;

import entities.Group;
import entities.Session;
import entities.Teacher;

import java.util.List;

public interface ModuleInterface {
    //teachers' crud
    public void addTeacher(Teacher teacher);
    public void removeTeacher(String name,String familyName);
    public void updateTeacher(String name,String familyName);
    public Teacher getTeacher(String name, String familyName);
    public List<Teacher> getAllTeachers();
    public List<Teacher> getTeacherByCriteria(Object criteria);

    //sessions' crud
    public void addSession(Session session);
    public void removeSession(int id);
    public void updateSession(int id);
    public Session getSession(int id);
    public List<Session> getAllSessions();
    public List<Session> getSessionByCriteria(Object criteria);


    //Groups' crud
    public void addGroup(Group group);
    public void removeGroup(String name);
    public void updateGroup(String name);
    public Group getGroup(String name);
    public List<Group> getAllGroups();
    public List<Group> getGroupByCriteria(Object criteria);

}
