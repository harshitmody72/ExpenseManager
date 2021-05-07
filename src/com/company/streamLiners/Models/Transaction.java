package com.company.streamLiners.Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    public String inpDate,transactionCategory,note;
    public float amount;
    public int type;

    //parameterised constructor for transaction class
    public Transaction(String inpDate, float amount,int type,String transactionCategory,String note) {
        this.inpDate = inpDate;
        this.amount = amount;
        this.type = type;
        this.transactionCategory = transactionCategory;
        this.note = note;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction[ date = ").append(inpDate);
        if (type == TransactionType.TYPE_exp) {
            sb.append(", Expense = ").append(amount);
        } else {
            sb.append(", Income =").append(amount);
        }
        sb.append(", Transaction Category - ").append(transactionCategory);
        sb.append(", Note - ").append(note);
        sb.append("]");
        return sb.toString();
    }
}
