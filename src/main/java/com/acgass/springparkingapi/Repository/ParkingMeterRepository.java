package com.acgass.springparkingapi.Repository;

import com.acgass.springparkingapi.Domain.ParkingMeter;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface ParkingMeterRepository extends CrudRepository<ParkingMeter, Long> {
    Optional<ParkingMeter> findById(Long id);
}
