package com.sqad_stack.dto;

public class InsertVehicleRequest {
    private String vehicleNumber;
    private int age;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public InsertVehicleRequest(String vehicleNumber, int age) {
        this.vehicleNumber = vehicleNumber;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
