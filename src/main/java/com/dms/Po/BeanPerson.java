package com.dms.Po;

public class BeanPerson {
    private String dorm_id, bed_id, name, student_id, birthday, contact, major, classes, state;

    public BeanPerson(String dorm_id, String bed_id, String name, String student_id, String birthday, String contact, String major, String classes, String state) {
        this.dorm_id = dorm_id;
        this.bed_id = bed_id;
        this.name = name;
        this.student_id = student_id;
        this.birthday = birthday;
        this.contact = contact;
        this.major = major;
        this.classes = classes;
        this.state = state;
    }

    @Override
    public String toString() {
        return "BeanPerson{" +
                "dorm_id='" + dorm_id + '\'' +
                ", bed_id='" + bed_id + '\'' +
                ", name='" + name + '\'' +
                ", student_id='" + student_id + '\'' +
                ", birthday='" + birthday + '\'' +
                ", contact='" + contact + '\'' +
                ", major='" + major + '\'' +
                ", classes='" + classes + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getDorm_id() {
        return dorm_id;
    }

    public void setDorm_id(String dorm_id) {
        this.dorm_id = dorm_id;
    }

    public String getBed_id() {
        return bed_id;
    }

    public void setBed_id(String bed_id) {
        this.bed_id = bed_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
