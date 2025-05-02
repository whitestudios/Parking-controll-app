package ccom.darkcommit.parking_control.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ccom.darkcommit.parking_control.dtos.ParkingSpotDto;
import ccom.darkcommit.parking_control.models.ParkingSpotModel;
import ccom.darkcommit.parking_control.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ParkingSpotService {
    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotModel create(ParkingSpotDto parkDto){
        ParkingSpotModel p = new ParkingSpotModel();
        BeanUtils.copyProperties(parkDto, p);
        p.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return parkingSpotRepository.save(p);
    }

    public List<ParkingSpotModel> getAll(){
        return parkingSpotRepository.findAll();
    }

    public ParkingSpotModel getByUuid(UUID id){
        return parkingSpotRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ParkingSpotModel with UUID: " + id + " not found"));
    }

    public boolean deleteByUuid(UUID id){
        if(!parkingSpotRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ParkingSpotModel with UUID: " + id + " not found");
        }
        
        parkingSpotRepository.deleteById(id);
        return true;
    }
    
}
