import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Test of the BankAccount class")
class BankAccountTest {


    @DisplayName("Test of the getAccount method")
    @Test
    void getAccountNumber() {
        BankAccount bankAccount = new BankAccount(123456);
        int actualValue = bankAccount.getAccountNumber();
        int expectedValue = 123456;
        Assertions.assertEquals(expectedValue,actualValue);
    }

    @DisplayName("Test of the getBalance method")
    @Test
    void getBalance() {
        BankAccount bankAccount = new BankAccount(123456,66);
        double actualValue = bankAccount.getBalance();
        double expctedValue = 66;
        Assertions.assertEquals(expctedValue,actualValue);
    }

    @DisplayName("Test of the getInterest method")
    @Test
    void getInterestRate() {
        BankAccount bankAccount = new BankAccount(123456,66);
        double actualValue = bankAccount.getInterestRate();
        double expctedValue = 0.01;
        Assertions.assertEquals(expctedValue,actualValue);
    }

    @DisplayName("Test of the deposit method")
    @Test
    void deposit() {

        BankAccount bankAccount = new BankAccount(123456,66);
        bankAccount.deposit(34);
        double actualValue = bankAccount.getBalance();
        double expctedValue = 100;
        Assertions.assertEquals(expctedValue,actualValue);
    }


    @DisplayName("Test of the withdraw method")
    @Test
    void withdraw() {
        BankAccount bankAccount = new BankAccount(123456,66);
        bankAccount.withdraw(30);
        double actualValue = bankAccount.getBalance();
        double expctedValue = 36;
        Assertions.assertEquals(expctedValue,actualValue);
    }

    @DisplayName("Test of the setInterest method")
    @Test
    void setInterestRate() {
        BankAccount bankAccount = new BankAccount(123456,66);
        bankAccount.setInterestRate(2);
        double actualValue = bankAccount.getInterestRate();
        double expctedValue = 0.02;
        Assertions.assertEquals(expctedValue,actualValue);
    }

    @DisplayName("Test of the addInterest method")
    @Test
    void addInterest() {
        BankAccount bankAccount = new BankAccount(123456,100);
        bankAccount.addInterest();
        double actualValue = bankAccount.getBalance();
        double expctedValue = 101;
        Assertions.assertEquals(expctedValue,actualValue);
    }

    @DisplayName("Test of the deposit method with an invalid amount")
    @Test
    void invalidDeposit() {
        //Arrange
        double amount = -5;
        BankAccount bankAccount = new BankAccount(123456,66);

        double expectedValue = 66;
        //Act
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,()-> bankAccount.deposit(amount));
        //Assert
        String actualMessage = ex.getMessage();
        String expectedMessage = "Negative amount not allowed";
        Assertions.assertEquals(expectedMessage,actualMessage);
        double actualValue = bankAccount.getBalance();
        Assertions.assertEquals(expectedValue,actualValue);

    }

    @DisplayName("Test constructor of the BankAccount class with invalid balance")
    @Test
    void bankAccountCreation() {

        double balance = -5;
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,()-> new BankAccount(123456,balance));
        String actualMessage = ex.getMessage();
        String expectedMessage = "Balance must be positive";
        Assertions.assertEquals(expectedMessage,actualMessage);

    }

    @DisplayName("Test of the withdraw method with a negative amount")
    @Test
    void invalidNegativeWithdrawal() {
        //Arrange
        double amount = -5;
        BankAccount bankAccount = new BankAccount(123456,66);
        double expectedValue = 66;
        //Act
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,()-> bankAccount.withdraw(amount));
        //Assert
        String actualMessage = ex.getMessage();
        String expectedMessage = "Amount requested can't be negative";
        Assertions.assertEquals(expectedMessage,actualMessage);
        double actualValue = bankAccount.getBalance();
        Assertions.assertEquals(expectedValue,actualValue);
    }
    @DisplayName("Test of the withdraw method with an amount superior to balance")
    @Test
    void invalidSuperiorToBalanceWithdrawal() {
        //Arrange
        double amount = 100;
        BankAccount bankAccount = new BankAccount(123456,66);
        double expectedValue = 66;
        //Act
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,()-> bankAccount.withdraw(amount));
        //Assert
        String actualMessage = ex.getMessage();
        String expectedMessage = "Amount requested superior to balance";
        Assertions.assertEquals(expectedMessage,actualMessage);
        double actualValue = bankAccount.getBalance();
        Assertions.assertEquals(expectedValue,actualValue);
    }
    @DisplayName("Test of an invalid interest rate")
    @Test
    void invalidInterestRateSetting() {
        //Arrange
        double interestRate = 100;
        BankAccount bankAccount = new BankAccount(123456,100);
        double expectedValue = 100;
        //Act
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,()-> bankAccount.setInterestRate(interestRate));
        //Assert
        String actualMessage = ex.getMessage();
        String expectedMessage = "Invalid interest rate entered (must be between 1 and 10 included)";
        Assertions.assertEquals(expectedMessage,actualMessage);
        double actualValue = bankAccount.getBalance();
        Assertions.assertEquals(expectedValue,actualValue);
    }
}