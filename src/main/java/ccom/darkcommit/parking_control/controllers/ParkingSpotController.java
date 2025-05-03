package ccom.darkcommit.parking_control.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ccom.darkcommit.parking_control.dtos.ParkingSpotDto;
import ccom.darkcommit.parking_control.models.ParkingSpotModel;
import ccom.darkcommit.parking_control.services.ParkingSpotService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@AllArgsConstructor
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;


    @PostMapping("/create")
    public ResponseEntity<ParkingSpotModel> postParkingSpots(@RequestBody @Valid ParkingSpotDto parkingSpot) {
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.create(parkingSpot));
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotModel>> getParkingSpots() {
        return ResponseEntity.ok().body(parkingSpotService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpotModel> getParkingSpotById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(parkingSpotService.getByUuid(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParkingSport(@PathVariable UUID id){
        parkingSpotService.deleteByUuid(id);
        return ResponseEntity.ok().body("Parking Spot Delete with succes");
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<ParkingSpotModel> putMethodName(@PathVariable UUID id, @RequestBody ParkingSpotDto entity) {
        return ResponseEntity.ok().body(parkingSpotService.update(entity, id));
    }




}
