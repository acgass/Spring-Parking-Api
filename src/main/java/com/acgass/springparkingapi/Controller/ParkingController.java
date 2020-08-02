package com.acgass.springparkingapi.controller;

import com.acgass.springparkingapi.service.*;

@Controller
public class ParkingController{
    private final ParkingMeterService meterService;

    @Autowired
    public ParkingController(ParkinngMeterService meterService){
        this.meterService = meterService
    }


}