package com.squad_stack;

import com.squad_stack.dto.CreateSlotRequest;
import com.squad_stack.dto.InsertVehicleRequest;
import com.squad_stack.dto.LeaveVehicleDto;
import com.squad_stack.repository.InMemoryParkingSlotRepository;
import com.squad_stack.repository.impl.ParkingSlotRepositoryImpl;
import com.squad_stack.service.ParkingService;
import com.squad_stack.service.SlotService;
import com.squad_stack.service.impl.ParkingServiceImpl;
import com.squad_stack.service.impl.SlotServiceImpl;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        InMemoryParkingSlotRepository parkingSlotRepository = new ParkingSlotRepositoryImpl();
        ParkingService parkingService = new ParkingServiceImpl(parkingSlotRepository);
        SlotService slotService = new SlotServiceImpl(parkingSlotRepository);


        // java.net.URL
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("input.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        FileOutputStream outputStream = new FileOutputStream("output.txt",false);
        //byte[] strToBytes = str.getBytes();

        for (String line; (line = reader.readLine()) != null;) {
            List<String> words = Arrays.asList(line.split(" "));
            if(words.isEmpty()){
                continue;
            }
            System.out.println(line);
            String output = "";
            switch (words.get(0)){
                case "Create_parking_lot":
                    output = slotService.createSlot(new CreateSlotRequest(Integer.parseInt(words.get(1))));
                    break;
                case "Park":
                    output = parkingService.parkVehicle(
                            new InsertVehicleRequest(words.get(1), Integer.parseInt(words.get(3))));
                    break;
                case "Slot_numbers_for_driver_of_age":
                    output = slotService.getSlotOfVehicle(Integer.parseInt(words.get(1)))
                                    .stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(","));
                    break;
                case "Slot_number_for_car_with_number":
                    output = String.valueOf(slotService.getSlotOfVehicleNumber(words.get(1)));
                    break;
                case "Leave":
                    output = parkingService.leaveParking(new LeaveVehicleDto(Integer.parseInt(words.get(1))));
                    break;
                case "Vehicle_registration_number_for_driver_of_age":
                    output = slotService.getVehicleRegistrationByAge(Integer.parseInt(words.get(1)));
                    break;
                default:
                    System.out.println("invalid command");
            }
            output = output+"\n";
            outputStream.write(output.getBytes());

        }
        outputStream.close();
        /*System.out.println(slotService.createSlot(new CreateSlotRequest(6)));
        System.out.println(parkingService.parkVehicle(
                new InsertVehicleRequest("KA-01-HH-1234", 21)));
        System.out.println(parkingService.parkVehicle(
                new InsertVehicleRequest("PB-01-HH-1234", 21)));

        System.out.println(slotService.getSlotOfVehicle(21));

        System.out.println(slotService.getSlotOfVehicleNumber("PB-01-HH-1234"));

        System.out.println(parkingService.leaveParking(new LeaveVehicleDto(2)));

        System.out.println(parkingService.parkVehicle(
                new InsertVehicleRequest("HR-29-TG-3098", 39)));

        System.out.println(slotService.getVehicleRegistration(39));*/

    }
}
