package interfaces;

import entities.Module;
import entities.Student;
import entities.Teacher;

import java.util.ArrayList;
import java.util.List;

public interface GroupInterface {

    //students' crud
    public void addStudent(Student std);
    public void removeStudent(String name,String familyName);
    public void updateStudent(String name,String familyName);
    public Student getStudent(String name,String familyName);
    public ArrayList<Student> getAllStudents();
    public List<Student> getStudentByCriteria(Object criteria);

    //teachers' crud
    public void addTeacher(Teacher teacher);
    public void removeTeacher(String name,String familyName);
    public void updateTeacher(String name,String familyName);
    public Teacher getTeacher(String name,String familyName);
    public List<Teacher> getAllTeachers();
    public List<Teacher> getTeacherByCriteria(Object criteria);

    //modules' crud
    public void addModule(Module module);
    public void removeModule(String name);
    public void updateModule(String name);
    public Student getModule(String name);
    public List<Student> getAllModules();
    public List<Student> getModuleByCriteria(Object criteria);


}
