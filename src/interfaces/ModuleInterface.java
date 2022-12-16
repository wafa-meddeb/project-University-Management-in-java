package interfaces;

import entities.*;
import entities.Module;

import java.util.List;

public interface ModuleInterface {
    //teachers' crud
    public void addTeacher(Teacher teacher);
    public void removeTeacher(int index);
    public void updateTeacher(int index, Module.TeacherComponents featureToUpdate, Object newInfo);
    public Teacher getTeacher(int index);

    public List<Teacher> getTeacherByCriteria(Module.TeacherComponents criteria, Object criteriaContent);

    //sessions' crud
    public void addSession(Session session);
    public void removeSession(int index);
    public void updateSession(int index, Module.SessionComponents featureToUpdate, Object newInfo);
    public Session getSession(int index);

    public List<Session> getSessionByCriteria(Module.SessionComponents criteria, Object criteriaContent);


    //Groups' crud
    public void addGroup(Group group);
    public void removeGroup(int index);
    public void updateGroup(int index, Module.GroupComponents featureToUpdate, Object newInfo);
    public Group getGroup(int index);

    public List<Group> getGroupByCriteria(Module.GroupComponents criteria, Object criteriaContent);

}
