package com.sqad_stack.service;

import com.sqad_stack.dto.InsertVehicleRequest;
import com.sqad_stack.dto.LeaveVehicleDto;

public interface ParkingService {
    String parkVehicle(InsertVehicleRequest vehicleRequest);

    String leaveParking(LeaveVehicleDto leaveVehicleDto);
}
