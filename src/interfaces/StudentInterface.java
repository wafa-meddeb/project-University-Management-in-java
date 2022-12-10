package interfaces;

import entities.Absence;
import entities.Session;
import entities.Student;

import java.util.List;

public interface StudentInterface {
    //StudentsAbsences' crud
    public void addAbsence(Absence absence);
    public void removeAbsence(int index);
    public void updateAbsence(int index, Student.AbsenceComponents featureToUpdate, Object newInfo);
    public Absence getAbsence(int index);
    //    public List<Absence> getAllAbsences();
    public List<Absence> getAbsenceByCriteria(Student.AbsenceComponents criteria, Object criteriaContent);
}
