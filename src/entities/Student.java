package entities;

import Enumeration.StudentSituation;
import Enumeration.StudentState;
import interfaces.StudentInterface;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@ToString

public class Student extends Person implements StudentInterface {

    private int id;
    private StudentState studentState;
    private StudentSituation studentSituation;
    private ArrayList<Absence> studentAbsence = new ArrayList<>();
    private LocalDate birthday;

    private Group group;
    private static int lastId = 0;
    public Student() {
        this.id=++lastId;
    }



    public Student( String Name, String FamilyName, String Photo, StudentState studentState, StudentSituation studentSituation, ArrayList<Absence> studentAbsence, LocalDate birthday,Group group) {

        super(Name, FamilyName, Photo);
        this.id = ++lastId;
        this.studentState = studentState;
        this.studentSituation = studentSituation;
        this.studentAbsence = studentAbsence;
        this.birthday = birthday;
        this.group = group;
    }


    @Override
    public String toString() {
        return "\n id: "+id+super.toString()+"\nStudent Absence : "+getStudentAbsence()+"\nStudent State : "+getStudentState()+"\nBirthday : "+getBirthday()+
                "\nStudent Situation"+ getStudentSituation();
    }

    @Override
    public void addAbsence(Absence absence) {
        studentAbsence.add(absence);
    }

    @Override
    public void removeAbsence(int index) {
        int i=0;
        do{
            if (i == index){
                studentAbsence.remove(studentAbsence.get(index));
            }
            else{
                i++;
            }
        }while ((i != index) || (i!=studentAbsence.size()));

    }

    public enum AbsenceComponents{
        date,
        motif,
        justification;

    }
    @Override
    public void updateAbsence(int index, Student.AbsenceComponents featureToUpdate, Object newInfo) {
        int i=0;
        do{

            if (i == index){
                switch(featureToUpdate){
                    case date:
                        studentAbsence.get(index).setDate((LocalDate) newInfo);
                        break;
                    case motif:
                        studentAbsence.get(index).setMotif(((String) newInfo));
                        break;
                    default:
                        studentAbsence.get(index).setJustification((String) newInfo);
                }

            }
            else{
                i++;
            }
        }while ((i != index) || (i!=studentAbsence.size()));
        if ((i == studentAbsence.size()) && (i != index)){
            System.out.println("the Absence you seek to update does not exist ");

        }


    }

    @Override
    public Absence getAbsence(int index) {
        return studentAbsence.get(index);
    }

    @Override
    public List<Absence> getAbsenceByCriteria(AbsenceComponents criteria, Object criteriaContent) {
        ArrayList<Absence> absenceByCriteriaList = new ArrayList<Absence>();
        for (int i = 0; i < studentAbsence.size(); i++) {
            if (studentAbsence.get(i) == criteriaContent) {
                absenceByCriteriaList.add(studentAbsence.get(i));

            }

        }
        return absenceByCriteriaList;
    }


}
