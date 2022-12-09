package interfaces;

import entities.Absence;
import entities.Session;

import java.time.LocalDate;
import java.util.List;

public interface SessionInterface {

    //absences' crud
    public void addAbsence(Absence absence);
    public void removeAbsence(int index);
    public void updateAbsence(int index, Session.AbsenceComponents featureToUpdate, Object newInfo);
    public Absence getAbsence(int index);
//    public List<Absence> getAllAbsences();
    public List<Absence> getAbsenceByCriteria(Object criteria);
}
