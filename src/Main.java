
import entities.*;
import entities.Module;
import interfaces.*;
import Enumeration.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        public static int mainMenu()
        {
            System.out.println("please choose one of the choices provided to identify yourself");
            System.out.println("1. admin");
            System.out.println("2. teacher");
            System.out.println("3. exit the application");
            int mainChoice;
            Scanner sc=new Scanner(System.in);
            do{
                System.out.println("Votre Choix :");
                mainChoice =sc.nextInt();

            }while(mainChoice <1|| mainChoice >3);
            return mainChoice;
        }
    public static int adminActionMenu() {
        System.out.println("please choose one of the choices provided to define your action");
        System.out.println("1. manage students");
        System.out.println("2. manage teachers");
        System.out.println("3. manage groups");
        System.out.println("4. manage sessions");
        System.out.println("5. manage modules");
        System.out.println("6. exit the application");
        int secondChoice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Votre Choix :");
            secondChoice = sc.nextInt();

        } while (secondChoice < 1 || secondChoice > 6);
        return secondChoice;
    }
    public static int teacherActionsMenu(){
        System.out.println("please choose one of the choices provided to define your action");
        System.out.println("1. statistics about absenteeism by group");
        System.out.println("2. statistics about absenteeism by student");
        System.out.println("3. exit the application");
        int teacherChoice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Votre Choix :");
            teacherChoice = sc.nextInt();

        } while (teacherChoice < 1 || teacherChoice > 3);

        return teacherChoice;

    }
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
//            System.out.println("-------- Modules group 1 --------");
//            group1.getGroupModules().add(module1);
//            System.out.println(group1.getGroupModules());
//            System.out.println("-------- Modules group 2 --------");
//            group2.getGroupModules().add(module1);
//            System.out.println(group2.getGroupModules());


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
                                    //add

                                    //Group grp1 = new Group();
                                    //Student std1 = new Student(1235,"saief","meddeb","010",StudentState.Present,StudentSituation.New,null, LocalDate.now());
                                    //grp1.addStudent(std1);


                                    break;
                                case 2:
                                    //manage teachers
                                    break;
                                case 3:
                                    //manage groups
                                    break;
                                case 4:
                                    //manage sessions
                                    break;
                                case 5:
                                    //manage modules
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
                                    //absenteeism by group
                                    break;
                                case 2:


                                   Scanner sc = new Scanner(System.in);
                                    System.out.println("please enter the student id ");
                                    int studentId = sc.nextInt();
                                    int i =0;
                                    boolean test=false;
                                    double studentAbsenteeisme=0;
                                    do{
                                        if (studentId == studentsList.get(i).getId()){
                                            test = true;
                                            std1 = studentsList.get(i);
//                                            studentAbsenteeisme = ()*100;

                                        }
                                        else{
                                            i++;
                                        }
                                    }while((i<studentsList.size())&&(test==false));
                                    if (test == true){
                                        System.out.println("the absenteeism rate of the student is equal to : "+studentAbsenteeisme);

                                }
                                    else{
                                        System.out.println("the student does not exist");
                                    }

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
    }
