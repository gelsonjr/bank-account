/* BankMain.java
 * 01/17/2020
 * Gelson Cardoso
 * Description: This program creates bank account objects that can be manipulated.
 * Objects are added to an ArrayList and can be accessed by searching their account number property:
 * a 4 digit sequence of numbers that can be used as account ID. After the account object is
 * accessed, the user can perform certain operations to the account, such as make deposits,
 * withdrawals, add interest compound and check the balance */

import javax.swing.*;
import java.util.ArrayList;

public class BankMain {

    public static void main(String[] args){

        // to store bank account objects
        ArrayList<BankAccount> accounts = new ArrayList<>();

        int menuOptions;

        // loop to validate main menu options
        do {

            menuOptions = displayMenu(); // storing displayMenu() values into menuOptions

            if (menuOptions == 1) // option #1: creates new account object, adds it to array list
                createAccount(accounts); // invoking createAccount() to create new accounts

            else if (menuOptions == 2) { // option# 2: account search using account number

                // to make sure an account object exists in the array list
                if (accounts.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please create a new account first!");
                    continue;
                }

                int accountOptions;

                int accountSearch = Integer.parseInt(JOptionPane.showInputDialog(
                        "Please enter account number"));

                /* loop to search for account number in the array list using account # getter.
                 * If account number (a 4 digit number, like "1234") is found, the account object
                 * is returned and can manipulate it */
                for (BankAccount account : accounts) {

                    if (account.GetAccountNumber() == accountSearch) {

                        // loop for account management options
                        do {

                            /* displayAccountMenu() method always displays the account current
                             * balance and interest rate, also, it allows us to make deposits,
                             * withdrawals and add compound interest to the balance */
                            accountOptions = displayAccountMenu(account);

                            if (accountOptions == 1) {
                                double deposit = Double.parseDouble(JOptionPane.showInputDialog(
                                        "Please enter the deposit amount"));
                                account.MakeDeposit(deposit);
                                JOptionPane.showMessageDialog(null,
                                        "$" + String.format("%,.2f", deposit) +
                                                " was deposited into the account");
                            }
                            else if (accountOptions == 2) {
                                double withdrawal = Double.parseDouble(JOptionPane.showInputDialog(
                                        "Please enter the withdrawal amount"));
                                account.MakeWithdrawal(withdrawal);
                                JOptionPane.showMessageDialog(null,
                                        "$" + String.format("%,.2f", withdrawal) +
                                                " was withdrawn from the account");
                            }
                            else if (accountOptions == 3) {
                                account.Compound();
                                JOptionPane.showMessageDialog(null, "Compound Interest added to" +
                                        " Account Balance");
                            }
                            else if (accountOptions == 4) {
                                break;
                            }

                        } while (accountOptions != 4);

                    }

                    /* else if (account.GetAccountNumber() != accountSearch) {
                        JOptionPane.showMessageDialog(null,
                                "Invalid Account Number, Please try again.");
                    } */
                }

            } else if (menuOptions == 3)
                JOptionPane.showMessageDialog(null, "Good Bye!\n\n");

            else
                JOptionPane.showMessageDialog(null, "Invalid entry, please try again!");

        } while (menuOptions != 3);

        System.exit(0);
    }

    // --- Method definitions ---

    /* return type: int
     * parameters: none
     * purpose: This method displays main menu and prompt user for choices. */
    public static int displayMenu() {

        int menuInput;
        Integer[] menuButtons = {1, 2, 3}; // JOptionPane buttons

        // Display account manager menu and prompt user for option
        menuInput = JOptionPane.showOptionDialog(null,
                "-- Bank Account Manager --\n\n" +
                        "Please select an option:\n\n" +
                        "1) Create New Account\n\n" +
                        "2) Manage Existing Account\n\n" +
                        "3) Exit\n\n",
                "Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                menuButtons, menuButtons[0]);

        // if "x" button is pressed the program will end
        if (menuInput == JOptionPane.CLOSED_OPTION){
            JOptionPane.showMessageDialog(null, "Good Bye!\n\n");
            System.exit(0);
        }

        return menuButtons[menuInput];
    }

    /* return type: void
     * parameters: 1 array list BankAccount (accounts)
     * purpose: This method creates new bank account objects */
    public static void createAccount(ArrayList<BankAccount> accounts) {

        // get user inputs to create bank account object
        int accountNumber = Integer.parseInt(JOptionPane.showInputDialog(
                "Please enter a 4 digit number to create a new bank account"));

        double startingBalance = Double.parseDouble(JOptionPane.showInputDialog(
                "Please enter the starting balance for this account"));

        double interestRate = Double.parseDouble(JOptionPane.showInputDialog(
                "Please enter interest rate for this account (0.07 format for 7%)"));

        // using user input to populate BankAccount constructor
        accounts.add(new BankAccount(accountNumber, startingBalance, interestRate));

        JOptionPane.showMessageDialog(null, "Account# " + accountNumber + " successfully created.");
    }

    /* return type: int
     * parameters: 1 BankAccount object (account)
     * purpose:  always displays the account current balance and interest rate, also, it allows us
     * to make deposits, withdrawals and add compound interest to the balance */
    public static int displayAccountMenu(BankAccount account) {

        Integer[] inputOption = {1, 2, 3, 4}; // JOptionPane buttons

        // get user input to manipulate account
        int accountInput = JOptionPane.showOptionDialog(null,
                "Account# " + account.GetAccountNumber() + "\n" +
                        "Current Balance: $" + String.format("%,.2f", account.GetBalance()) + "\n" +
                        "Interest Rate: " + String.format("%,.2f", account.GetInterestRate()) + "%\n" +
                        "----------------------------------------\n\n" +
                        "Please select an option:\n\n" +
                        "1) Make a deposit\n\n" +
                        "2) Make a withdrawal\n\n" +
                        "3) Add compound interest\n\n" +
                        "4) Go back to the Main Menu\n\n",
                "Main Menu", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                inputOption, inputOption[0]);

        // if "x" button is pressed the program will end
        if (accountInput == JOptionPane.CLOSED_OPTION){
            JOptionPane.showMessageDialog(null, "Good Bye!\n\n");
            System.exit(0);
        }

        return inputOption[accountInput];
    }
}
