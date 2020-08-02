package com.acgass.springparkingapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingMeterService {
    private String repsString;

    @Autowired
    public ParkingMeterService(String repsString) {
        this.repsString = repsString;
    }
}
