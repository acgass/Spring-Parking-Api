package com.acgass.springparkingapi.Controller;

import com.acgass.springparkingapi.Domain.ParkingMeter;
import com.acgass.springparkingapi.Service.ParkingMeterService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ParkingMeterController.class)
class ParkingMeterControllerTest {

    @MockBean
    private ParkingMeterService parkingMeterService;

    @InjectMocks
    private ParkingMeterController parkingMeterController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllOpenMetersReturns200() throws Exception {
       mockMvc.perform(get("/meter/getOpen")).andExpect(status().is(200));
    }

}