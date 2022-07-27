package com.squad_stack.service;

import com.squad_stack.dto.CreateSlotRequest;

import java.util.List;

public interface SlotService {
    String createSlot(CreateSlotRequest createSlotRequest);
    List<Integer> getSlotOfVehicleByDriverAge(int age);
    int getSlotOfVehicleByNumber(String vehicleNumber);

    String getVehicleRegistrationByAge(int age);
}
