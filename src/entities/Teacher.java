package entities;

import Enumeration.ModuleType;
import interfaces.TeacherInterface;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//@NoArgsConstructor
@ToString

public class Teacher extends Person implements TeacherInterface {

    private int id;
    private String personalEmail;
    private String workEmail;
    private float Due;

    private ArrayList<Module> teacherModules = new ArrayList<>() ;
    private ArrayList<Group> groupsByTeacher = new ArrayList<>() ;

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public int getId() {
        return id;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public float getDue() {
        return Due;
    }

    public void setDue(float due) {
        this.Due = due;
    }
    private static int lastId = 0;
    public Teacher() {
        this.id=++lastId;
    }


    public Teacher( String Name, String FamilyName, String Photo, String personalEmail, String workEmail, float due) {
        super( Name, FamilyName,Photo);
        this.id=++lastId;
        this.personalEmail = personalEmail;
        this.workEmail = workEmail;
        this.Due = due;
    }

    @Override
    public String toString() {
        return "\n id: "+id+super.toString()+"\npersonal email : "+getPersonalEmail()+"\nwork email : "+getWorkEmail()+"\nDue : "+getDue();
    }

    @Override
    public void addGroup(Group group) {
        groupsByTeacher.add(group);
    }

    @Override
    public void removeGroup(int index) {
            int i=0;
            do{
                if (i == index){
                    groupsByTeacher.remove(groupsByTeacher.get(index));
                }
                else{
                    i++;
                }
            }while ((i != index) || (i!=groupsByTeacher.size()));


        }

    public enum GroupComponents{
        name,
        studentsNumber,
        email,
        studyLevel;


    }
    @Override
    public void updateGroup(int index, Teacher.GroupComponents featureToUpdate, Object newInfo) {
        int i=0;
        do{

            if (i == index){
                switch(featureToUpdate){
                    case name:
                        groupsByTeacher.get(index).setName((String) newInfo);
                        break;
                    case studentsNumber:
                        groupsByTeacher.get(index).setStudentsNumber(((int) newInfo));
                        break;
                    case email:
                        groupsByTeacher.get(index).setEmail(((String) newInfo));
                        break;

                    default:
                        groupsByTeacher.get(index).setStudyLevel((String) newInfo);

                }

            }
            else{
                i++;
            }
        }while ((i != index) || (i!=groupsByTeacher.size()));
        if ((i == groupsByTeacher.size()) && (i != index)){
            System.out.println("the group you seek to update does not exist ");

        }

    }

    @Override
    public Group getGroup(int index) {
        return groupsByTeacher.get(index);
    }

    @Override
    public List<Group> getGroupByCriteria(GroupComponents criteria, Object criteriaContent) {
        ArrayList<Group> groupByCriteriaList = new ArrayList<Group>();
        for (int i = 0; i < groupsByTeacher.size(); i++) {
            if (groupsByTeacher.get(i) == criteriaContent) {
                groupByCriteriaList.add(groupsByTeacher.get(i));

            }

        }
        return groupByCriteriaList;
    }

    @Override
    public void addModule(Module module) {
        teacherModules.add(module);

    }

    @Override
    public void removeModule(int index) {
        int i=0;
        do{
            if (i == index){
                teacherModules.remove(teacherModules.get(index));
            }
            else{
                i++;
            }
        }while ((i != index) || (i!=teacherModules.size()));

    }

    public enum ModuleComponents{
        due,
        studyLevel,
        moduleType;

    }

    @Override
    public void updateModule(int index, Teacher.ModuleComponents featureToUpdate, Object newInfo) {
        int i=0;
        do{

            if (i == index){
                switch(featureToUpdate){

                    case due:
                        teacherModules.get(index).setDue(((float) newInfo));
                        break;
                    case studyLevel:
                        teacherModules.get(index).setStudyLevel(((String) newInfo));
                        break;

                    default:
                        teacherModules.get(index).setModuleType((ModuleType) newInfo);

                }

            }
            else{
                i++;
            }
        }while ((i != index) || (i!=teacherModules.size()));
        if ((i == teacherModules.size()) && (i != index)){
            System.out.println("the module you seek to update does not exist ");

        }

    }

    @Override
    public Module getModule(int index) {
        return teacherModules.get(index);
    }

    @Override
    public List<Module> getModuleByCriteria(Group.ModuleComponents criteria, Object criteriaContent) {
        ArrayList<Module> moduleByCriteriaList = new ArrayList<Module>();
        for (int i = 0; i < teacherModules.size(); i++) {

            if (teacherModules.get(i) == criteriaContent) {
                moduleByCriteriaList.add(teacherModules.get(i));

            }


        }
        return moduleByCriteriaList;
    }
}
