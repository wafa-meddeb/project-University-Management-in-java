
import entities.Person;
import entities.Session;
import entities.Student;
import Enumeration.SessionState;
import Enumeration.SessionType;
import Enumeration.StudentSituation;
import Enumeration.StudentState;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Person person=new Person();
        person.setId(45445);
        person.setName("malek");
        person.setFamilyName("kammoun");
        //person.setPhoto();
        Student malek = new Student();
        malek.setId(12345);
        malek.setStudentState(StudentState.Present);
        malek.setBirthday(LocalDate.of(2002,04,07));
        malek.setName("malek");
        malek.setFamilyName("kammoun");
        malek.setStudentSituation(StudentSituation.New);
//        malek.setStudentAbsence();
        //malek.setPhoto(); kifech ndakhlou photo?
        Session Java=new Session();
        Java.setId(84579);
        Java.setGoal("leader");
        Java.setStartTime(LocalTime.of(12,45,56));
        Java.setEndTime(LocalTime.of(15,45,56));
        Java.setClassroomNumber("A-2-2");
        Java.setSummary("sommaire");
        Java.setTools("Facile");
        Java.setSessionState(SessionState.Achieved);
        Java.setSessionType(SessionType.Normal);
        //Java.setAbsenceBySession([1,2,3]);
        System.out.println(malek.toString());
        System.out.println(Java.toString());

    }
}