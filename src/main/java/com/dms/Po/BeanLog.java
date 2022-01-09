package com.dms.Po;

public class BeanLog {
    private int NO;
    private String type, date;

    public BeanLog(int NO, String type, String date) {
        this.NO = NO;
        this.type = type;
        this.date = date;
    }

    @Override
    public String toString() {
        return "BeanLog{" +
                "NO=" + NO +
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
