package com.gaoming.pojo;

public class Feedback {
    private Integer id;

    private String contact;

    private String information;

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                ", information='" + information + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
