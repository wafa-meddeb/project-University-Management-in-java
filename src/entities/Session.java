package entities;

import java.time.LocalTime;
import java.util.List;
import enumeration.SessionState;
import enumeration.SessionType;
import lombok.*;
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor

public class Session {
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
    private List<Absence> absenceBySession;
    private static int lastId=0;
    public Session() {
        this.id=++lastId;
    }

    public Session(int id, LocalTime startTime, LocalTime endTime, String classroomNumber, String goal,
                   String summary, String tools, SessionState sessionState, SessionType sessionType, Module module,
                   List<Absence> absenceBySession) {
        this.id = id;
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
    }}
