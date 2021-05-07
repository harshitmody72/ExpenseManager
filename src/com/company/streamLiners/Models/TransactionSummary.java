package com.company.streamLiners.Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class TransactionSummary {

    public HashMap<String ,Transaction> transact = new HashMap<>();
    static LocalDate dates;
    static String key;

    //adding Transaction
    public void add(Transaction tr,String date){
        dates = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        key = dates.getDayOfMonth() +" "+dates.getMonthValue()+ " " + dates.getYear();
        //If Transaction Already Exists
        if(transact.containsKey(key)){
            transact.get(key).amount = tr.amount;
            transact.get(key).note = tr.note;
            transact.get(key).type = tr.type;
            transact.get(key).inpDate = dates.getDayOfMonth() +" "+dates.getMonth()+ " " + dates.getYear();
            if (transact.get(key).type == TransactionType.TYPE_exp)
                transact.get(key).transactionCategory = "Shopping";
            else
                transact.get(key).transactionCategory = "Earn";
            System.out.println("Transaction Edited");
        }
        //Adding First Time
        else {
            transact.put(key, tr);
            transact.get(key).inpDate = dates.getDayOfMonth() + " " + dates.getMonth() + " " + dates.getYear();
            System.out.println("Transaction Added");
        }

    }

    //Delete a Transaction
    public void delete(String date){
        dates = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        key = dates.getDayOfMonth() +" "+dates.getMonthValue() + " " + dates.getYear();

        //If Transaction Already Exists
        if(transact.containsKey(key)){

            System.out.println("Transaction Deleted...");
            transact.remove(key);
        }

        //If Transaction Doesn't Exist
        else{
            System.out.println("Transaction Doesn't Exist");
        }
    }

    //Month Wise Details
    public void monthDetails(String date){
        dates = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        key = dates.getMonthValue() + " " + dates.getYear();
        TransactionSummary tss = new TransactionSummary();
        for(Map.Entry<String ,Transaction> entry : transact.entrySet() ){
            if(entry.getKey().substring(3).equals(key)){
                tss.transact.put(entry.getKey(),entry.getValue());
            }
        }
        System.out.println(tss);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (Transaction transaction : transact.values()) {
            count++;
            stringBuilder.append("\n").append(count).append(")").append(transaction);
        }
        if (count == 0){
            return String.format("No Transaction....");
        }
        else {
            return "TransactionSummary :-" +
                    stringBuilder;
        }
    }
}
