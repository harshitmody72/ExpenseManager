package com.company.streamLiners.Models;

public class Transactions {
    public String date;
    public float amount;
    public int type;
    //parameterised constructor for transaction class
    public Transactions(String date, float amount,int type) {
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction{ date= ").append(date);
        if(type==TransactionType.TYPE_exp){
            sb.append(", expense=").append(amount);
        }
        else {
            sb.append(", income=").append(amount);
        }
        sb.append("}");
        return sb.toString();
    }
}