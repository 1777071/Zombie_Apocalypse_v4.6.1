package tian.zombie.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tian.zombie.dto.ZombieMovementPostDto;
import tian.zombie.entity.Coordinate;
import tian.zombie.entity.Creature;
import tian.zombie.entity.Grid;
import tian.zombie.entity.Zombie;
import tian.zombie.service.CreaturesLocationRecorder;
import tian.zombie.service.LocationPrinter;
import tian.zombie.service.ZombieMovementRecorder;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ZombieController {
    private final CreaturesLocationRecorder creaturesLocationRecorder;
    private final ZombieMovementRecorder zombieMovementRecorder;
    private final LocationPrinter resultPrinter;

    @PostMapping("/zombies")
    public ResponseEntity<Void> zombieStartMoving(@RequestBody ZombieMovementPostDto zombieMovementPostDto) {
        List<Zombie> zombies = zombieMovementPostDto.getZombies();
        List<Creature> creatures = zombieMovementPostDto.getCreatures();
        String movement = zombieMovementPostDto.getMove();
        Grid grid = new Grid(zombieMovementPostDto.getGridSize());

        Map<Coordinate, Creature> creatureLocation = creaturesLocationRecorder.recordCreatureLocation(grid, creatures);

        List<Zombie> allZombies = zombieMovementRecorder.zombieStartMoving(zombies, creatureLocation, movement, grid);

        resultPrinter.zombiePrinter(allZombies);
        resultPrinter.creaturePrinter(creatureLocation);
        return ResponseEntity.ok(null);
    }
}
