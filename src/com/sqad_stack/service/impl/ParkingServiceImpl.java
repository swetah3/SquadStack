package com.sqad_stack.service.impl;

import com.sqad_stack.dto.InsertVehicleRequest;
import com.sqad_stack.dto.LeaveVehicleDto;
import com.sqad_stack.models.Parking;
import com.sqad_stack.models.Vehicle;
import com.sqad_stack.repository.InMemoryParkingSlotRepository;
import com.sqad_stack.repository.impl.ParkingSlotRepositoryImpl;
import com.sqad_stack.service.ParkingService;

public class ParkingServiceImpl implements ParkingService {

    private InMemoryParkingSlotRepository parkingSlotRepository;

    public ParkingServiceImpl(InMemoryParkingSlotRepository parkingSlotRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
    }

    @Override
    public String parkVehicle(InsertVehicleRequest vehicleRequest) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(vehicleRequest.getVehicleNumber());
        vehicle.setAge(vehicleRequest.getAge());
        Parking parking = new Parking();
        parking.setVehicle(vehicle);
        return parkingSlotRepository.parkVehicle(parking);
    }

    @Override
    public String leaveParking(LeaveVehicleDto leaveVehicleDto) {
       return parkingSlotRepository.leaveVehicle(leaveVehicleDto.getParkingNumber());
    }

}
