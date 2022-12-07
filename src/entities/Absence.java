package entities;

import java.time.LocalDate;
import java.util.List;

import lombok.*;
@Getter
@Setter
//@NoArgsConstructor

public class Absence {
        private int id;
        private LocalDate date;
        private String motif ; //not required option
        private String justification ; //not required
        private List<Session> sessionsWithAbsence;
        private static int lastId=0;
        public Absence() {
                this.id=++lastId;
        }

        public Absence(int id, LocalDate date, String motif, String justification, List<Session> sessionsWithAbsence) {
                id = id;
                date = date;
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
                sessionsWithAbsence = sessionsWithAbsence;
        }
        @Override
        public String toString() {
                return "Id : "+id+"\nLocal Date : "+getDate()+"\nMotif : "+getMotif()+"\nJustification : "+getJustification()
                        +"\nSession with absence : "+getSessionsWithAbsence();
        }
}
