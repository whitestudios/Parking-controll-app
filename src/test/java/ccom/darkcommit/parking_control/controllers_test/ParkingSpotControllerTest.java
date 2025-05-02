package ccom.darkcommit.parking_control.controllers_test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import ccom.darkcommit.parking_control.controllers.ParkingSpotController;
import ccom.darkcommit.parking_control.models.ParkingSpotModel;
import ccom.darkcommit.parking_control.services.ParkingSpotService;

@WebMvcTest(ParkingSpotController.class)
public class ParkingSpotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParkingSpotService parkingSpotService;

    @Test
    void shouldCreateParkingSpot() throws Exception {
        String json = """
        {
            "parkingSpotNumber":"1234567890",
            "brandCar":"volvo",
            "modelCar":"Tsubaru",
            "colorCar":"Red",
            "responsibleName":"Robson Gerivaldo da SIlva",
            "apartment":"Apt 1",
            "block":"Bloco A",
            "licensePlateCar":"ABC2234"
        }
        """;

        when(parkingSpotService.create(any())).thenReturn(new ParkingSpotModel());

        mockMvc.perform(
            post("/parking-spot")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
        .andExpect(status().isCreated());
    }
}
