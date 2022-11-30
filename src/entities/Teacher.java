package entities;

import javax.swing.*;
import java.util.List;


public class Teacher extends Person {

    private String personalEmail;
    private String workEmail;
    private float Due;

    private List<Module> teacherModules ;
    private List<Group> groupsByTeacher ;  //many to many or one to many ???

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public float getDue() {
        return Due;
    }

    public void setDue(float due) {
        this.Due = due;
    }


    public Teacher(int Id, String Name, String FamilyName, ImageIcon Photo, String personalEmail, String workEmail, float due) {
        super(Id, Name, FamilyName, Photo);
        this.personalEmail = personalEmail;
        this.workEmail = workEmail;
        this.Due = due;
    }
}
