package entities;
import lombok.*;

import java.util.List;

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

    private List<Module> groupModules ;
    private List<Student> students ;
    private List<Teacher> teachersByGroup ;
}
