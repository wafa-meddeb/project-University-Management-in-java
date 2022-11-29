package entities;

import java.util.Timer;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    private int Id;
    private Timer StartTime;
    private Timer EndTime;
    private int ClassroomNumber;//not required
    private String Goal;
    private String Summary;
    private String tools;//not required
    private int moduleId;
    private SessionState sessionState;
    private SessionType sessionType;

    @ManyToOne
    private Module module;
}
