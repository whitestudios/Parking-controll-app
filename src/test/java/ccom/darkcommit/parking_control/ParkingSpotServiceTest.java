package ccom.darkcommit.parking_control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import ccom.darkcommit.parking_control.dtos.ParkingSpotDto;
import ccom.darkcommit.parking_control.models.ParkingSpotModel;
import ccom.darkcommit.parking_control.repositories.ParkingSpotRepository;
import ccom.darkcommit.parking_control.services.ParkingSpotService;

@ExtendWith(MockitoExtension.class)
public class ParkingSpotServiceTest {

    @Mock
    ParkingSpotRepository parkingSpotRepository;
    
    @InjectMocks
    ParkingSpotService parkingSpotService;

    @Test
    void shouldCreateParkingSpot(){
        ParkingSpotDto dto = new ParkingSpotDto("1234567800","ABC1234","volvo","modelinho","red","Joelson Lira","apt 2251","bloco 2");

        ParkingSpotModel model =  new ParkingSpotModel(); 
        
        BeanUtils.copyProperties(dto, model);
        model.setId(UUID.randomUUID());

        when(parkingSpotRepository.save(any())).thenReturn(model);

        ParkingSpotModel result = parkingSpotService.create(dto);

        assertNotNull(result);
        assertEquals(model.getId(), result.getId());

    }
}
