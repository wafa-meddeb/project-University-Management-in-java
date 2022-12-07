package entities;
import interfaces.GroupInterface;
import lombok.*;

import java.util.List;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
public class Group /*implements GroupInterface*/ {
    private int id;
    private String name;
    private int studentsNumber;
    private String email;
    private String studyLevel;

    private List<Module> groupModules ;
    private List<Student> students ;
    private List<Teacher> teachersByGroup ;
    private static int lastId=0;
    public Group() {
        this.id=++lastId;
    }
    @Override
    public String toString() {
        return "Id : "+id+"\nName : "+getName()+"\nStudent Number : "+getStudentsNumber()+"\nEmail : "+getEmail()
                +"\nStudey Level : "+getStudyLevel()+"\nList of Group Modules : "+getGroupModules()+"\nList of Students : "+getStudents()+
                "\nList of Teachers"+getTeachersByGroup();
    }


//    @Override
//    public void renameStudent(int index, String name) {
//        students.get(index).setName(name) ;
//    }
}
