
import entities.*;
import interfaces.*;
import Enumeration.*;

import java.time.LocalDate;
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

                                    Group grp1 = new Group();
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
                                   //absenteeism by student
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
