package com.acgass.springparkingapi.Controller;


import com.acgass.springparkingapi.Domain.ParkingMeter;
import com.acgass.springparkingapi.Service.ParkingMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ParkingMeterController{

    private final ParkingMeterService meterService;

    @Autowired
    public ParkingMeterController(ParkingMeterService meterService){
        this.meterService = meterService;
    }


    @RequestMapping(value = "/meter/getOpen", method = GET)
    @ResponseBody
    public List<ParkingMeter> getAllOpenMeters(){
        return meterService.findOpenParkingMeters();
    }

    @RequestMapping(value = "/meter/{meterId}", method = GET)
    public ResponseEntity<ParkingMeter> getParkingMeterById(@PathVariable long meterId){
        ParkingMeter meter= meterService.findPakringMeterById(meterId);
        if(meter == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(meter, HttpStatus.OK);
    }


}
