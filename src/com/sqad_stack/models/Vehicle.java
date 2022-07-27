package com.sqad_stack.models;

public class Vehicle {
    private String vehicleNumber;
    private Slot slotNumber;

    private int age;


    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Slot getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Slot slotNumber) {
        this.slotNumber = slotNumber;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}
