package com.acgass.springparkingapi.Repository;

import com.acgass.springparkingapi.Domain.ParkingMeter;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ParkingMeterRepository extends CrudRepository<ParkingMeter, String> {
    ParkingMeter findById(long id);
}
