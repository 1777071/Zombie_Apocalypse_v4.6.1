package tian.zombie.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import tian.zombie.entity.Coordinate;
import tian.zombie.entity.Grid;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@ControllerAdvice
@Service
public class ReadParams {
    private final ZombieMovementRecorder zombieMovementRecorder;

    public String[] getMove(String movement) {
        try {
            return movement.split("");
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return movement.split("");
    }

    public Grid getGrid(int gridSize, List<Coordinate> creatures) {
        Grid grid = new Grid(gridSize);
        for (Coordinate creature : creatures) {
            grid = zombieMovementRecorder.recordCreature(grid, creature);
        }
        return grid;
    }

    public List<Coordinate> getZombies(List<Coordinate> originZombieList) {
        List<Coordinate> zombies = new ArrayList<>();
        try {
            zombies.addAll(originZombieList);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        return zombies;
    }

    public List<Coordinate> getCreatures(List<Coordinate> originCreatureList) {
        List<Coordinate> creatures = new ArrayList<>();
        try {
            creatures.addAll(originCreatureList);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        return creatures;
    }
}
