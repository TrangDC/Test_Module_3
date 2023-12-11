package com.example.thuchanh_m3.model;

public class Student {
    private int id;
    private String name;
    private String dateofbirth;
    private String email;
    private String address;
    private int phone;
    private String classroom;

    public Student(int id, String name, String dateofbirth, String email, String address, int phone, String classroom) {
        this.id = id;
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.classroom = classroom;
    }

    public Student(String name, String dateofbirth, String email, String address, int phone, String classroom) {
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
