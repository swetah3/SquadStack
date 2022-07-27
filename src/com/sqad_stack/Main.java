package com.sqad_stack;

import com.sqad_stack.dto.CreateSlotRequest;
import com.sqad_stack.dto.InsertVehicleRequest;
import com.sqad_stack.dto.LeaveVehicleDto;
import com.sqad_stack.repository.InMemoryParkingSlotRepository;
import com.sqad_stack.repository.impl.ParkingSlotRepositoryImpl;
import com.sqad_stack.service.ParkingService;
import com.sqad_stack.service.SlotService;
import com.sqad_stack.service.impl.ParkingServiceImpl;
import com.sqad_stack.service.impl.SlotServiceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InMemoryParkingSlotRepository parkingSlotRepository = new ParkingSlotRepositoryImpl();
        ParkingService parkingService = new ParkingServiceImpl(parkingSlotRepository);
        SlotService slotService = new SlotServiceImpl(parkingSlotRepository);

        System.out.println(slotService.createSlot(new CreateSlotRequest(6)));
        System.out.println(parkingService.parkVehicle(
                new InsertVehicleRequest("KA-01-HH-1234", 21)));
        System.out.println(parkingService.parkVehicle(
                new InsertVehicleRequest("PB-01-HH-1234", 21)));

        System.out.println(slotService.getSlotOfVehicle(21));

        System.out.println(slotService.getSlotOfVehicleNumber("PB-01-HH-1234"));

        System.out.println(parkingService.leaveParking(new LeaveVehicleDto(2)));

        System.out.println(parkingService.parkVehicle(
                new InsertVehicleRequest("HR-29-TG-3098", 39)));

        System.out.println(slotService.getVehicleRegistration(39));


    }
}
