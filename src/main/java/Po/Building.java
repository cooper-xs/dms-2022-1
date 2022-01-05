package Po;

public class Building {
    String name, building_id, address, manager_id;

    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                ", building_id='" + building_id + '\'' +
                ", address='" + address + '\'' +
                ", manager_id='" + manager_id + '\'' +
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }
}
