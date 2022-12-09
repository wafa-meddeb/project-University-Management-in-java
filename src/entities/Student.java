package entities;

import Enumeration.StudentSituation;
import Enumeration.StudentState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString

public class Student extends Person {

    private StudentState studentState;
    private StudentSituation studentSituation;
    private List<Absence> studentAbsence;
    private LocalDate birthday;

    private Group group;



    public Student(int Id, String Name, String FamilyName, byte[] Photo, StudentState studentState, StudentSituation studentSituation,
                   List<Absence> studentAbsence, LocalDate birthday) {
        super(Id, Name, FamilyName, Photo);
        this.studentState = studentState;
        this.studentSituation = studentSituation;
        this.studentAbsence = studentAbsence;
        this.birthday = birthday;
    }
    public Student(){}

    @Override
    public String toString() {
        return super.toString()+"\nStudent Absence : "+getStudentAbsence()+"\nStudent State : "+getStudentState()+"\nBirthday : "+getBirthday()+
                "\nStudent Situation"+ getStudentSituation();
    }
}
