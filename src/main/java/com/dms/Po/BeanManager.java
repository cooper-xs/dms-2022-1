package com.dms.Po;

public class BeanManager {
    private int NO;
    private String name, manager_id, connect, managerBuilding;

    public BeanManager() {
    }

    public BeanManager(int NO, String name, String manager_id, String connect, String managerBuilding) {
        this.NO = NO;
        this.name = name;
        this.manager_id = manager_id;
        this.connect = connect;
        this.managerBuilding = managerBuilding;
    }

    @Override
    public String toString() {
        return "BeanManager{" +
                "NO=" + NO +
                ", name='" + name + '\'' +
                ", manager_id='" + manager_id + '\'' +
                ", connect='" + connect + '\'' +
                ", managerBuilding='" + managerBuilding + '\'' +
                '}';
    }

    public int getNO() {
        return NO;
    }

    public void setNO(int NO) {
        this.NO = NO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public String getManagerBuilding() {
        return managerBuilding;
    }

    public void setManagerBuilding(String managerBuilding) {
        this.managerBuilding = managerBuilding;
    }
}
