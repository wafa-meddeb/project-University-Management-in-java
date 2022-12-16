package interfaces;

import entities.Group;
import entities.Module;
import entities.Teacher;

import java.util.List;

public interface TeacherInterface {
    //Groups' crud
    public void addGroup(Group group);
    public void removeGroup(int index);
    public void updateGroup(int index, Teacher.GroupComponents featureToUpdate, Object newInfo);
    public Group getGroup(int index);
    //    public List<Group> getAllGroups();
    public List<Group> getGroupByCriteria(Teacher.GroupComponents criteria, Object criteriaContent);

    //modules' crud
    public void addModule(Module module);
    public void removeModule(int index);
    public void updateModule(int index, Teacher.ModuleComponents featureToUpdate, Object newInfo);
    public Module getModule(int index);

    public List<Module> getModuleByCriteria(Group.ModuleComponents criteria, Object criteriaContent);
}
