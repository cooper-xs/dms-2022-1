package com.dms.Po;

public class Manager {
    private String name, manager_id, contact;

    @Override
    public String toString() {
        return "manager{" +
                "name='" + name + '\'' +
                ", manager_id='" + manager_id + '\'' +
                ", contact='" + contact + '\'' +
                '}';
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
