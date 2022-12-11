package entities;
import Enumeration.ModuleType;
import Enumeration.StudentSituation;
import Enumeration.StudentState;
import interfaces.GroupInterface;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Group implements GroupInterface {
    private int id;
    private String name;
    private int studentsNumber;
    private String email;
    private String studyLevel;

    private ArrayList<Module> groupModules = new ArrayList<Module>() ;
    private ArrayList<Student> students = new ArrayList<Student>() ;
    private ArrayList<Teacher> teachersByGroup = new ArrayList<Teacher>() ;
    private static int lastId=0;
    public Group() {
        this.id=++lastId;
    }

    public Group(String name, int studentsNumber, String email, String studyLevel, ArrayList<Module> groupModules, ArrayList<Student> students, ArrayList<Teacher> teachersByGroup) {
        this.id=++lastId;
        this.name = name;
        this.studentsNumber = studentsNumber;
        this.email = email;
        this.studyLevel = studyLevel;
        this.groupModules = groupModules;
        this.students = students;
        this.teachersByGroup = teachersByGroup;
    }

    @Override
    public String toString() {
        return "Id : "+id+"\nName : "+name+"\nStudent Number : "+studentsNumber+"\nEmail : "+email
                +"\nStudent Level : "+studyLevel+"\nList of Group Modules : "+groupModules+"\nList of Students : "+ students+
                "\nList of Teachers"+teachersByGroup;
    }


//    @Override
//    public void renameStudent(int index, String name) {
//        students.get(index).setName(name) ;
//    }


    @Override
    public void addStudent(Student std) {
        students.add(std);


    }

    @Override
    public void removeStudent(int index) {
        int i=0;
        do{
            if (i == index){
                students.remove(students.get(index));
            }
            else{
                i++;
            }
        }while ((i != index) || (i!=students.size()));


    }
    public enum StudentComponents{
        name,
        familyName,
        photo,
        birthday,
        studentState,
        studentSituation,
        studentAbsence,
        group;

    }

    @Override
    public void updateStudent(int index,StudentComponents featureToUpdate,Object newInfo) {
        int i=0;
        do{

            if (i == index){
                switch(featureToUpdate){
                    case name:
                        students.get(index).setName((String) newInfo);
                        break;
                    case familyName:
                        students.get(index).setFamilyName(((String) newInfo));
                        break;
                    case photo:
                        students.get(index).setPhoto(((String) newInfo));
                        break;
                    case birthday:
                        students.get(index).setBirthday(((LocalDate) newInfo));
                        break;
                    case studentState:
                        students.get(index).setStudentState(((StudentState) newInfo));
                        break;
                    case studentSituation:
                        students.get(index).setStudentSituation(((StudentSituation) newInfo));
                        break;
                    case studentAbsence:
                        students.get(index).setStudentAbsence((ArrayList<Absence>) newInfo);
                        break;
                    default:
                        students.get(index).setGroup((Group) newInfo);

                }

            }
            else{
                i++;
            }
        }while ((i != index) || (i!=students.size()));
        if ((i == students.size()) && (i != index)){
            System.out.println("the student you seek to update does not exist ");

        }
    }

    @Override
    public Student getStudent(int index) {
        return students.get(index);
    }

    //getAllStd appel lel getter mta3 arraylist student
    //System.out.println(students.get())

    @Override
    public List<Student> getStudentByCriteria(StudentComponents criteria,Object criteriaContent) {

        ArrayList<Student> StudentByCriteriaList = new ArrayList<Student>();
        for (int i = 0; i < students.size(); i++) {

            if (teachersByGroup.get(i) == criteriaContent) {
                StudentByCriteriaList.add(students.get(i));

            }


        }
        return StudentByCriteriaList;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teachersByGroup.add(teacher);


    }

    @Override
    public void removeTeacher(int index) {
        int i=0;
        do{
            if (i == index){
                teachersByGroup.remove(teachersByGroup.get(index));
            }
            else{
                i++;
            }
        }while ((i != index) || (i!=teachersByGroup.size()));

    }


    public enum TeacherComponents{
        name,
        familyName,
        photo,
        due,
        PersonalEmail,
        WorkEmail;


    }
    @Override
    public void updateTeacher(int index,TeacherComponents featureToUpdate,Object newInfo) {
        int i=0;
        do{

            if (i == index){
                switch(featureToUpdate){
                    case name:
                        teachersByGroup.get(index).setName((String) newInfo);
                        break;
                    case familyName:
                        teachersByGroup.get(index).setFamilyName(((String) newInfo));
                        break;
                    case photo:
                        teachersByGroup.get(index).setPhoto(((String) newInfo));
                        break;
                    case due:
                        teachersByGroup.get(index).setDue(((float) newInfo));
                        break;
                    case PersonalEmail:
                        teachersByGroup.get(index).setPersonalEmail(((String) newInfo));
                        break;

                    default:
                        teachersByGroup.get(index).setWorkEmail((String) newInfo);

                }

            }
            else{
                i++;
            }
        }while ((i != index) || (i!=teachersByGroup.size()));
        if ((i == teachersByGroup.size()) && (i != index)){
            System.out.println("the teacher you seek to update does not exist ");

        }

    }

    @Override
    public Teacher getTeacher(int index) {
        return teachersByGroup.get(index);
    }

    //getAllTeachers() n3mlou appel lel getter mta3 arraylist teachersByGroup

    @Override
    public List<Teacher> getTeacherByCriteria(TeacherComponents criteria,Object criteriaContent) {
        ArrayList<Teacher> teacherByCriteriaList = new ArrayList<Teacher>();
        for (int i = 0; i < teachersByGroup.size(); i++) {
            if (teachersByGroup.get(i) == criteriaContent) {
                teacherByCriteriaList.add(teachersByGroup.get(i));

            }

        }
        return teacherByCriteriaList;
    }

    @Override
    public void addModule(Module module) {
        groupModules.add(module);

    }

    @Override
    public void removeModule(int index) {
        int i=0;
        do{
            if (i == index){
                groupModules.remove(groupModules.get(index));
            }
            else{
                i++;
            }
        }while ((i != index) || (i!=groupModules.size()));

    }


    public enum ModuleComponents{
        due,
        studyLevel,
        moduleType;

    }
    @Override
    public void updateModule(int index,ModuleComponents featureToUpdate,Object newInfo) {
        int i=0;
        do{

            if (i == index){
                switch(featureToUpdate){

                    case due:
                        groupModules.get(index).setDue(((float) newInfo));
                        break;
                    case studyLevel:
                        groupModules.get(index).setStudyLevel(((String) newInfo));
                        break;

                    default:
                        groupModules.get(index).setModuleType((ModuleType) newInfo);

                }

            }
            else{
                i++;
            }
        }while ((i != index) || (i!=groupModules.size()));
        if ((i == groupModules.size()) && (i != index)){
            System.out.println("the module you seek to update does not exist ");

        }

    }

    @Override
    public Module getModule(int index) {
        return groupModules.get(index);
    }



    @Override
    public List<Module> getModuleByCriteria(ModuleComponents criteria,Object criteriaContent) {
        ArrayList<Module> moduleByCriteriaList = new ArrayList<Module>();
        for (int i = 0; i < groupModules.size(); i++) {

            if (groupModules.get(i) == criteriaContent) {
                moduleByCriteriaList.add(groupModules.get(i));

            }


        }
        return moduleByCriteriaList;
    }


}
