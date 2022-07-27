package com.squad_stack.service;

import com.squad_stack.dto.InsertVehicleRequest;
import com.squad_stack.dto.LeaveVehicleDto;

public interface ParkingService {
    String parkVehicle(InsertVehicleRequest vehicleRequest);

    String leaveParking(LeaveVehicleDto leaveVehicleDto);
}
