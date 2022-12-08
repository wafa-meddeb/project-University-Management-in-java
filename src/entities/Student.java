package entities;

import Enumeration.StudentSituation;
import Enumeration.StudentState;
import lombok.ToString;
import java.time.LocalDate;
import java.util.List;


@ToString

public class Student extends Person {

    private StudentState studentState;
    private StudentSituation studentSituation;
    private List<Absence> studentAbsence;
    private LocalDate birthday;

    private Group group;

    public StudentState getStudentState() {
        return studentState;
    }

    public StudentSituation getStudentSituation() {
        return studentSituation;
    }

    public List<Absence> getStudentAbsence() {
        return studentAbsence;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setStudentState(StudentState studentState) {
        this.studentState = studentState;
    }

    public void setStudentSituation(StudentSituation studentSituation) {
        this.studentSituation = studentSituation;
    }
    public void setStudentAbsence(List<Absence> studentAbsence) {
        this.studentAbsence = studentAbsence;
    }

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
