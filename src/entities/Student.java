package entities;

import enumeration.StudentSituation;
import enumeration.StudentState;
import lombok.ToString;
import java.time.LocalDate;
import java.util.List;


@ToString

public class Student extends Person {

    private StudentState studentState;
    private StudentSituation situation;
    private List<Absence> studentAbsence;
    private LocalDate birthday;

    private Group group;

    public StudentState getStudentState() {
        return studentState;
    }

    public StudentSituation getSituation() {
        return situation;
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

    public void setSituation(StudentSituation situation) {
        this.situation = situation;
    }
    public void setStudentAbsence(List<Absence> studentAbsence) {
        this.studentAbsence = studentAbsence;
    }

    public Student(int Id, String Name, String FamilyName, byte[] Photo, StudentState studentState, StudentSituation situation,
                   List<Absence> studentAbsence, LocalDate birthday) {
        super(Id, Name, FamilyName, Photo);
        this.studentState = studentState;
        this.situation = situation;
        this.studentAbsence = studentAbsence;
        this.birthday = birthday;
    }
    public Student(){}

    @Override
    public String toString() {
        return super.toString()+"\nStudent Absence : "+getStudentAbsence()+"\nStudent State : "+getStudentState()+"\nBirthday : "+getBirthday()+
                "\nStudent Situation"+getSituation();
    }
}
