package com.test.database.translate.基础;

import java.util.Objects;

// 1.2.13
public class Transaction implements Comparable<Transaction> {
    private String who;
    private Date date;
    private double account;

    public Transaction(String who, Date date, double account) {
        this.who = who;
        this.date = date;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "who='" + who + '\'' +
                ", date=" + date +
                ", account=" + account +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.account, account) == 0 && Objects.equals(who, that.who) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(who, date, account);
    }


    @Override
    public int compareTo(Transaction o) {
        return (int) (this.account - o.account);
    }


    public Transaction[] readDates(String s) {
        String[] split = s.split("\\|");
        Transaction[] transactions = new Transaction[split.length];
        for (int i = 0; i < transactions.length; i++) {
            String[] s1 = split[i].split(",");
            transactions[i] = new Transaction(s1[0], new Date(Integer.parseInt(s1[1].split("/")[0]),
                    Integer.parseInt(s1[1].split("/")[1]),
                    Integer.parseInt(s1[1].split("/")[2])), Double.parseDouble(s1[2]));
        }
        return transactions;
    }
}
