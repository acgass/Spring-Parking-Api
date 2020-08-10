package com.acgass.springparkingapi.Service;

import com.acgass.springparkingapi.Domain.ParkingMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMeterService {

    @Autowired
    public ParkingMeterService() {
        super();
    }

    public List<ParkingMeter> findOpenParkingMeters(){
        List<ParkingMeter> meters = getAllMeters();
        List<ParkingMeter> openMeters = meters.stream()
                .filter(parkingMeter -> parkingMeter.getIsOpen().equals("true"))
                .collect(Collectors.toList());
        return openMeters;
    }

    public ParkingMeter findPakringMeterById(long meterId){
        List<ParkingMeter> meters = getAllMeters();
        ParkingMeter meter = meters.stream().filter(parkingMeter -> parkingMeter.getId() == meterId).findAny().orElse(null);
        return meter;
    }

    private List<ParkingMeter> getAllMeters(){
        ParkingMeter meter1 = new ParkingMeter("Location 1", 1L, "1 minute");
        meter1.setIsOpen("false");
        ParkingMeter meter2 = new ParkingMeter("Location 2", 2L, "2 minutes ");
        meter2.setIsOpen("false");
        ParkingMeter meter3 = new ParkingMeter("Location 3", 3L, "0 minutes");
        meter3.setIsOpen("true");
        ParkingMeter meter4 = new ParkingMeter("Location 4", 4L, "0 minutes");
        meter4.setIsOpen("true");
        return Arrays.asList(meter1, meter2, meter3, meter4);
    }


}
