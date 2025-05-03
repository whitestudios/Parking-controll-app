package ccom.darkcommit.parking_control.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ccom.darkcommit.parking_control.dtos.ParkingSpotDto;
import ccom.darkcommit.parking_control.models.ParkingSpotModel;
import ccom.darkcommit.parking_control.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ParkingSpotService {
    private final ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public ParkingSpotModel create(ParkingSpotDto parkDto){
        if (parkingSpotRepository.existsByLicensePlateCar(parkDto.licensePlateCar())){
            throw new IllegalStateException("License plate already in use! ");
        }

        if (parkingSpotRepository.existsByParkingSpotNumber(parkDto.parkingSpotNumber())){
            throw new IllegalStateException("Parking spot number already in use");
        }

        if (parkingSpotRepository.existsByApartmentAndBlock(parkDto.apartment(), parkDto.block())){
            throw new IllegalStateException("Parking spot already registered for this apartment/block! ");
        }

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

    @Transactional
    public ParkingSpotModel update(ParkingSpotDto dto, UUID id){
        Optional<ParkingSpotModel> model_opt = parkingSpotRepository.findById(id);

        if(!model_opt.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ParkingSpotModel with UUID: " + id + " not found");
        }

        ParkingSpotModel model = model_opt.get();

        model.setApartment(dto.apartment());
        model.setBlock(dto.block());
        model.setBrandCar(dto.brandCar());
        model.setColorCar(dto.colorCar());
        model.setLicensePlateCar(dto.licensePlateCar());
        model.setModelCar(dto.modelCar());
        model.setParkingSpotNumber(dto.parkingSpotNumber());
        model.setResponsibleName(dto.responsibleName());
        model.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

        return parkingSpotRepository.save(model);
    }

}
