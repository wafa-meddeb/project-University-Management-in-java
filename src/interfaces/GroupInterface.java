package interfaces;

import entities.Group;
import entities.Module;
import entities.Student;
import entities.Teacher;

import java.util.ArrayList;
import java.util.List;

public interface GroupInterface {

    //students' crud
    public void addStudent(Student std);
    public void removeStudent(int index);
    public void updateStudent(int index, Group.StudentComponents featureToUpdate, Object newInfo);
    public Student getStudent(int index);
    public List<Student> getStudentByCriteria(Group.StudentComponents criteria, Object criteriaContent);

    //teachers' crud
    public void addTeacher(Teacher teacher);
    public void removeTeacher(int index);
    public void updateTeacher(int index, Group.TeacherComponents featureToUpdate, Object newInfo);
    public Teacher getTeacher(int index);

    public List<Teacher> getTeacherByCriteria(Group.TeacherComponents criteria, Object criteriaContent);

    //modules' crud
    public void addModule(Module module);
    public void removeModule(int index);
    public void updateModule(int index, Group.ModuleComponents featureToUpdate, Object newInfo);
    public Module getModule(int index);

    public List<Module> getModuleByCriteria(Group.ModuleComponents criteria, Object criteriaContent);


}