package entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import enumeration.SessionState;
import enumeration.SessionType;
import interfaces.SessionInterface;
import lombok.*;
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor

public class Session implements SessionInterface {
    private int id;
    private LocalTime startTime;
    private LocalTime endTime;
    private String classroomNumber; //not required
    private String goal;
    private String summary;
    private String tools; //not required
    private SessionState sessionState;
    private SessionType sessionType;

    private Module module;
    private ArrayList<Absence> absenceBySession=new ArrayList<>();
    private static int lastId=0;
    public Session() {
        this.id=++lastId;
    }

    public Session( LocalTime startTime, LocalTime endTime, String classroomNumber, String goal,
                   String summary, String tools, SessionState sessionState, SessionType sessionType, Module module,
                   ArrayList<Absence> absenceBySession) {
        this.id=++lastId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.goal = goal;
        this.summary = summary;
        this.sessionState = sessionState;
        this.sessionType = sessionType;
        this.module = module;
        this.absenceBySession = absenceBySession;
        if (tools != null){
            this.tools = tools;
        }
        else{
            this.tools = null ;
        }
        if (classroomNumber != null){
            this.classroomNumber = classroomNumber;
        }
        else{
            this.classroomNumber = null ;
        }
    }

    @Override
    public String toString() {
        return "Id : "+id+"\nStartTime : "+getStartTime()+"\nEnd Time : "+getEndTime()+"\nGoal : "+getGoal()
                +"\nSummary : "+getSummary()+"\nTools : "+getTools()+"\nSession State : "+getSessionState()+"\nSession Type : "+getSessionType()
                +"\nAbsence by session : "+getAbsenceBySession();
    }



    @Override
    public void addAbsence(Absence absence) {
        absenceBySession.add(absence);
    }

    @Override
    public void removeAbsence(int index) {
        int i=0;
        do{
            if (i == index){
                absenceBySession.remove(absenceBySession.get(index));
            }
            else{
                i++;
            }
        }while ((i != index) || (i!=absenceBySession.size()));

    }

    public enum AbsenceComponents{
        date,
        motif,
        justification;

    }
    @Override
    public void updateAbsence(int index, Session.AbsenceComponents featureToUpdate, Object newInfo) {
        int i=0;
        do{

            if (i == index){
                switch(featureToUpdate){
                    case date:
                        absenceBySession.get(index).setDate((LocalDate) newInfo);
                        break;
                    case motif:
                        absenceBySession.get(index).setMotif(((String) newInfo));
                        break;
                    default:
                        absenceBySession.get(index).setJustification((String) newInfo);
                }

            }
            else{
                i++;
            }
        }while ((i != index) || (i!=absenceBySession.size()));
        if ((i == absenceBySession.size()) && (i != index)){
            System.out.println("the Absence you seek to update does not exist ");

        }

    }

    @Override
    public Absence getAbsence(int index) {
        return absenceBySession.get(index);
    }


    @Override
    public List<Absence> getAbsenceByCriteria(AbsenceComponents criteria, Object criteriaContent) {
        ArrayList<Absence> absenceByCriteriaList = new ArrayList<Absence>();
        for (int i = 0; i < absenceBySession.size(); i++) {
            if (absenceBySession.get(i) == criteriaContent) {
                absenceByCriteriaList.add(absenceBySession.get(i));

            }

        }
        return absenceByCriteriaList;
    }


}
