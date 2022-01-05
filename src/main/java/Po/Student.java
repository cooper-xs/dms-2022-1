package Po;

import java.util.Objects;

public class Student {
    private String name, gender, birthday, contact, student_id, college, major, classes, building_id, dorm_id;
    private int bed_id, status;

    public static String rowLine = "姓名 性别 生日 联系方式 学号 学院 专业 班级 公寓楼 宿舍号 床号 签到状态";
    public static String[] rowNames = rowLine.split(" ");

    public Student() {
        super();
    }

    public Student(String name, String gender, String birthday, String contact, String student_id, String college, String major, String classes, String building_id, String dorm_id, int bed_id, int status) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.contact = contact;
        this.student_id = student_id;
        this.college = college;
        this.major = major;
        this.classes = classes;
        this.building_id = building_id;
        this.dorm_id = dorm_id;
        this.bed_id = bed_id;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", contact='" + contact + '\'' +
                ", student_id='" + student_id + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", classes='" + classes + '\'' +
                ", building_id='" + building_id + '\'' +
                ", dorm_id='" + dorm_id + '\'' +
                ", bed_id=" + bed_id +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return bed_id == student.bed_id && status == student.status && Objects.equals(name, student.name) && Objects.equals(gender, student.gender) && Objects.equals(birthday, student.birthday) && Objects.equals(contact, student.contact) && Objects.equals(student_id, student.student_id) && Objects.equals(college, student.college) && Objects.equals(major, student.major) && Objects.equals(classes, student.classes) && Objects.equals(building_id, student.building_id) && Objects.equals(dorm_id, student.dorm_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, birthday, contact, student_id, college, major, classes, building_id, dorm_id, bed_id, status);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
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

    public int getBed_id() {
        return bed_id;
    }

    public void setBed_id(int bed_id) {
        this.bed_id = bed_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
