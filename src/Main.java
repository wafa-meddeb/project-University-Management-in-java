
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
                                        switch(stdMngChoice) {
                                            case 1:
                                                //add a student
                                                p = new Student();
                                                System.out.println("first Name: ");
                                                ((Student) p).setName(sc.nextLine());
                                                System.out.println("last Name: ");
                                                ((Student) p).setFamilyName(sc.nextLine());
                                                System.out.println("photo url: ");
                                                ((Student) p).setPhoto(sc.nextLine());

                                                int stdState;
                                                do {
                                                    System.out.println("student state: \n 1: Present \n 2: Absent \n 3: Delayed \n 4: Excluded ");
                                                    stdState = sc.nextInt();
                                                    if (stdState == 1)
                                                        ((Student) p).setStudentState(StudentState.Present);
                                                    else if (stdState == 2)
                                                        ((Student) p).setStudentState(StudentState.Absent);
                                                    else if (stdState == 3)
                                                        ((Student) p).setStudentState(StudentState.Delayed);
                                                    else
                                                        ((Student) p).setStudentState(StudentState.Excluded);
                                                } while ((stdState < 1) || (stdState > 4));


                                                int stdSituation;
                                                do {
                                                    System.out.println("student situation: New / Repeating / Derogatory / other ");
                                                    stdSituation = sc.nextInt();
                                                    if (stdSituation == 1)
                                                        ((Student) p).setStudentSituation(StudentSituation.New);
                                                    if (stdSituation == 2)
                                                        ((Student) p).setStudentSituation(StudentSituation.Repeating);
                                                    if (stdSituation == 3)
                                                        ((Student) p).setStudentSituation(StudentSituation.Derogatory);
                                                    if (stdSituation == 4)
                                                        ((Student) p).setStudentSituation(StudentSituation.other);
                                                } while ((stdSituation < 1) || (stdSituation > 4));

                                                System.out.println("birthday: (year-month-day) ");
                                                ((Student) p).setBirthday(LocalDate.parse(sc.nextLine()));
                                                System.out.println("do you want to add an absence for this student?");
                                                System.out.println("type: Y:yes or N:No");
                                                char response = sc.next().charAt(0);
                                                if (response == 'Y') {
                                                    System.out.println("absence list: ");
                                                    System.out.println("what is the date of the absence? ");
                                                    newAbsence.setDate((LocalDate.parse(sc.nextLine())));
                                                    ((Student) p).addAbsence(newAbsence);
                                                } else
                                                    newAbsence = null;
                                                ((Student) p).addAbsence(newAbsence);


                                                System.out.println("group name: ");
                                                ((Student) p).getGroup().setName(sc.next());
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
                                                grp.updateStudent(stdId, StudentComponents.valueOf(stdFeature), stdNewInfo);


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
                                                g.getStudentByCriteria(StudentComponents.valueOf(criteria), criteriaCont);
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
                                        switch(sessionsMngChoice) {
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
                                                Character response = sc.next().charAt(0);
                                                if ((Character.toUpperCase(response)) == 'P') {
                                                    System.out.println("classroom number ");
                                                    String classNbre = sc.nextLine();
                                                } else {
                                                    String classNbre = null;
                                                }

                                                System.out.println("session Goal: ");
                                                String goal = sc.nextLine();
                                                System.out.println("session summary: ");
                                                String summary = sc.nextLine();

                                                System.out.println("do you want to enter information about the tools used during the session?  ");
                                                System.out.println("type: 'y': yes");
                                                System.out.println("type: 'n': no");
                                                Character res = sc.next().charAt(0);
                                                if ((Character.toUpperCase(res)) == 'Y') {
                                                    System.out.println("tools: ");
                                                    String tools = sc.nextLine();
                                                } else {
                                                    String tools = null;
                                                }

                                                int sessState;
                                                do {
                                                    System.out.println("session state: \n 1: running \n 2:  achieved  \n 3: canceled \n 4: delayed ");
                                                    sessState = sc.nextInt();
                                                    if (sessState == 1)
                                                        sess.setSessionState(SessionState.Running);
                                                    if (sessState == 2)
                                                        sess.setSessionState(SessionState.Achieved);
                                                    if (sessState == 3)
                                                        sess.setSessionState(SessionState.Canceled);
                                                    if (sessState == 4)
                                                        sess.setSessionState(SessionState.Delayed);


                                                } while ((sessState < 1) || (sessState > 4));

                                                int sessType;
                                                do {
                                                    System.out.println("session type: \n 1: normal \n 2: catching-up \n 3: support \n 4: training ");
                                                    sessType = sc.nextInt();
                                                    if (sessType == 1)
                                                        sess.setSessionType(SessionType.Normal);
                                                    if (sessType == 2)
                                                        sess.setSessionType(SessionType.Catching_up);
                                                    if (sessType == 3)
                                                        sess.setSessionType(SessionType.Support);
                                                    if (sessType == 4)
                                                        sess.setSessionType(SessionType.Training);
                                                } while ((sessType < 1) || (sessType > 4));


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
                                                module2.getSessionByCriteria(Module.SessionComponents.valueOf(criteria), criteriaCont);
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
                        Module module = new Module();
                        do {
                            switch (teacherActionChoice) {
                                case 1:
                                    //absenteeism by one group
                                    int studentsAbsenteeisme =0;

                                    System.out.println("******absenteeism rate by one group******");
                                    System.out.println("enter the group id: ");
                                    int choix = sc.nextInt();

                                    for(int i = 0;i<module.getGroups().get(choix-1).getStudents().size();i++){

                                        studentsAbsenteeisme += module.getGroups().get(choix-1).getStudents().get(i).getStudentAbsence().size();


                                    }
                                    System.out.println("mean of absence by group = "+ studentsAbsenteeisme/module.getGroups().get(choix-1).getStudentsNumber());
                                    break;
                                case 2:
                                    //absenteeism by  groups
                                    int totalStdNbre = 0;
                                    int absenteeismByGrps =0;
                                    int grpListAbsenteeism =0;
                                    for(int i=0;i<module.getGroups().size();i++){
                                        for(int j=0;i<module.getGroups().get(j).getStudents().size();j++){
                                            grpListAbsenteeism += module.getGroups().get(j).getStudents().get(j).getStudentAbsence().size();

                                        }
                                        totalStdNbre += module.getGroups().get(i).getStudentsNumber();
                                    }

                                    System.out.println("mean of absence by groups = "+ grpListAbsenteeism/totalStdNbre);


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
