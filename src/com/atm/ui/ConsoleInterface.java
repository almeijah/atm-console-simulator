package com.atm.ui;

import com.atm.exception.*;
import com.atm.service.BankService;

import java.util.InputMismatchException;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleInterface {
    Scanner reader = new Scanner(System.in);
    BankService bank = new BankService();

    public void start() {


        int choice = 0;

        while (choice != 5) {
            System.out.println("""
                    ----Welcome to ATM----
                    1-Create Account
                    2-Deposit
                    3-Withdraw
                    4-balance
                    5-Exit
                    """);


            try {
                choice = reader.nextInt();
                reader.nextLine();
                switch (choice) {
                    case 1:
                        handleCreateAccount();
                        break;
                    case 2:
                        handleDeposit();
                        break;
                    case 3:
                        handleWithdraw();
                        break;
                    case 4:
                        handleCheckBalance();
                        break;
                    case 5:
                        System.out.println("Bye");
                        break;
                    default:
                        System.out.println("Invalid choice, try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                reader.nextLine();
            } catch (InvalidAmountException e) {
                System.out.println(e.getMessage());
            } catch (AccountNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            } catch (InvalidAccountNumberException e) {
                System.out.println(e.getMessage());
            } catch (InvalidHolderNameException e) {
                System.out.println(e.getMessage());
            } catch (AccountAlreadyExistsException e) {
                System.out.println(e.getMessage());
            }
        }
        reader.close();

    }


    public void handleCreateAccount() {
        System.out.println("Enter account number");
        String accountNumber = reader.nextLine();
        System.out.println("Enter account name");
        String holderName = reader.nextLine();
        bank.createAccount(accountNumber, holderName);
    }

    public void handleDeposit() {
        System.out.println("Enter account number");
        String numberAccount = reader.nextLine();
        System.out.println("Enter value of deposit");
        BigDecimal amount = reader.nextBigDecimal();
        reader.nextLine();
        bank.deposit(numberAccount, amount);

    }

    public void handleWithdraw() {
        System.out.println("Enter account number");
        String accountNumber = reader.nextLine();
        System.out.println("Enter amount");
        BigDecimal amount = reader.nextBigDecimal();
        reader.nextLine();
        bank.withdraw(accountNumber, amount);
    }

    public void handleCheckBalance() {
        System.out.println("Enter account number");
        String accountNumber = reader.nextLine();
        BigDecimal balance = bank.getBalance(accountNumber);
        System.out.println("This balance is: " + balance);
    }

}



