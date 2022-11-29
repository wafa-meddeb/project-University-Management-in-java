package entities;
import lombok.*;
import java.persistence.*;
import java.util.List;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Module {
    private int Id;
    private String Name;
    private int Due;
    private String StudyLevel;
    //relation between session and module
    private ModuleType moduleType;
    //la relation entre teacher et module

    @OneToMany
    List<Session> sessions ;
}
