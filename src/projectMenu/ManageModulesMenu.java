package projectMenu;

import java.util.Scanner;

public class ManageModulesMenu {
    public static int ManageModulesMenu() {
        System.out.println("please choose one of the choices provided to define your action");
        System.out.println("1. add a module");
        System.out.println("2. update an existing module");
        System.out.println("3. remove a module");
        System.out.println("4. find module details");
        System.out.println("5. find a module by a specific criteria");
        System.out.println("6. display all module");
        System.out.println("7. return to menu to choose another action");
        System.out.println("8. return to menu to manage another entity");
        System.out.println("9. exit the application");
        int moduleActionChoice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Votre Choix :");
            moduleActionChoice = sc.nextInt();

        } while (moduleActionChoice < 1 || moduleActionChoice > 9);
        return moduleActionChoice;
    }
}
