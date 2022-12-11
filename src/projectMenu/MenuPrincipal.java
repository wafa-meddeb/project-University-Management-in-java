package projectMenu;

import java.util.Scanner;

public class MenuPrincipal {
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
}
