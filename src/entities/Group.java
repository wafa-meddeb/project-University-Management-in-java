package entities;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private int Id;
    private String Name;
    private int StudentsNumber;
    private String email;
    private String StudyLevel;
}
