package tian.zombie.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tian.zombie.entity.Coordinate;
import tian.zombie.entity.Grid;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ZombieMovementRecorder {
    private final ZombieMovement zombieMovement;
    private void recordZombieMovement(List<Coordinate> zombies, List<Coordinate> creatures, Coordinate zombie, Grid grid) {
        int[][] matrix = grid.getMatrix();
        if (matrix[zombie.getPositionX()][zombie.getPositionY()] == 1) {
            log.info("zombie infected creature at " + zombie.getPositionX() + " " + zombie.getPositionY());
            infectionCreature(creatures, zombie.getPositionX(), zombie.getPositionY());
            matrix[zombie.getPositionX()][zombie.getPositionY()] = 0;
            Coordinate newZombie = new Coordinate(0,0);
            newZombie.setPositionX(zombie.getPositionX());
            newZombie.setPositionY(zombie.getPositionY());
            grid.setMatrix(matrix);
            zombies.add(newZombie);
        }
    }

    public Grid recordCreature(Grid grid, Coordinate creature) {
        int[][] matrix = grid.getMatrix();
        matrix[creature.getPositionX()][creature.getPositionY()] = 1;
        grid.setMatrix(matrix);
        return grid;
    }

    public void zombieMoving(List<Coordinate> zombies, List<Coordinate> creatures, String[] directions, Grid grid){
        for (int i=0;i<zombies.size();i++){
            for (String direction : directions) {
                zombieMovement.zombieMoving(zombies.get(i), direction, grid.getGridSize());
                recordZombieMovement(zombies, creatures, zombies.get(i), grid);
            }
        }
    }

    private void infectionCreature(List<Coordinate> creatures, int positionX, int positionY) {
        Coordinate infectedCreature = new Coordinate(positionX,positionY);
        creatures.remove(infectedCreature);
    }
}
