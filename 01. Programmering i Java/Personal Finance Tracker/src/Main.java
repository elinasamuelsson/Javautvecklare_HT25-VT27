//- Bygg en personal-finance applikation som fungerar i terminalen (eller med UI för VG)
//- Lägga in transaktioner (manuellt; när du exempelvis har köpt något eller fått lön)
//- Radera transaktioner (manuellt)
//- Se nuvarande kontobalans
//- Se pengar spenderade årsvis, månadsvis, veckovis och dagvis
//- Se inkomst årsvis, månadsvis, veckovis och dagvis
//- Spara data mellan sessioner (VG). Det betyder att du inte måste börja om med att lägga in transaktioner och annat varje gång applikationen startas om

import java.util.ArrayList;
import java.util.Scanner;

import projekt.examination.Transaction;

public class Main {
    public static double accountBalance = 0.00;
    public static ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public static void main(String[] args) {
    //intro
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your personal finance tracker!");

        //main menu
        while (true) {
            System.out.println("What do you wish to do?");
            System.out.println("1. View account balance");
            System.out.println("2. Add earnings");
            System.out.println("3. Add spending");
            System.out.println("4. View transaction log");
            System.out.println("0. Exit program");

            int userMainMenuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userMainMenuChoice) {
                case 1: //account balance
                    System.out.println("Your current balance is " + accountBalance + ".");
                    break;
                case 2: //earn
                    Transaction newEarningsTransaction = Transaction.addTransaction(true);
                    transactions.add(newEarningsTransaction);
                    accountBalance += newEarningsTransaction.amount;
                    System.out.println("Your transaction has been added.");
                    break;
                case 3: //spend
                    Transaction newSpendingTransaction = Transaction.addTransaction(false);
                    transactions.add(newSpendingTransaction);
                    accountBalance += newSpendingTransaction.amount;
                    System.out.println("Your transaction has been added.");
                    break;
                case 4: //transaction log
                    //transaction log sub menu
                    System.out.println("What do you wish to do?");
                    System.out.println("1. View earnings");
                    System.out.println("2. View spending");
                    System.out.println("0. Exit to main menu");

                    int userTransactionMenuChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (userTransactionMenuChoice) {
                        case 1: //view earning
                            //view spending by year, month, day
                            Transaction.viewTransactions(true, transactions);
                            break;
                        case 2: //view spending
                            //view earning by year, month, day
                            Transaction.viewTransactions(false, transactions);
                            break;
                        case 0: //exit to main menu
                            //how return??? put main program in own function and call it?
                            break;
                        default:
                            System.out.println("This option does not exist. Try again.");
                            break;
                    }
                    break;
                case 0: //exit program
                    System.out.println("Thank you for using our program.");
                    return;
                default:
                    System.out.println("This option does not exist. Try again.");
                    break;
            }
        }
    }
    //delete transactions
    //save data
    //fetch data
    //UI
}