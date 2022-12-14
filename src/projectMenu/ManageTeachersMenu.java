package projectMenu;

import java.util.Scanner;

public class ManageTeachersMenu {
    public static int ManageTeachersMenu() {
        System.out.println("please choose one of the choices provided to define your action");
        System.out.println("1. add a teacher");
        System.out.println("2. update an existing teacher");
        System.out.println("3. remove a teacher");
        System.out.println("4. find teacher details");
        System.out.println("5. find a teacher by a specific criteria");
        System.out.println("6. display all teachers");
        System.out.println("7. affect a module to a teacher");
        System.out.println("8. affect a group to a teacher");
        System.out.println("9. return to menu to choose another action");
        System.out.println("10. return to menu to manage another entity");
        System.out.println("11. exit the application");
        int teacherActionChoice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Votre Choix :");
            teacherActionChoice = sc.nextInt();

        } while (teacherActionChoice < 1 || teacherActionChoice > 11);
        return teacherActionChoice;
    }
}
