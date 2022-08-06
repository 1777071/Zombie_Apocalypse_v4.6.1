package tian.zombie.service;

import lombok.extern.slf4j.Slf4j;
import tian.zombie.entity.Creature;
import tian.zombie.entity.Grid;
import tian.zombie.entity.Zombie;

import java.util.List;

@Slf4j
public class ZombieMovementRecorder {
    public void recordZombieMovement(List<Zombie> zombies, List<Creature> creatures, Zombie zombie, Grid grid){
        int[][] matrix = grid.getMatrix();
        if(matrix[zombie.getPositionX()][zombie.getPositionY()] == 1){
            log.info("zombie infected creature at " + zombie.getPositionX() + " " + zombie.getPositionY());
            infectionCreature(creatures,zombie.getPositionX(),zombie.getPositionY());
            matrix[zombie.getPositionX()][zombie.getPositionY()] = 0;
            Zombie newZombie = new Zombie();
            newZombie.setPositionX(zombie.getPositionX());
            newZombie.setPositionY(zombie.getPositionY());
            grid.setMatrix(matrix);
            zombies.add(newZombie);
        }
    }

    public Grid recordCreature(Grid grid, Creature creature){
        int[][] matrix = grid.getMatrix();
        matrix[creature.getPositionX()][creature.getPositionY()] = 1;
        grid.setMatrix(matrix);
        return grid;
    }

    public void infectionCreature(List<Creature> creatures, int positionX, int positionY){
        Creature infectedCreature = new Creature();
        infectedCreature.setPositionX(positionX);
        infectedCreature.setPositionY(positionY);
        creatures.remove(infectedCreature);
    }
}
