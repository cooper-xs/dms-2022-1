package com.dms.Po;

public class BeanBuilding {
    private int NO;
    private String building_id, name, address, manager_id;

    public BeanBuilding() {
    }

    public BeanBuilding(int NO, String building_id, String name, String address, String manager_id) {
        this.NO = NO;
        this.building_id = building_id;
        this.name = name;
        this.address = address;
        this.manager_id = manager_id;
    }

    @Override
    public String toString() {
        return "BeanBuilding{" +
                "NO=" + NO +
                ", building_id=" + building_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", manager_id='" + manager_id + '\'' +
                '}';
    }

    public int getNO() {
        return NO;
    }

    public void setNO(int NO) {
        this.NO = NO;
    }

    public String getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(String building_id) {
        this.building_id = building_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
