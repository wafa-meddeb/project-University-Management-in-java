
import entities.*;
import entities.Module;
import Enumeration.*;
import projectMenu.ManageModulesMenu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static projectMenu.AdminActionMenu.adminActionMenu;
import static projectMenu.ManageGroupMenu.ManageGroupMenu;
import static projectMenu.ManageTeachersMenu.ManageTeachersMenu;
import static projectMenu.MenuPrincipal.mainMenu;
import static projectMenu.TeacherActionsMenu.teacherActionsMenu;
import static projectMenu.ManageStudentsMenu.ManageStudentsMenu;
import static projectMenu.ManageSessionsMenu.ManageSessionsMenu;
import static projectMenu.ManageModulesMenu.ManageModulesMenu;

public class Main {

        public static void main(String[] args) {

            ArrayList < Module> modulesList= new ArrayList < Module>();
            ArrayList<Session> sessionsList =new ArrayList<>();
            ArrayList<Teacher> teachersList =new ArrayList<>();
            ArrayList<Student> studentsList =new ArrayList<>();
            ArrayList<Absence> absenceslist = new ArrayList<>();
            ArrayList<Module> moduleslist = new ArrayList<>();
            ArrayList<Group> groupsList =new ArrayList<>();


            ArrayList<Group> groupsListModule1 =new ArrayList<>();
            ArrayList<Group> groupsListModule2 =new ArrayList<>();


            Group group1=new Group("grp1",20,"2021-2022-2Lmad1@esprit.tn","2lmad",moduleslist,studentsList,teachersList);
            Group group2=new Group("grp2",18,"2021-2022-2Lmad2@esprit.tn","2lmad",moduleslist,studentsList,teachersList);
            groupsList.add(group1);
            groupsList.add(group2);


            Module module1 = new Module("algebre",36.5f,"2lmad",ModuleType.Required,sessionsList,teachersList,groupsListModule1);
            modulesList.add(module1);
            System.out.println("******************* Modules ******************************");
            System.out.println(modulesList);
            System.out.println("-------- Modules group 1 --------");
            group1.getGroupModules().add(module1);
            System.out.println(group1.getGroupModules());
            System.out.println("-------- Modules group 2 --------");
            group2.getGroupModules().add(module1);
            System.out.println(group2.getGroupModules());


            Session session = new Session();
            Session session1 = new Session(LocalTime.parse("10:00:00"),LocalTime.parse("11:20:00"),"E-1-2",null,null,null,SessionState.Running,SessionType.Catching_up,module1,session.getAbsenceBySession());
            Session session2 = new Session(LocalTime.parse("13:00:00"),LocalTime.parse("14:20:00"),"A-1-2",null,null,null,SessionState.Running,SessionType.Catching_up,module1,session.getAbsenceBySession());
            sessionsList.add(session1);
            sessionsList.add(session2);
            System.out.println("*************** Sessions ******************************");
            System.out.println(sessionsList);

            module1.getSessions().add(session1);
            module1.getSessions().add(session2);
            System.out.println("-------- Module 1 sessions --------");
            System.out.println(module1.getSessions());

            module1.getGroups().add(group1);
            module1.getGroups().add(group2);
            System.out.println("-------- Module 1 groups ------------");
            System.out.println(module1.getGroups());




            Student student = new Student();
            Student std1 = new Student("ines","said","ImagePath",StudentState.Present,StudentSituation.New,student.getStudentAbsence(), LocalDate.of(2000,05,19),group1);
            Student std2 = new Student("saief","meddeb","ImagePath",StudentState.Present,StudentSituation.New,student.getStudentAbsence(), LocalDate.of(1994,05,12),group2);
            studentsList.add(std1);
            studentsList.add(std2);
            System.out.println("*************** Students ******************************");
            System.out.println(studentsList); //prob affichage id
            group1.getStudents().add(std1);
            System.out.println("-------- group 1 students ----------");
            System.out.println(group1.getStudents());
            group2.getStudents().add(std2);
            System.out.println("-------- group 2 students ----------");
            System.out.println(group2.getStudents());





            Teacher teacher1 = new Teacher("ali","mhethbi","photoPath","ali.mhethbi@gmail.com","ali.mhethbi@esprit.com",8);
            Teacher teacher2 = new Teacher("ali","mwelhi","photoPath","ali.mwelhi@gmail.com","ali.mwelhi@esprit.com",8);
            teachersList.add(teacher1);
            teachersList.add(teacher2);
            System.out.println("*************** Teachers ******************************");
            System.out.println(teachersList); //prob affichage id

            group1.getTeachersByGroup().add(teacher1);
            System.out.println("-------- group 1 teachers ----------");
            System.out.println(group1.getTeachersByGroup());

            group2.getTeachersByGroup().add(teacher2);
            System.out.println("-------- group 2 teachers ----------");
            System.out.println(group2.getTeachersByGroup());


            module1.getTeachers().add(teacher1);
            module1.getTeachers().add(teacher2);
            System.out.println("------ Module 1 teachers -------");
            System.out.println(module1.getTeachers());

            Absence absence = new Absence();
            Absence absence1 =new Absence(LocalDate.of(2022,11,19),null,null,absence.getSessionsWithAbsence());
            Absence absence2 = new Absence(LocalDate.of(2022,11,25),null,null,absence.getSessionsWithAbsence());
            absenceslist.add(absence1);
            absenceslist.add(absence2);
            System.out.println("*************** Absences ******************************");
            System.out.println(absenceslist);

            session1.getAbsenceBySession().add(absence1);
            session1.getAbsenceBySession().add(absence2);
            System.out.println("-------- session1 absences ---------");
            System.out.println(session1.getAbsenceBySession());

            absence1.getSessionsWithAbsence().add(session1);
            System.out.println("------ session 1 with absence -------");

            std1.getStudentAbsence().add(absence1);
//            public double absenteeismByStudent(){
//                double studentAbsenteeisme = (studentAbsence.size()/groupsList.get().getStudentsNumber())*100;
//                return studentAbsenteeisme;
//            }



            int firstChoice;

            do {
                firstChoice =mainMenu();


                switch (firstChoice) {
                    case 1:
                        //admin action
                        int adminActionChoice = adminActionMenu();
                        do {
                            switch (adminActionChoice) {
                                case 1:
                                    //manage students
                                    int stdMngChoice;
                                    do{
                                        stdMngChoice = ManageStudentsMenu();
                                        switch(stdMngChoice){
                                            case 1:
                                                //add a student
                                                break;
                                            case 2:
                                                //update an existing student
                                                break;
                                            case 3:
                                                //remove a student
                                                break;
                                            case 4:
                                                //find student details
                                                break;
                                            case 5:
                                                //find a student by criteria
                                                break;
                                            case 6:
                                                //displayAllStudents
                                                break;
                                            case 7:
                                                //return to menu ManageStudentsMenu
                                                break;
                                            case 8:
                                                //return to AdminActionMenu
                                            default:
                                                System.exit(0);

                                        }
                                    }while(stdMngChoice !=9);



                                    break;
                                case 2:
                                    //manage teachers
                                    int teacherMngChoice;
                                    do{
                                        teacherMngChoice = ManageTeachersMenu();
                                        switch(teacherMngChoice){
                                            case 1:
                                                //add a teacher
                                                break;
                                            case 2:
                                                //update an existing teacher
                                                break;
                                            case 3:
                                                //remove a teacher
                                                break;
                                            case 4:
                                                //find teacher details
                                                break;
                                            case 5:
                                                //find a teacher by criteria
                                                break;
                                            case 6:
                                                //displayAllTeachers
                                                break;
                                            case 7:
                                                //return to menu ManageTeachersMenu
                                                break;
                                            case 8:
                                                //return to AdminActionMenu
                                            default:
                                                System.exit(0);

                                        }
                                    }while(teacherMngChoice !=9);
                                    break;
                                case 3:
                                    //manage groups
                                    int grpMngChoice;
                                    do{
                                        grpMngChoice = ManageGroupMenu();
                                        switch(grpMngChoice){
                                            case 1:
                                                //add a grp
                                                break;
                                            case 2:
                                                //update an existing grp
                                                break;
                                            case 3:
                                                //remove a grp
                                                break;
                                            case 4:
                                                //find grp details
                                                break;
                                            case 5:
                                                //find a grp by criteria
                                                break;
                                            case 6:
                                                //displayAllGroups
                                                break;
                                            case 7:
                                                //return to menu ManageGroupMenu
                                                break;
                                            case 8:
                                                //return to AdminActionMenu
                                            default:
                                                System.exit(0);

                                        }
                                    }while(grpMngChoice !=9);
                                    break;
                                case 4:
                                    //manage sessions
                                    int sessionsMngChoice;
                                    do{
                                        sessionsMngChoice = ManageSessionsMenu();
                                        switch(sessionsMngChoice){
                                            case 1:
                                                //add a session
                                                break;
                                            case 2:
                                                //update an existing session
                                                break;
                                            case 3:
                                                //remove a session
                                                break;
                                            case 4:
                                                //find session details
                                                break;
                                            case 5:
                                                //find a session by criteria
                                                break;
                                            case 6:
                                                //displayAllSessions
                                                break;
                                            case 7:
                                                //return to menu ManageSessionsMenu
                                                break;
                                            case 8:
                                                //return to AdminActionMenu
                                            default:
                                                System.exit(0);

                                        }
                                    }while(sessionsMngChoice !=9);
                                    break;

                                case 5:
                                    //manage modules
                                    int modulesMngChoice;
                                    do{
                                        modulesMngChoice = ManageModulesMenu();
                                        switch(modulesMngChoice){
                                            case 1:
                                                //add a module
                                                break;
                                            case 2:
                                                //update an existing module
                                                break;
                                            case 3:
                                                //remove a module
                                                break;
                                            case 4:
                                                //find module details
                                                break;
                                            case 5:
                                                //find a module by criteria
                                                break;
                                            case 6:
                                                //displayAllModules
                                                break;
                                            case 7:
                                                //return to menu ManageModulesMenu
                                                break;
                                            case 8:
                                                //return to AdminActionMenu
                                            default:
                                                System.exit(0);

                                        }
                                    }while(modulesMngChoice !=9);
                                    break;
                                default:
                                    System.exit(0);
                            }
                        }while(adminActionChoice !=6);
                        break;
                    case 2:
                        //teacher actions : perform some statistics
                        int teacherActionChoice = teacherActionsMenu();
                        do {
                            switch (teacherActionChoice) {
                                case 1:
                                    //absenteeism by one group
                                    int studentsAbsenteeisme =0;

                                    for(int i = 0;i<group1.getStudents().size();i++){
                                        studentsAbsenteeisme += group1.getStudents().get(i).getStudentAbsence().size();


                                    }
                                    System.out.println("moy d'absence par grp= "+ studentsAbsenteeisme/group1.getStudentsNumber());
                                    break;
                                case 2:
                                    //absenteeism by  groups
                                    int absenteeismByGrps =0;
                                    int grpListAbsenteeism =0;
                                    for(int i=0;i<groupsList.size();i++){
                                        for(int j=0;i<groupsList.get(j).getStudents().size();j++){
                                            grpListAbsenteeism += groupsList.get(j).getStudents().get(j).getStudentAbsence().size();
                                        }
                                    }
                                    int totalStdNbre = group1.getStudentsNumber()+group2.getStudentsNumber();
                                    System.out.println("moy d'absence par grp= "+ grpListAbsenteeism/totalStdNbre);


                                    break;

                                default:
                                    System.exit(0);
                            }
                        }while(teacherActionChoice !=3);



                        break;

                    default:
                        System.exit(0);
                }
            }while(firstChoice !=3);

        }
        public void stdStatic (){

        }
    }
