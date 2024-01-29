import java.util.*;
public class BankAccountActions {

    private static final Scanner scnr = new Scanner(System.in);
    private static final Random random = new Random();
    private static final String MAIN_MENU_CALL = "0";
    public static void accessAuthenticateLogin(int CHOSEN_USER_ACCOUNT) {

        authenticateLogin(CHOSEN_USER_ACCOUNT);

    }

    private static void authenticateLogin(int CHOSEN_USER_ACCOUNT) {
        // make option to go back to main menu
        boolean LOGIN_SUCCESSFUL = false;

        ArrayList<String> BANK_ACCOUNT_PINS = BankAccountCreation.returnBankAccountPins();

        System.out.print("\nTo access the main menu, enter 0");
        System.out.print("\nEnter your pin to your bank account or 0: ");
        String USER_INPUT_PASSWORD = scnr.nextLine();

        while (!LOGIN_SUCCESSFUL) {
//            if (USER_INPUT_PASSWORD.matches("^[A-Z].*[a-z]")) {
//                System.out.println("Invalid input, you must enter a valid pin (4 numbers): ");
//            }

            if (USER_INPUT_PASSWORD.matches(BANK_ACCOUNT_PINS.get(CHOSEN_USER_ACCOUNT-1))) {
                LOGIN_SUCCESSFUL = true;
                System.out.println("Successfully Authenticated");
                break;
            }
            else {
                if (USER_INPUT_PASSWORD.matches(MAIN_MENU_CALL)) {
                    BankMainMenu.bankMenu();
                }
                System.out.print("\nFailed to Authenticate, please try again");
                System.out.print("\nTo access the main menu, enter 0: ");
            }

            USER_INPUT_PASSWORD = scnr.nextLine(); // consume the entire line of input

        }

        showAccountActions(CHOSEN_USER_ACCOUNT);

    }

    private static void showAccountActions(int CHOSEN_USER_ACCOUNT) {

        System.out.print("Welcome, " + BankAccountCreation.getBankAccountNames(CHOSEN_USER_ACCOUNT) + "!");
        System.out.print("\n\nListed below is your balance and actions you can take regarding your account.");
        System.out.print("1. Transfer money\n2. ");
    }


}