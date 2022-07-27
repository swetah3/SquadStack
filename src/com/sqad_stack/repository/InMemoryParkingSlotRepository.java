package com.sqad_stack.repository;

import com.sqad_stack.models.Parking;
import com.sqad_stack.models.Slot;

import java.util.List;

public interface InMemoryParkingSlotRepository {


    String createSlot(Slot slot);
    List<Integer> getSlotOfVehicle (int age);
    int getSlotOfVehicleNumber(String vehicleNumber);

    String parkVehicle(Parking parkedVehicle);

    String leaveVehicle(int position);
    String getVehicleRegistration(int age);
}
