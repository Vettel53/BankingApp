import java.util.*;

public class BankApp {
    private static int BANK_MENU_INPUT_OPTION;

    public static void main(String[] args) {

        // create object of bank account creation class
        BankAccountCreation BankAccountCreation = new BankAccountCreation();

        BankAccountActions accountActions = new BankAccountActions();

        // Calls bankMenu method to show main menu
        BankMainMenu.bankMenu();

    }

    public static void accessViewStrings() {

        // simply prints out the strings of BANK_ACCOUNT_ROUTENUM , BANK_ACCOUNT_PINS , BANK_ACCOUNT_NAMES
        viewStrings();

    }
    private static void viewStrings() {

                                      /// Getter Setters ////
        // BankAccountCreation.returnBankAccountNames() -> Returns bank account names
        // BankAccountCreation.returnBankAccountPins() -> Returns bank account pins
        // BankAccountCreation.returnBankAccountRouteNum() -> Returns bank account route numbers

        for (String BANK_ACCOUNT_NAMES : BankAccountCreation.returnBankAccountNames()) {

            System.out.print(BANK_ACCOUNT_NAMES + " : " + BankAccountCreation.returnBankAccountPins() + " : " + BankAccountCreation.returnBankAccountRouteNum());
            System.out.println();

        }

    }

}
