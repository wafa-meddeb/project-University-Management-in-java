package entities;

import java.time.LocalDate;
import java.util.List;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Absence {
        private int Id;
        private LocalDate Date;
        private String Motif = null;//not required option
        private String Justification = null;//not required

//        private int sessionId;    //s7i7a wela 8alta??
        //il faut faire une instance de type Session pour acceder a sessionId

        private List<Session> SessionsWithAbsence;



}
