package com.dms.Po;

public class Log {
    private int log_id, type, payment_account;
    private String account_id, building_id, dorm_id, date;

    @Override
    public String toString() {
        return "Log{" +
                "log_id=" + log_id +
                ", type=" + type +
                ", payment_account=" + payment_account +
                ", account_id='" + account_id + '\'' +
                ", building_id='" + building_id + '\'' +
                ", dorm_id='" + dorm_id + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPayment_account() {
        return payment_account;
    }

    public void setPayment_account(int payment_account) {
        this.payment_account = payment_account;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(String building_id) {
        this.building_id = building_id;
    }

    public String getDorm_id() {
        return dorm_id;
    }

    public void setDorm_id(String dorm_id) {
        this.dorm_id = dorm_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
