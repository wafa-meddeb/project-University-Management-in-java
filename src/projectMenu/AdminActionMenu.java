package projectMenu;

import java.util.Scanner;

public class AdminActionMenu {
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
}
