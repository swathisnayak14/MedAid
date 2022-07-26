package com.example.med_aid_app;

public class model
{
  String name,contact,medicine, time;

    public model(String name, String contact, String medicine, String time) {
        this.name = name;
        this.contact = contact;
        this.medicine = medicine;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
