package com.sqad_stack.dto;

public class LeaveVehicleDto {
    private int parkingNumber;

    public LeaveVehicleDto(int parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(int parkingNumber) {
        this.parkingNumber = parkingNumber;
    }
}
