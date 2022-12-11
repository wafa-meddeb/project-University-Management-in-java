package projectMenu;

import java.util.Scanner;

public class ManageStudentsMenu {
    public static int ManageStudentsMenu() {
        System.out.println("please choose one of the choices provided to define your action");
        System.out.println("1. add a student");
        System.out.println("2. update an existing student");
        System.out.println("3. remove a student");
        System.out.println("4. find student details");
        System.out.println("5. find a student by a specific criteria");
        System.out.println("6. display all students");
        System.out.println("7. return to menu to choose another action");
        System.out.println("8. return to menu to manage another entity");
        System.out.println("9. exit the application");
        int studentActionChoice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Votre Choix :");
            studentActionChoice = sc.nextInt();

        } while (studentActionChoice < 1 || studentActionChoice > 9);
        return studentActionChoice;
    }
}
