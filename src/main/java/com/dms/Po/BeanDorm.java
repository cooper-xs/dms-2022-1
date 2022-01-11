package com.dms.Po;

public class BeanDorm {
    private int NO;
    private String dorm_id, name, number, people;
    private double deposit;

    public BeanDorm(int NO, String dorm_id, String name, String number, String people, double deposit) {
        this.NO = NO;
        this.dorm_id = dorm_id;
        this.name = name;
        this.number = number;
        this.people = people;
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "BeanDorm{" +
                "NO=" + NO +
                ", dorm_id='" + dorm_id + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", people='" + people + '\'' +
                ", deposit=" + deposit +
                '}';
    }

    public int getNO() {
        return NO;
    }

    public void setNO(int NO) {
        this.NO = NO;
    }

    public String getDorm_id() {
        return dorm_id;
    }

    public void setDorm_id(String dorm_id) {
        this.dorm_id = dorm_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }
}
