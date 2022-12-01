package entities;
import lombok.*;
import java.util.List;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Module {
    private int Id;
    private static String Name;
    private float Due;
    private String StudyLevel;
    private ModuleType moduleType;

    private List<Session> sessions ;
    private List<Teacher> teachers ;
    private List<Group> groups ;

}
