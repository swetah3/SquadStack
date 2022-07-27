package com.squad_stack.service.impl;

import com.squad_stack.dto.CreateSlotRequest;
import com.squad_stack.models.Slot;
import com.squad_stack.repository.InMemoryParkingSlotRepository;
import com.squad_stack.service.SlotService;

import java.util.List;

public class SlotServiceImpl implements SlotService {
    private InMemoryParkingSlotRepository parkingSlotRepository;

    public SlotServiceImpl(InMemoryParkingSlotRepository parkingSlotRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
    }

    @Override
    public String createSlot(CreateSlotRequest createSlotRequest) {
        Slot slot = new Slot();
        slot.setNumberOfSlot(createSlotRequest.getNumberOfSlot());
        return parkingSlotRepository.createSlot(slot);
    }

    @Override
    public List<Integer> getSlotOfVehicle(int age) {
        return parkingSlotRepository.getSlotOfVehicle(age);
    }

    @Override
    public int getSlotOfVehicleNumber(String vehicleNumber) {
        return parkingSlotRepository.getSlotOfVehicleNumber(vehicleNumber);
    }

    @Override
    public String getVehicleRegistrationByAge(int age) {
            try {
                return parkingSlotRepository.getVehicleRegistration(age);
            }
            finally {
                return "";
            }


    }
}
