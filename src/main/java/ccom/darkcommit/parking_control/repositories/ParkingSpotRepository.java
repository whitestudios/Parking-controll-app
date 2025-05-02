package ccom.darkcommit.parking_control.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ccom.darkcommit.parking_control.models.ParkingSpotModel;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID>{

}
