package com.sqad_stack.service;

import com.sqad_stack.dto.CreateSlotRequest;

import java.util.List;

public interface SlotService {
    String createSlot(CreateSlotRequest createSlotRequest);
    List<Integer> getSlotOfVehicle (int age);
    int getSlotOfVehicleNumber(String vehicleNumber);

    String getVehicleRegistration(int age);
}
