import java.util.*;
public class BankAccountCreation {
    private static final ArrayList<String> BANK_ACCOUNT_NAMES = new ArrayList<>();
    private static final ArrayList<String> BANK_ACCOUNT_PINS = new ArrayList<>();
    private static final ArrayList<String> BANK_ACCOUNT_ROUTENUM = new ArrayList<>();
    private static final Scanner scnr = new Scanner(System.in);
    private static final Random random = new Random();

    public static void initializeAccountCreation() {

    createBankAccount();

    }

    public static void adminViewBankAccount() {

        viewBankAccounts();

    }

    public static int getBankAccountNamesSize() {

        return BankAccountCreation.BANK_ACCOUNT_NAMES.size();

    }

    public static String getBankAccountNames(int index) {

        return BankAccountCreation.BANK_ACCOUNT_NAMES.get(index);

    }

    public static ArrayList<String> returnBankAccountNames() {

        return BankAccountCreation.BANK_ACCOUNT_NAMES;

    }

    public static ArrayList<String> returnBankAccountPins() {

        return BankAccountCreation.BANK_ACCOUNT_PINS;

    }

    public static ArrayList<String> returnBankAccountRouteNum() {

        return BankAccountCreation.BANK_ACCOUNT_ROUTENUM;

    }

    private static void createBankAccount() {
        BankApp bankApp = new BankApp();

        boolean USER_VALID_INPUT = false;
        String accountPin = "";

        System.out.print("\nWhat would you like your user ID to be? ");
        // call method to create and check bank account name until its valid
        String BANK_ACCOUNT_NAME = createBankAccountName();

        while (!USER_VALID_INPUT) {
            System.out.print("\nWhat would you like your 4 number pin to be? ");

            // add pin confirmation code
            accountPin = scnr.nextLine();

            if (accountPin.matches("\\d{4}")) {
                USER_VALID_INPUT = true;
            } else {
                System.out.println("Invalid pin number. Please enter a 4-digit pin containing only numeric characters.");
            }
        }

        // Add account information (name, pin, and random routing number)
        BANK_ACCOUNT_NAMES.add(BANK_ACCOUNT_NAME);
        BANK_ACCOUNT_PINS.add(accountPin);
        BANK_ACCOUNT_ROUTENUM.add(createRoutingNumber());

        // Sleep to smooth out the series of outputs
        //sleep(1000);

        System.out.println("\nYou have successfully created a new account under the user ID: " + BANK_ACCOUNT_NAME);
        System.out.println("Your 4-digit PIN is: " + accountPin + "\n");

        // Sleep to smooth out the series of outputs
        //sleep(2500);


        BankMainMenu.bankMenu();
    }

    private static String createBankAccountName() {

        boolean USER_VALID_INPUT = false;
        String BANK_ACCOUNT_NAME = "";

        while (!USER_VALID_INPUT) {

            BANK_ACCOUNT_NAME = scnr.nextLine();

            if (BANK_ACCOUNT_NAME.matches("^[A-Z].*[a-z]{1,15}")) {
                USER_VALID_INPUT = true;
            }
            else {
                System.out.print("\nInvalid account name. Please enter an account name less than 15 letters (e.g. Javier): ");
            }
        }
        return BANK_ACCOUNT_NAME;
    }

    private static String createRoutingNumber() {

        return String.valueOf(random.nextInt(99999));

    }
    private static void viewBankAccounts() {
        int BANK_ACCOUNT_LOGIN;

        if (BANK_ACCOUNT_NAMES.isEmpty()) {

            System.out.println("No accounts have been created!");

        } else {

            System.out.println("Bank Accounts:\n");

            System.out.printf("%-20s %-15s %-10s\n", "Account Holder", "Routing ID", "Balance");

            // get rid of balance and make user pick which account to log into using pin to view balance and other transactions
            for (int i = 0; i < BANK_ACCOUNT_NAMES.size(); i++) {
                System.out.printf("%-20s %-15s %-10s\n", i + 1 + ". " + BANK_ACCOUNT_NAMES.get(i), "ID-" + BANK_ACCOUNT_ROUTENUM.get(i), "Must log in");
            }
            System.out.println();
            System.out.print("\nIf you would like to login to an account, type the number corresponding to it. Otherwise, type 0 to go back to the main menu: ");

            // Method to choose which account to log in to
            BankMainMenu.accessNavigationUserChoice();
        }

        BankMainMenu.bankMenu();

    }

}
