import java.util.Random;
import java.util.Scanner;

public class BankMainMenu {
    private static final int MENU_OPTION_CREATE_ACCOUNT = 1;
    private static final int MENU_OPTION_VIEW_ACCOUNT = 2;
    private static final int MENU_OPTION_DELETE_ACCOUNT = 3;
    private static final Scanner scnr = new Scanner(System.in);
    private static final Random random = new Random();
    public static void bankMenu() {

        System.out.println("----------------------------------------------------------------");
        System.out.println("\t" + MENU_OPTION_CREATE_ACCOUNT + ". Create Account - " + MENU_OPTION_VIEW_ACCOUNT + ". View Account - " + MENU_OPTION_DELETE_ACCOUNT + ". Delete Account");
        System.out.println("----------------------------------------------------------------");
        System.out.print("\nPlease enter a number corresponding to the options above: ");

        // Asks for which menu option and checks if it is a valid input
        switch (validateMenuOption()) {
            case 1:
                BankAccountCreation.initializeAccountCreation();
                break;
            case 2:
                BankAccountCreation.adminViewBankAccount();
                break;
            case 3:
                BankApp.accessViewStrings();
                break;
        }

    }

//    public static void sleep(int milliseconds) {
//
//        try {
//            Thread.sleep(milliseconds);
//        } catch (InterruptedException ignoredException) {
//
//        }
//
//    }

    public static int validateMenuOption() {

        int BANK_MENU_INPUT_OPTION;
        while (!scnr.hasNextInt() || (BANK_MENU_INPUT_OPTION = scnr.nextInt()) < MENU_OPTION_CREATE_ACCOUNT || BANK_MENU_INPUT_OPTION > MENU_OPTION_DELETE_ACCOUNT) {

            scnr.nextLine(); // consume the entire line of input
            System.out.println("\n----------------------------------------------------------------");
            System.out.println("\t" + MENU_OPTION_CREATE_ACCOUNT + ". Create Account - " + MENU_OPTION_VIEW_ACCOUNT + ". View Account - " + MENU_OPTION_DELETE_ACCOUNT + ". Delete Account");
            System.out.println("----------------------------------------------------------------\n");
            System.out.print("Invalid option, please enter a valid number: ");

        }

        // clear previous inputs
        scnr.nextLine();
        return BANK_MENU_INPUT_OPTION;

    }

    public static void accessNavigationUserChoice() {

        navigationUserChoice();

    }

    private static void navigationUserChoice() {

        // Let user choose which options and check if the options are valid
        int USER_NAVIGATION_CHOICE = validateUserNavigationChoice();
        ArrayList<String> ACCOUNT_
        boolean INVALID_INPUT = true;

        while (INVALID_INPUT) {
            if (USER_NAVIGATION_CHOICE < 0 || USER_NAVIGATION_CHOICE > ) {
                if

                System.out.println("You chose to login to bank account (" + USER_NAVIGATION_CHOICE +") " + BankAccountCreation.getBankAccountNames(USER_NAVIGATION_CHOICE-1));

            }
        }

        BankAccountActions.accessAuthenticateLogin(USER_NAVIGATION_CHOICE);

    }

    public static int validateUserNavigationChoice() {
        int USER_NAVIGATION_CHOICE;

        // If user input is not an integer, more than the number of bank accounts, or less than 0 (error is shown)
        while (!scnr.hasNextInt() || (USER_NAVIGATION_CHOICE = scnr.nextInt()) > BankAccountCreation.getBankAccountNamesSize() || USER_NAVIGATION_CHOICE < 0) {

            System.out.println("Invalid input. You must choose an account or go back to the main menu.");

            scnr.nextLine(); // consume the entire line of input

        }

        // clear previous inputs
        scnr.nextLine();
        return USER_NAVIGATION_CHOICE;
    }

}
