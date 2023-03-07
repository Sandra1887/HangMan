import java.util.Scanner;

public class Menu {
    public static void showMainMenu() {
        System.out.println("1. Play");
        System.out.println("2. Add word");
        System.out.println("3. Delete word");
        System.out.println("4. View words");
        System.out.println("5. Exit");
    }

    public static int askForNumber(int min, int max) {
        int choice = 0;
        if(choice > 0 || choice < max) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number between " + min + " and " + max);
            choice = sc.nextInt();
        }
        return choice;
    }
}
