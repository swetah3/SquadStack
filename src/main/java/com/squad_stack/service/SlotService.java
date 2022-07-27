package com.squad_stack.service;

import com.squad_stack.dto.CreateSlotRequest;

import java.util.List;

public interface SlotService {
    String createSlot(CreateSlotRequest createSlotRequest);
    List<Integer> getSlotOfVehicle (int age);
    int getSlotOfVehicleNumber(String vehicleNumber);

    String getVehicleRegistrationByAge(int age);
}
