package projectMenu;

import java.util.Scanner;

public class ManageGroupMenu {
    public static int ManageGroupMenu() {
        System.out.println("please choose one of the choices provided to define your action");
        System.out.println("1. add a group");
        System.out.println("2. update an existing group");
        System.out.println("3. remove a group");
        System.out.println("4. find group details");
        System.out.println("5. find a group by a specific criteria");
        System.out.println("6. display all groups");
        System.out.println("7. Affect a module to a group");
        System.out.println("8. Affect a teacher to a group");
        System.out.println("9. return to menu to choose another action");
        System.out.println("10. return to menu to manage another entity");
        System.out.println("11. exit the application");
        int groupActionChoice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Votre Choix :");
            groupActionChoice = sc.nextInt();

        } while (groupActionChoice < 1 || groupActionChoice > 11);
        return groupActionChoice;
    }
}
