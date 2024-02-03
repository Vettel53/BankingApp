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
        CHOSEN_USER_ACCOUNT = CHOSEN_USER_ACCOUNT - 1;
        boolean LOGIN_SUCCESSFUL = false;

        ArrayList<String> BANK_ACCOUNT_PINS = BankAccountCreation.returnBankAccountPins();

        System.out.print("\nTo access the main menu, enter 0");
        System.out.print("\nEnter your pin to your bank account or 0: ");
        String USER_INPUT_PASSWORD = scnr.nextLine();

        while (!LOGIN_SUCCESSFUL) {

            if (USER_INPUT_PASSWORD.matches(BANK_ACCOUNT_PINS.get(CHOSEN_USER_ACCOUNT))) {
                LOGIN_SUCCESSFUL = true; // may be redundant, check this later
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

        String ACCOUNT_USER_NAME = BankAccountCreation.getBankAccountNames(CHOSEN_USER_ACCOUNT);
        String ACCOUNT_ROUTE_NUM = BankAccountCreation.returnBankAccountPin(CHOSEN_USER_ACCOUNT);
        int ACCOUNT_BALANCE = BankAccountCreation.returnAccountBalance(CHOSEN_USER_ACCOUNT);

        int USER_ACTION_CHOICE;

        System.out.print("\nWelcome, " + ACCOUNT_USER_NAME + "!");
        System.out.print("\n\nListed below is your balance and actions you can take regarding your account.\n");
        System.out.printf("\n%-20s %-15s %-10s\n", "Account Holder", "Routing ID", "Balance\n");
        System.out.printf("%-20s %-15s $%-10s\n", ACCOUNT_USER_NAME, ACCOUNT_ROUTE_NUM, ACCOUNT_BALANCE);
        System.out.print("1. Deposit\n2. Placeholder\n3. Transfer Money \n");

        System.out.print("\nEnter a number corresponding to an action: ");

        while (!scnr.hasNextInt() || (USER_ACTION_CHOICE = scnr.nextInt()) < 0 || USER_ACTION_CHOICE > 3){    // Check if users input is valid corresponding to the actions
            System.out.print("\nThat is an invalid option!\nTry again or enter 0 to go back to the main menu: ");

            scnr.nextLine();
        }

        switch (USER_ACTION_CHOICE) { // Heavy WIP
                case 1:
                    // deposit money WIP
                    break;
                case 2:
                    //withdraw WIP
                    break;
                case 3:
                    userTransferMoney(CHOSEN_USER_ACCOUNT); // transfer money function WIP (about 1/3 progress)
                    break;
                default:
                    break;

            }

    }

    private static void userTransferMoney(int CHOSEN_USER_ACCOUNT) {

        System.out.print("\nWhich account would you like to transfer money to? ");
        System.out.print("\nWould you like to view the list of current accounts? [YES / NO]: ");

        viewCurrentAccounts(); // check if user wants to view the list of current accounts

    }

    private static void viewCurrentAccounts() {

        // BANK ACCOUNTS INFORMATION
        ArrayList<String> BANK_ACCOUNT_NAMES = BankAccountCreation.returnBankAccountNames();
        ArrayList<String> BANK_ACCOUNT_ROUTENUM = BankAccountCreation.returnBankAccountRouteNums();

        String VIEW_ACCOUNTS;
        boolean VALID_INPUT = false;
        int BANK_ACCOUNTS_LENGTH= BankAccountCreation.getBankAccountNamesSize();

        VIEW_ACCOUNTS = scnr.next();

        while (true) {

            if (VIEW_ACCOUNTS.equalsIgnoreCase("NO")) {
                break;
            } // may be able to rewrite this, check later

            if (VIEW_ACCOUNTS.equalsIgnoreCase("YES")) {
                System.out.printf("\n%-20s %-15s\n", "Account Holder", "Routing ID\n");

                for (int i = 0; i <= BANK_ACCOUNTS_LENGTH-1; i++) {

                    System.out.printf("%-20s %-10s\n", i+1 + ". " + BANK_ACCOUNT_NAMES.get(i), BANK_ACCOUNT_ROUTENUM.get(i));

                }

            } else {

                System.out.print("\nInvalid input, please try again: ");

            }

            VIEW_ACCOUNTS = scnr.next();

        }
        // Implementation of money functions WIP
    }



}