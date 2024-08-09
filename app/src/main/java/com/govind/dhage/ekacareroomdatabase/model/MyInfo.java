package com.govind.dhage.ekacareroomdatabase.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "myinfo_table")
public class MyInfo {
    @PrimaryKey(autoGenerate = true)

    private int age;
    private String name,address,dob;

    public MyInfo(int age, String dob, String name, String address) {
        this.age = age;
        this.dob = dob;
        this.name = name;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

   /* public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/
}
