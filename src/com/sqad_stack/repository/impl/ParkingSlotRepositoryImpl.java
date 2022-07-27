package com.sqad_stack.repository.impl;

import com.sqad_stack.exception.SlotNotAvailableException;
import com.sqad_stack.exception.VehicleNotFoundException;
import com.sqad_stack.models.Parking;
import com.sqad_stack.models.Slot;
import com.sqad_stack.repository.InMemoryParkingSlotRepository;

import java.util.ArrayList;
import java.util.List;

public class ParkingSlotRepositoryImpl implements InMemoryParkingSlotRepository {

    private List<Parking> numberOfParking;

    public ParkingSlotRepositoryImpl() {
        numberOfParking = new ArrayList<>();
    }

    @Override
    public String createSlot(Slot slot) {
            for(int i =0 ; i <= slot.getNumberOfSlot(); i++){
                numberOfParking.add(null);
            }
            return "Created parking of "+slot.getNumberOfSlot() +" slots";
    }

    @Override
    public List<Integer> getSlotOfVehicle(int age) {
        List<Integer> slotOfVehicle = new ArrayList<>();
        for(int i =0; i < numberOfParking.size(); i++){
            if(numberOfParking.get(i) != null) {
                if (numberOfParking.get(i).getVehicle().getAge() == age) {
                    slotOfVehicle.add(i);
                }
            }
        }
        return slotOfVehicle;
    }

    @Override
    public int getSlotOfVehicleNumber(String vehicleNumber) {
        for(int i =0; i<numberOfParking.size(); i++){
            if(numberOfParking.get(i) != null) {
                if (numberOfParking.get(i).getVehicle().getVehicleNumber() == vehicleNumber) {
                    return i;
                }
            }
        }
        throw  new VehicleNotFoundException("vehicle with number "+ vehicleNumber + " not found in parking");
    }

    @Override
    public String parkVehicle(Parking parkedVehicle) {
        int firstAvailableParkingSlot = getFirstEmptyParking();
        assignVehicleSlot(parkedVehicle , firstAvailableParkingSlot);
        return "Car with vehicle registration number "+ parkedVehicle.getVehicle().getVehicleNumber()+
                " has been parked at slot number "+firstAvailableParkingSlot;
    }


    @Override
    public String leaveVehicle(int position) {
            Parking parking = numberOfParking.get(position);
            numberOfParking.remove(position);
            numberOfParking.set(position, null);
            return "Slot number "+position+"vacated, the car with vehicle registration number"+
            parking.getVehicle().getVehicleNumber()+" left the space, the driver of the car was of age "
                    +parking.getVehicle().getAge();
    }

    @Override
    public String getVehicleRegistration(int age) {
        for(int i =0; i<numberOfParking.size(); i++){
            if(numberOfParking.get(i) != null) {
                if (numberOfParking.get(i).getVehicle().getAge() == age) {
                    return numberOfParking.get(i).getVehicle().getVehicleNumber();
                }
            }
        }
        throw  new VehicleNotFoundException("vehicle with driver "+  age + " not found in parking");
    }

    private int getFirstEmptyParking(){
        for(int i=1; i<=numberOfParking.size() ; i++){
            if(numberOfParking.get(i) == null){
                return i;
            }
        }
        throw new SlotNotAvailableException("Slot is not available");
    }

    private void assignVehicleSlot(Parking parkedVehicle , int position){
        numberOfParking.set(position , parkedVehicle);
    }




}
