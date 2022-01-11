package com.dms.Po;

public class BeanLog {
    private int NO;
    private String number, type, date;

    public BeanLog(int NO, String number, String type, String date) {
        this.NO = NO;
        this.number = number;
        this.type = type;
        this.date = date;
    }

    @Override
    public String toString() {
        return "BeanLog{" +
                "NO=" + NO +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public int getNO() {
        return NO;
    }

    public void setNO(int NO) {
        this.NO = NO;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
