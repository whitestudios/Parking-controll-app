package ccom.darkcommit.parking_control.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ParkingSpotDto(
    
    @NotBlank
    @Size(max = 10)
    String parkingSpotNumber,
    
    @NotBlank
    @Size(max = 7)
    String licensePlateCar,
    
    @NotBlank
    @Size(max = 70)
    String brandCar,
    
    @NotBlank
    @Size(max = 70)
    String modelCar,
    
    @NotBlank
    @Size(max = 70)
    String colorCar,
    
    @NotBlank
    @Size(max = 130)
    String responsibleName,
    
    @NotBlank
    @Size(max = 30)
    String apartment,
    
    @NotBlank
    @Size(max = 30)
    String block
)  {
} 