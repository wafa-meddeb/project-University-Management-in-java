package projectMenu;

import java.util.Scanner;

public class TeacherActionsMenu {
    public static int teacherActionsMenu(){
        System.out.println("please choose one of the choices provided to define your action");
        System.out.println("1. statistics about absenteeism by one group");
        System.out.println("2. statistics about absenteeism by groups");
        System.out.println("3. exit the application");
        int teacherChoice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Votre Choix :");
            teacherChoice = sc.nextInt();

        } while (teacherChoice < 1 || teacherChoice > 3);

        return teacherChoice;

    }
}
