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
    //relation between session and module
    private ModuleType moduleType;
    //la relation entre teacher et module

    private List<Session> sessions ;
    private List<Teacher> teachers ;
    private List<Group> groups ;

}
