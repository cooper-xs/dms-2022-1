package com.dms.Po;

public class BeanMoney {
    private int NO;
    private String dormNumber, account, person, personId, date;

    public BeanMoney(int NO, String dormNumber, String account, String person, String personId, String date) {
        this.NO = NO;
        this.dormNumber = dormNumber;
        this.account = account;
        this.person = person;
        this.personId = personId;
        this.date = date;
    }

    public int getNO() {
        return NO;
    }

    public void setNO(int NO) {
        this.NO = NO;
    }

    public String getDormNumber() {
        return dormNumber;
    }

    public void setDormNumber(String dormNumber) {
        this.dormNumber = dormNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BeanMoney{" +
                "NO=" + NO +
                ", dormNumber='" + dormNumber + '\'' +
                ", account='" + account + '\'' +
                ", person='" + person + '\'' +
                ", personId='" + personId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
