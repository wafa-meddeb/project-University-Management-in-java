
import entities.*;
import entities.Group.StudentComponents;
import entities.Module;
import enumeration.*;
import nnRelations.ModuleGroup;
import nnRelations.ModuleTeacher;
import nnRelations.TeacherGrp;
import projectMenu.AdminActionMenu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

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

            ArrayList < Module> modulesList= new ArrayList <>();
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
            System.out.println(groupsList);


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


            //menu
            int firstChoice;
            Person p;
            Absence newAbsence = null ;
            Scanner sc = new Scanner(System.in);
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
                                                p = new Student();
                                                System.out.println("first Name: ");
                                                ((Student)p).setName(sc.nextLine());
                                                System.out.println("last Name: ");
                                                ((Student)p).setFamilyName(sc.nextLine());
                                                System.out.println("photo url: ");
                                                ((Student)p).setPhoto(sc.nextLine());

//                                                do {
//                                                    System.out.println("student state: Present / Absent / Delayed / Excluded ");
//                                                    ((Student)p).setStudentState(StudentState.valueOf(sc.next()));
//                                                }while (((sc.nextLine()) != "Present") || ((sc.nextLine()) != "Absent") || ((sc.nextLine()) != "Delayed") || ((sc.nextLine()) != "Excluded"));
//
//                                                do{
//                                                    System.out.println("student situatione: New / Repeating / Derogatory / other ");
//                                                    ((Student)p).setStudentSituation(StudentSituation.valueOf(sc.nextLine()));
//                                                }while(((sc.nextLine()) != "New") || ((sc.nextLine()) != "Repeating") || ((sc.nextLine()) != "Derogatory") || ((sc.nextLine()) != "other"));

                                                System.out.println("birthday: (year-month-day) ");
                                                ((Student)p).setBirthday(LocalDate.parse(sc.nextLine()));
                                                System.out.println("absence list: ");
                                                System.out.println("what is the date of the absence? ");
                                                newAbsence.setDate((LocalDate.parse(sc.nextLine())));
                                                ((Student)p).addAbsence(newAbsence);
                                                System.out.println("group name: ");
                                                ((Student)p).getGroup().setName(sc.next());
                                                System.out.println("student added successfully");

                                                break;
                                            case 2:
                                                //update an existing student
                                                Group grp = new Group();
                                                System.out.println("student id: ");
                                                int stdId = sc.nextInt();
                                                System.out.println("what is the feature which you seek to update?");
                                                String stdFeature = sc.next();
                                                System.out.println("what is the new info that you want to add?");
                                                String stdNewInfo = sc.next();
                                                grp.updateStudent(stdId,StudentComponents.valueOf(stdFeature),stdNewInfo);


                                                break;
                                            case 3:
                                                //remove a student
                                                Group group = new Group();
                                                System.out.println("student id: ");
                                                int stdRemovId = sc.nextInt();
                                                group.removeStudent(stdRemovId);


                                                break;
                                            case 4:
                                                //find student details
                                                Group gr = new Group();
                                                System.out.println("student id: ");
                                                int stdShowId = sc.nextInt();
                                                gr.getStudent(stdShowId);

                                                break;
                                            case 5:
                                                //find a student by criteria
                                                Group g = new Group();
                                                System.out.println("criteria: ");
                                                String criteria = sc.next();
                                                System.out.println("what is the content of the criteria?  ");
                                                String criteriaCont = sc.next();
                                                g.getStudentByCriteria(StudentComponents.valueOf(criteria),criteriaCont);
                                                break;
                                            case 6:
                                                //displayAllStudents
                                                Group gp = new Group();
                                                System.out.println(gp.getStudents());
                                                break;
                                            case 7:
                                                //return to menu ManageStudentsMenu
                                                ManageStudentsMenu();
                                                break;
                                            case 8:
                                                //return to AdminActionMenu
                                                AdminActionMenu.adminActionMenu();
                                                break;
                                            default:
                                                System.exit(0);

                                        }
                                    }while(stdMngChoice !=9);



                                    break;
                                case 2:
                                    //manage teachers
                                    int teacherMngChoice;
                                    Group grp = new Group();
                                    Teacher teacher = new Teacher();
                                    do{
                                        teacherMngChoice = ManageTeachersMenu();
                                        switch(teacherMngChoice){
                                            case 1:
                                                //add a teacher
                                                System.out.println("first Name: ");
                                                teacher.setName(sc.nextLine());
                                                System.out.println("last Name: ");
                                                teacher.setFamilyName(sc.nextLine());
                                                System.out.println("photo url: ");
                                                teacher.setPhoto(sc.nextLine());
                                                System.out.println("personal email: ");
                                                teacher.setPersonalEmail(sc.nextLine());
                                                System.out.println("work email: ");
                                                teacher.setWorkEmail(sc.nextLine());
                                                System.out.println("due:  ");
                                                teacher.setDue(sc.nextFloat());
                                                System.out.println("teacher added successfully");
                                                break;
                                            case 2:
                                                //update an existing teacher
                                                System.out.println("teacher id: ");
                                                int teacherId = sc.nextInt();
                                                System.out.println("what is the feature which you seek to update?");
                                                String teacherFeature = sc.next();
                                                System.out.println("what is the new info that you want to add?");
                                                String teacherNewInfo = sc.next();
                                                grp.updateTeacher(teacherId, Group.TeacherComponents.valueOf(teacherFeature), teacherNewInfo);
                                                break;
                                            case 3:
                                                //remove a teacher
                                                System.out.println("teacher id: ");
                                                int teacherRemovId = sc.nextInt();
                                                grp.removeTeacher(teacherRemovId);
                                                break;
                                            case 4:
                                                //find teacher details
                                                System.out.println("teacher id: ");
                                                int teacherShowId = sc.nextInt();
                                                grp.getTeacher(teacherShowId);
                                                break;
                                            case 5:
                                                //find a teacher by criteria
                                                System.out.println("criteria: ");
                                                String criteria = sc.next();
                                                System.out.println("what is the content of the criteria?  ");
                                                String criteriaCont = sc.next();
                                                grp.getTeacherByCriteria(Group.TeacherComponents.valueOf(criteria),criteriaCont);
                                                break;
                                            case 6:
                                                //displayAllTeachers
                                                System.out.println(grp.getTeachersByGroup());
                                                break;
                                            case 7:
                                                //affect a module to a teacher
                                                ModuleTeacher moduleTeacher = new ModuleTeacher();
                                                System.out.println("enter the module id which you want to affect: ");
                                                int moduleId = sc.nextInt();
                                                System.out.println("enter the teacher id : ");
                                                int teachId = sc.nextInt();

                                                moduleTeacher.addModuleTeacher(moduleId,teachId);



                                                break;
                                            case 8:
                                                //affect a grp to a teacher
                                                TeacherGrp teacherGrp = new TeacherGrp();
                                                System.out.println("enter the group id which you want to affect: ");
                                                int grpId = sc.nextInt();
                                                System.out.println("enter the teacher id : ");
                                                int tId = sc.nextInt();
                                                teacherGrp.addGroupTeacher(tId,grpId);


                                                break;
                                            case 9:
                                                //return to menu ManageTeachersMenu
                                                ManageTeachersMenu();
                                                break;
                                            case 10:
                                                //return to AdminActionMenu
                                                AdminActionMenu.adminActionMenu();
                                                break;
                                            default:
                                                System.exit(0);

                                        }
                                    }while(teacherMngChoice !=11);
                                    break;
                                case 3:
                                    //manage groups
                                    Module module = new Module();
                                    int grpMngChoice;
                                    do{
                                        grpMngChoice = ManageGroupMenu();
                                        switch(grpMngChoice){
                                            case 1:
                                                //add a grp
                                                Group group = new Group();
                                                System.out.println("group Name: ");
                                                group.setName(sc.nextLine());
                                                System.out.println("students number: ");
                                                group.setStudentsNumber(sc.nextInt());
                                                System.out.println("group email: ");
                                                group.setEmail(sc.nextLine());
                                                System.out.println("study level: ");
                                                group.setStudyLevel(sc.nextLine());
                                                System.out.println("group added successfully");
                                                break;
                                            case 2:
                                                //update an existing grp
                                                System.out.println("group id: ");
                                                int grpId = sc.nextInt();
                                                System.out.println("what is the feature which you seek to update?");
                                                String grpFeature = sc.next();
                                                System.out.println("what is the new info that you want to add?");
                                                String grpNewInfo = sc.next();
                                                module.updateGroup(grpId, Module.GroupComponents.valueOf(grpFeature), grpNewInfo);
                                                break;
                                            case 3:
                                                //remove a grp
                                                System.out.println("group id: ");
                                                int grpRemovId = sc.nextInt();
                                                module.removeGroup(grpRemovId);
                                                break;
                                            case 4:
                                                //find grp details
                                                System.out.println("group id: ");
                                                int grpShowId = sc.nextInt();
                                                module.getGroup(grpShowId);
                                                break;
                                            case 5:
                                                //find a grp by criteria
                                                System.out.println("criteria: ");
                                                String criteria = sc.next();
                                                System.out.println("what is the content of the criteria?  ");
                                                String criteriaCont = sc.next();
                                                module.getGroupByCriteria(Module.GroupComponents.valueOf(criteria),criteriaCont);
                                                break;
                                            case 6:
                                                //displayAllGroups
                                                System.out.println(module.getGroups());
                                                break;
                                            case 7:
                                                //Affect a module to a group
                                                ModuleGroup modGrp = new ModuleGroup();
                                                System.out.println("enter the module id which you want to affect: ");
                                                int mId = sc.nextInt();
                                                System.out.println("enter the group id : ");
                                                int gId = sc.nextInt();
                                                System.out.println("enter the year : ");
                                                int year = sc.nextInt();

                                                modGrp.addModuleGrp(mId, gId,year);
                                                break;
                                            case 8:
                                                //Affect a teacher to a group
                                                TeacherGrp teacherGrp = new TeacherGrp();
                                                System.out.println("enter the group id : ");
                                                int grId = sc.nextInt();
                                                System.out.println("enter the teacher id : ");
                                                int teachId = sc.nextInt();

                                                teacherGrp.addGroupTeacher(teachId,grId);
                                                break;
                                            case 9:
                                                //return to menu ManageGroupMenu
                                                ManageGroupMenu();
                                                break;
                                            case 10:
                                                //return to AdminActionMenu
                                                AdminActionMenu.adminActionMenu();
                                                break;
                                            default:
                                                System.exit(0);

                                        }
                                    }while(grpMngChoice !=11);
                                    break;
                                case 4:
                                    //manage sessions
                                    int sessionsMngChoice;
                                    Module module2 = new Module();
                                    do{
                                        sessionsMngChoice = ManageSessionsMenu();
                                        switch(sessionsMngChoice){
                                            case 1:
                                                //add a session
                                                Session sess = new Session();
                                                System.out.println("session start time : ");
                                                LocalTime startTime = LocalTime.parse(sc.nextLine());
                                                System.out.println("session end time: ");
                                                LocalTime endTime = LocalTime.parse(sc.nextLine());

                                                System.out.println("online or in person session?  ");
                                                System.out.println("type: 'o': online");
                                                System.out.println("type: 'p': in person");
                                                Character response =sc.next().charAt(0);
                                                if ((Character.toUpperCase(response))=='O'){
                                                    System.out.println("classroom number ");
                                                    String classNbre = sc.nextLine();
                                                }
                                                else{
                                                    String classNbre = null;
                                                }


                                                System.out.println("session Goal: ");
                                                String goal = sc.nextLine();
                                                System.out.println("session summary: ");
                                                String summary = sc.nextLine();

                                                System.out.println("do you want to enter information about the tools used during the session?  ");
                                                System.out.println("type: 'y': yes");
                                                System.out.println("type: 'n': no");
                                                Character res =sc.next().charAt(0);
                                                if ((Character.toUpperCase(res))=='Y'){
                                                    System.out.println("tools: ");
                                                    String tools = sc.nextLine();
                                                }
                                                else{
                                                    String tools = null;
                                                }

//                                                do {
//                                                    System.out.println("session state: running / achieved / canceled / delayed ");
//                                                    String sessState = sc.nextLine() ;
//                                                }while (((sc.nextLine()) != "present") || ((sc.nextLine()) != "absent") || ((sc.nextLine()) != "delayed") || ((sc.nextLine()) != "excluded"));
//
//                                                do{
//                                                    System.out.println("session type: normal / catching-up / support / training ");
//                                                    ((Student)p).setStudentSituation(StudentSituation.valueOf(sc.nextLine()));
//                                                }while(((sc.nextLine()) != "new") || ((sc.nextLine()) != "repeating") || ((sc.nextLine()) != "derogatory") || ((sc.nextLine()) != "other"));


                                                System.out.println("session added successfully");
                                                break;
                                            case 2:
                                                //update an existing session
                                                System.out.println("session id: ");
                                                int sessionId = sc.nextInt();
                                                System.out.println("what is the feature which you seek to update?");
                                                String sessionFeature = sc.next();
                                                System.out.println("what is the new info that you want to add?");
                                                String sessionNewInfo = sc.next();
                                                module2.updateSession(sessionId, Module.SessionComponents.valueOf(sessionFeature), sessionNewInfo);
                                                break;
                                            case 3:
                                                //remove a session
                                                System.out.println("session id: ");
                                                int sessRemovId = sc.nextInt();
                                                module2.removeSession(sessRemovId);
                                                break;
                                            case 4:
                                                //find session details
                                                System.out.println("session id: ");
                                                int sessShowId = sc.nextInt();
                                                module2.getSession(sessShowId);
                                                break;
                                            case 5:
                                                //find a session by criteria
                                                System.out.println("criteria: ");
                                                String criteria = sc.next();
                                                System.out.println("what is the content of the criteria?  ");
                                                String criteriaCont = sc.next();
                                                module2.getSessionByCriteria(Module.SessionComponents.valueOf(criteria),criteriaCont);
                                                break;
                                            case 6:
                                                //displayAllSessions
                                                System.out.println(module2.getSessions());
                                                break;
                                            case 7:
                                                //return to menu ManageSessionsMenu
                                                ManageSessionsMenu();
                                                break;
                                            case 8:
                                                //return to AdminActionMenu
                                                AdminActionMenu.adminActionMenu();
                                                break;
                                            default:
                                                System.exit(0);

                                        }
                                    }while(sessionsMngChoice !=9);
                                    break;

                                case 5:
                                    //manage modules
                                    Group group = new Group();
                                    int modulesMngChoice;
                                    do{
                                        modulesMngChoice = ManageModulesMenu();
                                        switch(modulesMngChoice){
                                            case 1:
                                                //add a module
                                                Module module3 = new Module();
                                                System.out.println("module name: ");
                                                module3.setName(sc.nextLine());
                                                System.out.println("module due: ");
                                                module3.setDue(sc.nextFloat());
                                                System.out.println("study level: ");
                                                module3.setStudyLevel(sc.nextLine());
                                                do{
                                                    System.out.println("module type: optional / required ");
                                                    module3.setModuleType(ModuleType.valueOf(sc.nextLine()));
                                                }while(((sc.nextLine()) != "optional") || ((sc.nextLine()) != "required"));

                                                break;
                                            case 2:
                                                //update an existing module
                                                System.out.println("module id: ");
                                                int moduleId = sc.nextInt();
                                                System.out.println("what is the feature which you seek to update?");
                                                String moduleFeature = sc.next();
                                                System.out.println("what is the new info that you want to add?");
                                                String moduleNewInfo = sc.next();
                                                group.updateModule(moduleId, Group.ModuleComponents.valueOf(moduleFeature), moduleNewInfo);
                                                break;
                                            case 3:
                                                //remove a module
                                                System.out.println("module id: ");
                                                int modRemovId = sc.nextInt();
                                                group.removeModule(modRemovId);
                                                break;
                                            case 4:
                                                //find module details
                                                System.out.println("module id: ");
                                                int modShowId = sc.nextInt();
                                                group.getModule(modShowId);
                                                break;
                                            case 5:
                                                //find a module by criteria
                                                System.out.println("criteria: ");
                                                String criteria = sc.next();
                                                System.out.println("what is the content of the criteria?  ");
                                                String criteriaCont = sc.next();
                                                group.getModuleByCriteria(Group.ModuleComponents.valueOf(criteria),criteriaCont);
                                                break;
                                            case 6:
                                                //displayAllModules
                                                System.out.println(group.getGroupModules());
                                                break;
                                            case 7:
                                                //affect a group to a module
                                                ModuleGroup modGrp = new ModuleGroup();
                                                System.out.println("enter the module id : ");
                                                int mId = sc.nextInt();
                                                System.out.println("enter the group id : ");
                                                int gId = sc.nextInt();
                                                System.out.println("enter the year : ");
                                                int year = sc.nextInt();

                                                modGrp.addModuleGrp(mId, gId,year);
                                                break;
                                            case 8:
                                                //affect a teacher to a module
                                                ModuleTeacher moduleTeacher = new ModuleTeacher();
                                                System.out.println("enter the module id : ");
                                                int modId = sc.nextInt();
                                                System.out.println("enter the teacher id : ");
                                                int teachId = sc.nextInt();

                                                moduleTeacher.addModuleTeacher(modId,teachId);
                                                break;
                                            case 9:
                                                //return to menu ManageModulesMenu
                                                ManageModulesMenu();
                                                break;
                                            case 10:
                                                //return to AdminActionMenu
                                                AdminActionMenu.adminActionMenu();
                                            default:
                                                System.exit(0);

                                        }
                                    }while(modulesMngChoice !=11);
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
