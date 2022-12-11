package projectMenu;

import java.util.Scanner;

public class ManageSessionsMenu {
    public static int ManageSessionsMenu() {
        System.out.println("please choose one of the choices provided to define your action");
        System.out.println("1. add a session");
        System.out.println("2. update an existing session");
        System.out.println("3. remove a session");
        System.out.println("4. find session details");
        System.out.println("5. find a session by a specific criteria");
        System.out.println("6. display all sessions");
        System.out.println("7. return to menu to choose another action");
        System.out.println("8. return to menu to manage another entity");
        System.out.println("9. exit the application");
        int sessionActionChoice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Votre Choix :");
            sessionActionChoice = sc.nextInt();

        } while (sessionActionChoice < 1 || sessionActionChoice > 9);
        return sessionActionChoice;
    }
}
