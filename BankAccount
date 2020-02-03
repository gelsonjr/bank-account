/* BankAccount.java
 * 01/17/2020
 * Gelson Cardoso
 * Description: BankAccount object constructors, getters and setters */


public class BankAccount {

    private double balance;
    private double interestRate;
    private int accountNumber; // not part of Lab requirements

    // default constructor to initialize data
    BankAccount() {
        balance = 0.0;
        interestRate = 0.0;
        accountNumber = 0;
    }

    // parameter constructor
    BankAccount(int acc, double bal, double ir) {
        SetAccountNumber(acc);
        balance = bal;
        SetInterestRate(ir);
    }

    // Getter and Setter Methods
    public void SetInterestRate(double value) {
        interestRate = value;
    }

    public void SetAccountNumber(int value) {
        accountNumber = value;
    }

    public double GetInterestRate() {
        return interestRate * 100;
    }

    public int GetAccountNumber() {
        return accountNumber;
    }

    public double GetBalance() {
        return balance;
    }

    /* This function allows the user to make a deposit in the amount of the parameter
     * passed to the function. */
    public void MakeDeposit(double amount) {
        balance += amount;
    }

    /* This function allows the user to make a withdrawal in the amount of the parameter
     * passed to the function. */
    public void MakeWithdrawal(double amount) {
        balance -= amount;
    }

    /* This function adds interest to the balance */
    public void Compound() {
        balance = balance * (1 + interestRate);
    }

}
