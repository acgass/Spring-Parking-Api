package com.acgass.springparkingapi.Controller;


import com.acgass.springparkingapi.Domain.ParkingMeter;
import com.acgass.springparkingapi.Service.ParkingMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ParkingMeterController{

    private final ParkingMeterService meterService;

    @Autowired
    public ParkingMeterController(ParkingMeterService meterService){
        this.meterService = meterService;
    }

    // Get All Open Meters
    @RequestMapping(value = "/meter/getOpen", method = GET)
    @ResponseBody
    public List<ParkingMeter> getAllOpenMeters(){
        return Collections.singletonList(new ParkingMeter("someLocation", 1L, "some time"));
    }


}
