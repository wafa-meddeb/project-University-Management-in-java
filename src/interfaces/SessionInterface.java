package interfaces;

import entities.Absence;

import java.time.LocalDate;
import java.util.List;

public interface SessionInterface {

    //absences' crud
    public void addAbsence(Absence absence);
    public void removeAbsence(int id,LocalDate date);
    public void updateAbsence(int id,LocalDate date);
    public Absence getAbsence(int id,LocalDate date);
    public List<Absence> getAllAbsences();
    public List<Absence> getAbsenceByCriteria(Object criteria);
}
