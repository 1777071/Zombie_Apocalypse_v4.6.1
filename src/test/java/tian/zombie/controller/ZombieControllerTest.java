package tian.zombie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tian.zombie.dto.ZombieMovementPostDto;
import tian.zombie.entity.Coordinate;
import tian.zombie.entity.Creature;
import tian.zombie.entity.Zombie;
import tian.zombie.service.CreaturesLocationRecorder;
import tian.zombie.service.LocationPrinter;
import tian.zombie.service.ZombieMovementRecorder;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class ZombieControllerTest {

    @Mock
    private CreaturesLocationRecorder creaturesLocationRecorder;
    @Mock
    private LocationPrinter locationPrinter;
    @Mock
    private ZombieMovementRecorder zombieMovementRecorder;

    @Test
    void zombieStartMovingTest() {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new ZombieController(creaturesLocationRecorder, zombieMovementRecorder, locationPrinter)).build();
        ObjectMapper objectMapper = new ObjectMapper();
        Zombie zombie1 = new Zombie(new Coordinate(0, 0));
        List<Zombie> zombieList = new ArrayList<>();
        zombieList.add(zombie1);
        Creature creature1 = new Creature(new Coordinate(3, 0));
        Creature creature2 = new Creature(new Coordinate(3, 1));
        List<Creature> creatureList = new ArrayList<>();
        creatureList.add(creature1);
        creatureList.add(creature2);
        String directions = "LD";
        ZombieMovementPostDto zombieMovementPostDto = ZombieMovementPostDto.builder()
                .gridSize(4)
                .zombies(zombieList)
                .creatures(creatureList)
                .move(directions).build();
        try {
            mockMvc.perform(post("/zombies")
                    .content(objectMapper.writeValueAsString(zombieMovementPostDto))
                    .contentType(MediaType.APPLICATION_JSON)
            ).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
