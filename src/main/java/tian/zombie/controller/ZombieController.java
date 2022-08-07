package tian.zombie.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tian.zombie.dto.ZombieMovementPostDto;
import tian.zombie.entity.Coordinate;
import tian.zombie.entity.Grid;
import tian.zombie.service.ReadParams;
import tian.zombie.service.ResultPrinter;
import tian.zombie.service.ZombieMovementRecorder;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ZombieController {
    private final ReadParams readParams;
    private final ZombieMovementRecorder zombieMovementRecorder;
    private final ResultPrinter resultPrinter;

    @PostMapping("/zombies")
    public ResponseEntity<Void> zombieStartMoving(@RequestBody ZombieMovementPostDto zombieMovementPostDto) {
        List<Coordinate> zombies = readParams.getZombies(zombieMovementPostDto.getZombies());
        List<Coordinate> creatures = readParams.getCreatures(zombieMovementPostDto.getCreatures());
        String[] movement = readParams.getMove(zombieMovementPostDto.getMove());
        Grid grid = readParams.getGrid(zombieMovementPostDto.getGridSize(), creatures);
        zombieMovementRecorder.zombieMoving(zombies, creatures, movement, grid);
        resultPrinter.zombiePrinter(zombies);
        resultPrinter.creaturePrinter(creatures);
        return ResponseEntity.ok(null);
    }
}
