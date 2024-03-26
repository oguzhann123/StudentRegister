package com.example.studentregister.data.entity;

public class Student {

    private String info;
    private String email;
    private String address;


    public Student() {
    }

    public Student(String info, String email, String address) {
        this.info = info;
        this.email = email;
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


