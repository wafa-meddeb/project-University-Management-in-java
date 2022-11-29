package entities;

import java.util.Date;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Absence {
        private int Id;
        private java.util.Date Date;
        private String Motif;//not required option
        private String Justification;//not required option
        private int sessionId;
        //il faut faire une instance de type Session pour acceder a sessionId

}
