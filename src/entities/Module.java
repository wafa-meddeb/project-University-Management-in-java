package entities;
import Enumeration.ModuleType;
import lombok.*;
import java.util.List;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor

public class Module {
    private int id;
    private static String name;
    private float due;
    private String studyLevel;
    private ModuleType moduleType;

    private List<Session> sessions ;
    private List<Teacher> teachers ;
    private List<Group> groups ;
    private static int lastId=0;
    public Module() {
        this.id=++lastId;
    }
    @Override
    public String toString() {
        return "Id : "+id+"\nName : "+Module.name+"\nDue : "+getDue()+"\nStudy Level : "+getStudyLevel()
                +"\nmodule type : "+getModuleType()+"\nSession : "+getSessions()+"\nteachers : "+getTeachers()+
                "\nGroup"+getGroups();
    }

}
