package com.squad_stack.service.impl;

import com.squad_stack.dto.InsertVehicleRequest;
import com.squad_stack.dto.LeaveVehicleDto;
import com.squad_stack.models.Parking;
import com.squad_stack.models.Vehicle;
import com.squad_stack.repository.InMemoryParkingSlotRepository;
import com.squad_stack.service.ParkingService;

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
