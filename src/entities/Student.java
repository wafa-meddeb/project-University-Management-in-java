package entities;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Date;

public class Student extends Person {

    private StudentState studentState;
    private StudentSituation situation;
    private Absence studentAbsence;

    private LocalDate birthday;

    private Group group;

    public StudentState getStudentState() {
        return studentState;
    }

    public StudentSituation getSituation() {
        return situation;
    }

    public Absence getStudentAbsence() {
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

    public void setStudentAbsence(Absence studentAbsence) {
        this.studentAbsence = studentAbsence;
    }

    public Student(int Id, String Name, String FamilyName, ImageIcon Photo, StudentState studentState, StudentSituation situation, Absence studentAbsence, LocalDate birthday) {
        super(Id, Name, FamilyName, Photo);
        this.studentState = studentState;
        this.situation = situation;
        this.studentAbsence = studentAbsence;
        this.birthday = birthday;
    }


}
