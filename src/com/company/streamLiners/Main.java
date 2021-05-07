package com.company.streamLiners;

import com.company.streamLiners.Models.Transaction;
import com.company.streamLiners.Models.TransactionSummary;

import java.util.Scanner;

import static com.company.streamLiners.Models.List.list;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int inputType;
    static String inputNote,inputTransactionCategory,inputDate;
    static float inputAmount;



    public static void main(String[] args) {

        list();
        int choice = sc.nextInt();
        TransactionSummary ts = new TransactionSummary();

        while (choice != 6) {

            switch (choice) {
                case 1 -> {
                    //Add Transaction

                    System.out.println("Adding Transaction..... ");
                    System.out.print("Enter The Date (YYYY-MM-dd): ");
                    inputDate = sc.next();
                    System.out.print("Enter The Amount : ");
                    inputAmount = sc.nextFloat();
                    System.out.println("Transaction Type: ");
                    System.out.println("0)Expense");
                    System.out.println("1)Income");
                    System.out.print("Enter the number: ");
                    int n = sc.nextInt();
                    switch (n) {
                        case 0 -> {
                            inputType = 0;
                            inputTransactionCategory = "Shopping";
                            System.out.print("Enter the note: ");
                            inputNote = sc.next();
                            Transaction tr = new Transaction(inputDate, inputAmount, inputType, inputTransactionCategory, inputNote);
                            ts.add(tr,inputDate);
                        }
                        case 1 -> {
                            inputType = 1;
                            inputTransactionCategory = "Earn";
                            System.out.print("Enter the note: ");
                            inputNote = sc.next();
                            Transaction tr = new Transaction(inputDate, inputAmount, inputType, inputTransactionCategory, inputNote);
                            ts.add(tr,inputDate);
                        }
                        default -> System.out.println("Wrong Input");
                    }
                }
                case 2 -> {
                    //Edit Transaction

                    System.out.println("Edit Transaction");
                    System.out.print("Enter The Date (YYYY-MM-dd): ");
                    inputDate = sc.next();
                    System.out.print("Enter The Amount : ");
                    inputAmount = sc.nextFloat();
                    System.out.println("Transaction Type: ");
                    System.out.println("0)Expense");
                    System.out.println("1)Income");
                    System.out.print("Enter the number: ");
                    int n = sc.nextInt();
                    switch (n) {
                        case 0 -> {
                            inputType = 0;
                            inputTransactionCategory = "Shopping";
                            System.out.print("Enter the note: ");
                            inputNote = sc.next();
                            Transaction tr = new Transaction(inputDate, inputAmount, inputType, inputTransactionCategory, inputNote);
                            ts.add(tr,inputDate);
                        }
                        case 1 -> {
                            inputType = 1;
                            inputTransactionCategory = "Earn";
                            System.out.print("Enter the note: ");
                            inputNote = sc.next();
                            Transaction tr = new Transaction(inputDate, inputAmount, inputType, inputTransactionCategory, inputNote);
                            ts.add(tr,inputDate);
                        }
                        default -> System.out.println("Wrong Input");
                    }
                }
                case 3 -> {
                    //Delete Transaction
                    System.out.println("Delete Transaction");
                    System.out.print("Enter The Date (YYYY-MM-dd): ");
                    inputDate = sc.next();
                    ts.delete(inputDate);

                }
                case 4 -> {
                    //Month Wise Details

                    System.out.println("Month Wise Details");
                    System.out.print("Enter The Date (YYYY-MM-dd): ");
                    inputDate = sc.next();
                    ts.monthDetails(inputDate);

                }
                case 5 -> {
                    //All Months

                    System.out.println("All Month");
                    System.out.println(ts);
                }
                default -> System.out.println("Wrong input");
            }
            list();
            choice = sc.nextInt();
        }

    }

}
