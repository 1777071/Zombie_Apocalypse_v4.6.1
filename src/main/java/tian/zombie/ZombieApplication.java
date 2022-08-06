package tian.zombie;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import tian.zombie.entity.Creature;
import tian.zombie.entity.Grid;
import tian.zombie.entity.Zombie;
import tian.zombie.service.ReadParams;
import tian.zombie.service.Movement;
import tian.zombie.service.ResultPrinter;
import tian.zombie.service.ZombieMovementRecorder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@SpringBootApplication
public class ZombieApplication {
    public static void main(String[] args) {
        ZombieMovementRecorder zombieMovementRecorder = new ZombieMovementRecorder();
        ReadParams readJSON = new ReadParams();
        Grid grid = new Grid(readJSON.getGrid());
        List<Zombie> zombies = readJSON.getZombies();
        List<Creature> creatures = readJSON.getCreatures();
        for (Creature creature : creatures){
            grid = zombieMovementRecorder.recordCreature(grid,creature);
        }
        String move = readJSON.getMove();
        String[] directions = move.split("");
        Grid finalGrid = grid;
        for(int i=0; i< zombies.size();i++){
            for (String direction : directions){
                Movement movement = new Movement();
                log.info("x position  is: " +zombies.get(i).getPositionX());
                log.info("y position  is: " +zombies.get(i).getPositionY());
                movement.zombieMoving(zombies.get(i),direction, finalGrid.getGridSize());
                zombieMovementRecorder.recordZombieMovement(zombies, creatures,zombies.get(i), finalGrid);
            }
        }
        ResultPrinter resultPrinter = new ResultPrinter();
        resultPrinter.zombiePrinter(zombies);
        resultPrinter.creaturePrinter(creatures);

    }
}
