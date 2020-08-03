package com.acgass.springparkingapi.Service;

import com.acgass.springparkingapi.Domain.ParkingMeter;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class ParkingMeterServiceTest {

    ParkingMeter expectedMeter1 = new ParkingMeter("Location 3", 1L, "0 minutes");
    ParkingMeter expectedMeter2  = new ParkingMeter("Location 4", 2L, "0 minutes");

    @InjectMocks
    private ParkingMeterService parkingMeterService;

    @BeforeAll
    public void setUp(){
        parkingMeterService = new ParkingMeterService();
        expectedMeter1.setOpen(true);
        expectedMeter2.setOpen(true);
    }

    @Test
    public void getAllOpenMetersReturnsListOfMeters(){
        List<ParkingMeter> meters = parkingMeterService.findOpenParkingMeters();
        assertNotNull(meters.size());
    }

    @Test
    public void getAllOpenMetersReturnsListOOnlyOpenMeters(){
        List<ParkingMeter> meters = parkingMeterService.findOpenParkingMeters();
        assertTrue(meters.get(0).isOpen());
        assertTrue(meters.get(1).isOpen());
    }

    @Test
    public void  findParkingMeterByIdReturnsCorrectParkingMeter() {
        ParkingMeter actualMeter = parkingMeterService.findPakringMeterById(2L);
        assertEquals(2L, actualMeter.getMeterId());
    }

    @Test
    public void  findParkingMeterByIdReturnsNullIfIdDoesNotExist() {
        ParkingMeter actualMeter = parkingMeterService.findPakringMeterById(5L);
        assertNull(actualMeter);
    }

}