package com.squad_stack.service;

import com.squad_stack.dto.InsertVehicleRequest;
import com.squad_stack.dto.LeaveVehicleDto;

public interface ParkingService {
    /**
     * This method is to park a vehicle
     * @param vehicleRequest contains vehicle number and age
     * @return string This returns id of parking.
     */
    String parkVehicle(InsertVehicleRequest vehicleRequest);

    /**
     * This method is to leave a vehicle from parking
     * @param leaveVehicleDto contains parking spot number
     * @return string This returns status if vehicle was removed
     */
    String leaveParking(LeaveVehicleDto leaveVehicleDto);
}
