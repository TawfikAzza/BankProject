public class BankAccount {

    // Constants:
    public static final double DEFAULT_INTEREST_RATE = 0.01;

    // Instance fields:
    private int accNumber;
    private double balance;
    private double interestRate;


    /**
     * Constructor.
     * Creates a new BankAccount with a zero balance and default interest rate.
     *
     * @param accNumber
     */
    public BankAccount(int accNumber) {
        this.accNumber=accNumber;
        this.balance=0;
        this.interestRate = DEFAULT_INTEREST_RATE;
    }


    /**
     * Creates a new BankAccount with the given initial balance and default interest rate.
     *
     * @param accNumber
     * @param initialBalance
     * @throws IllegalArgumentException if initialBalance is < 0
     */
    public BankAccount(int accNumber, double initialBalance) throws IllegalArgumentException {
        if(initialBalance<0)
            throw new IllegalArgumentException("Balance must be positive");
        this.accNumber=accNumber;
        this.balance= initialBalance;
        this.interestRate=DEFAULT_INTEREST_RATE;
    }



    /**
     * Returns the account number
     * @return
     */
    public int getAccountNumber() {
        return accNumber;
    }


    /**
     * Returns the current balance
     * @return
     */
    public double getBalance() {
        return balance;
    }


    /**
     * Returns the current interest rate (or DEFAULT_INTEREST_RATE if interestRate == -1)
     * @return
     */
    public double getInterestRate() {
        if(interestRate==-1)
            return DEFAULT_INTEREST_RATE;
        return interestRate;
    }


    /**
     * Adds the given amount to the balance.
     * @param amount
     * @throws IllegalArgumentException if amount < 0
     */
    public void deposit(double amount) throws IllegalArgumentException {
        if(amount<0)
            throw new IllegalArgumentException("Negative amount not allowed");
        balance+=amount;
    }



    /**
     * Subtracts the given amount from the balance
     * @param amount
     * @throws IllegalArgumentException if amount < 0 OR amount > account balance
     */
    public void withdraw(double amount) throws IllegalArgumentException {
        if(amount < 0)
            throw new IllegalArgumentException("Amount requested can't be negative");
        if(amount > balance)
            throw new IllegalArgumentException("Amount requested superior to balance");
        balance=balance-amount;
    }



    /**
     * Adjusts the interest rate to the given % value. Must be 1-10% (both inclusive)
     * Is specified as a double, so 1% = 0.01
     * @param interestRate
     * @throws IllegalArgumentException
     */
    public void setInterestRate(double interestRate) throws IllegalArgumentException {
        if(interestRate<1 || interestRate>10)
            throw new IllegalArgumentException("Invalid interest rate entered (must be between 1 and 10 included)");
        this.interestRate = interestRate/100;
    }


    /**
     * Adds interest to the balance
     */
    public void addInterest() {
        balance = balance + (balance*interestRate);
    }

}