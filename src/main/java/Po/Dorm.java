package Po;

public class Dorm {
    private String name, building_id, dorm_id;
    private int bed_num, people_num;
    private double deposit;

    @Override
    public String toString() {
        return "Dorm{" +
                "name='" + name + '\'' +
                ", building_id='" + building_id + '\'' +
                ", dorm_id='" + dorm_id + '\'' +
                ", bed_num=" + bed_num +
                ", people_num=" + people_num +
                ", deposit=" + deposit +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getBed_num() {
        return bed_num;
    }

    public void setBed_num(int bed_num) {
        this.bed_num = bed_num;
    }

    public int getPeople_num() {
        return people_num;
    }

    public void setPeople_num(int people_num) {
        this.people_num = people_num;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }
}
