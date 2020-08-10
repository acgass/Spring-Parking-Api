package com.acgass.springparkingapi.Controller;

import com.acgass.springparkingapi.Domain.ParkingMeter;
import com.acgass.springparkingapi.Service.ParkingMeterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(PER_CLASS)
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ParkingMeterController.class)
class ParkingMeterControllerTest {

    @MockBean
    private ParkingMeterService parkingMeterService;

    private ParkingMeterController parkingMeterController;

    @Autowired
    private MockMvc mockMvc;
    private ParkingMeter meter1;
    private ParkingMeter meter2;
    private ParkingMeter meter3;


    @BeforeEach
    public void setUp() {
        parkingMeterController = new ParkingMeterController(parkingMeterService);
        meter1 = new ParkingMeter("Locaiton 1", 1L, "Some time");
        meter2 = new ParkingMeter("Locaiton 2", 2L, "Some time");
        meter3 = new ParkingMeter("Locaiton 3", 3L, "Some time");
        when(parkingMeterService.findOpenParkingMeters()).thenReturn(Arrays.asList(meter1, meter2));
        when(parkingMeterService.findPakringMeterById(anyLong())).thenReturn(meter3);
    }
    @Test
    public void getAllOpenMetersReturns200() throws Exception {
       mockMvc.perform(get("/meter/getOpen")).andExpect(status().is(200));
    }

    @Test
    public void getAllOpenMetersCallsParkingMeterService() {
        parkingMeterController.getAllOpenMeters();
        verify(parkingMeterService).findOpenParkingMeters();
    }

    @Test
    public void getAllOpenMetersReturnsListOfMeters(){
        List<ParkingMeter> meters = parkingMeterController.getAllOpenMeters();
        assertEquals(meter1, meters.get(0));
        assertEquals(meter2, meters.get(1));
    }

    @Test
    public void getParkingMeterByIdReturns200() throws Exception {
        mockMvc.perform(get("/meter/1")).andExpect(status().is(200));
    }

    @Test
    public void getParkingMeterByIdCallParkingMeterService(){
        parkingMeterController.getParkingMeterById(21);
        verify(parkingMeterService).findPakringMeterById(anyLong());
    }

    @Test
    public void getParkingMeterByIdCallParkingMeterServiceWithPathParam(){
        long meterId = 3l;
        parkingMeterController.getParkingMeterById(meterId);
        verify(parkingMeterService).findPakringMeterById(eq(meterId));
    }

    @Test
    public void getParkingMeterByIdCallReturnsCorrectParkingMeter(){
        long meterId = 3l;
        ResponseEntity<ParkingMeter> actualMeter = parkingMeterController.getParkingMeterById(meterId);
        assertEquals(meterId, actualMeter.getBody().getId());
    }

    @Test
    public void getParkingMeterByIdCallReturnsNotFoundIfNoParkingMeterWithId(){
        long meterId = 5l;
        when(parkingMeterService.findPakringMeterById(eq(meterId))).thenReturn(null);
        ResponseEntity<ParkingMeter> actualMeter = parkingMeterController.getParkingMeterById(meterId);
        assertEquals(HttpStatus.NOT_FOUND, actualMeter.getStatusCode());
        assertNull(actualMeter.getBody());
    }
}