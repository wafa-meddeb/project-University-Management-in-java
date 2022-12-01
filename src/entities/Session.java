package entities;

import java.util.List;
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
    private String ClassroomNumber = null;//not required
    private String Goal;
    private String Summary;
    private String tools = null;//not required
    private SessionState sessionState;
    private SessionType sessionType;

    private Module module;
    private List<Absence> absenceBySession;
}
