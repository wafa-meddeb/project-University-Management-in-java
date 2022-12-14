package entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import enumeration.SessionState;
import enumeration.SessionType;
import interfaces.AbsenceInterface;
import lombok.*;
@Getter
@Setter
//@NoArgsConstructor


public class Absence implements AbsenceInterface {
        private int id;
        private LocalDate date;
        private String motif ; //not required option
        private String justification ; //not required
        private ArrayList<Session> sessionsWithAbsence = new ArrayList<>();
        private static int lastId=0;
        public Absence() {
                this.id=++lastId;
        }

        public Absence( LocalDate date, String motif, String justification, ArrayList<Session> sessionsWithAbsence) {
                this.id = ++lastId;
                this.date = date;
                if (motif != null){
                        this.motif = motif;
                }
                else{
                        this.motif = null ;
                }
                if (justification != null){
                        this.justification = justification;
                }
                else{
                        this.justification = null ;
                }
                this.sessionsWithAbsence = sessionsWithAbsence;
        }
        @Override
        public String toString() {
                return "Id : "+id+"\nLocal Date : "+getDate()+"\nMotif : "+getMotif()+"\nJustification : "+getJustification()
                        +"\nSession with absence : "+getSessionsWithAbsence()+"\n";
        }

        @Override
        public void addSession(Session session) {
                sessionsWithAbsence.add(session);
        }

        @Override
        public void removeSession(int index) {
                int i=0;
                do{
                        if (i == index){
                                sessionsWithAbsence.remove(sessionsWithAbsence.get(index));
                        }
                        else{
                                i++;
                        }
                }while ((i != index) || (i!=sessionsWithAbsence.size()));

        }

        public enum SessionComponents{
                startTime,
                endTime,
                classroomNumber,
                goal,
                summary,
                tools,
                sessionState,
                sessionType,
                module;


        }
        @Override
        public void UpdateSession(int index, Absence.SessionComponents featureToUpdate, Object newInfo) {
                int i=0;
                do{

                        if (i == index){
                                switch(featureToUpdate){
                                        case startTime:
                                                sessionsWithAbsence.get(index).setStartTime((LocalTime) newInfo);
                                                break;
                                        case endTime:
                                                sessionsWithAbsence.get(index).setEndTime(((LocalTime) newInfo));
                                                break;
                                        case classroomNumber:
                                                sessionsWithAbsence.get(index).setClassroomNumber(((String) newInfo));
                                                break;
                                        case goal:
                                                sessionsWithAbsence.get(index).setGoal(((String) newInfo));
                                                break;
                                        case summary:
                                                sessionsWithAbsence.get(index).setSummary(((String) newInfo));
                                                break;
                                        case tools:
                                                sessionsWithAbsence.get(index).setTools(((String) newInfo));
                                                break;
                                        case sessionState:
                                                sessionsWithAbsence.get(index).setSessionState(((SessionState) newInfo));
                                                break;
                                        case sessionType:
                                                sessionsWithAbsence.get(index).setSessionType(((SessionType) newInfo));
                                                break;

                                        default:
                                                sessionsWithAbsence.get(index).setModule((Module) newInfo);

                                }

                        }
                        else{
                                i++;
                        }
                }while ((i != index) || (i!=sessionsWithAbsence.size()));
                if ((i == sessionsWithAbsence.size()) && (i != index)){
                        System.out.println("the session you seek to update does not exist ");

                }

        }

        @Override
        public Session GetSession(int index) {
                return sessionsWithAbsence.get(index);
        }

        @Override
        public List<Session> GetByCriteriaSession(SessionComponents criteria, Object criteriaContent) {

                ArrayList<Session> sessionByCriteriaList = new ArrayList<Session>();
                for (int i = 0; i < sessionsWithAbsence.size(); i++) {

                        if (sessionsWithAbsence.get(i) == criteriaContent) {
                                sessionByCriteriaList.add(sessionsWithAbsence.get(i));

                        }


                }
                return sessionByCriteriaList;
        }
}
