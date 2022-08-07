package tian.zombie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ZombieApplication {
    public static void main(String[] args) {
//        log.info(String.valueOf(-1%4));
//        ZombieMovementRecorder zombieMovementRecorder = new ZombieMovementRecorder();
//        ReadParams readJSON = new ReadParams();
//        Grid grid = new Grid(readJSON.getGrid());
//        List<Zombie> zombies = readJSON.getZombies();
//        List<Creature> creatures = readJSON.getCreatures();
//        for (Creature creature : creatures) {
//            grid = zombieMovementRecorder.recordCreature(grid, creature);
//        }
//        String move = readJSON.getMove();
//        String[] directions = move.split("");
//        Grid finalGrid = grid;
//        for (int i = 0; i < zombies.size(); i++) {
//            for (String direction : directions) {
//                Movement movement = new Movement();
//                log.info("x position  is: " + zombies.get(i).getPositionX());
//                log.info("y position  is: " + zombies.get(i).getPositionY());
//                movement.zombieMoving(zombies.get(i), direction, finalGrid.getGridSize());
//                zombieMovementRecorder.recordZombieMovement(zombies, creatures, zombies.get(i), finalGrid);
//            }
//        }
//        ResultPrinter resultPrinter = new ResultPrinter();
//        resultPrinter.zombiePrinter(zombies);
//        resultPrinter.creaturePrinter(creatures);
        SpringApplication.run(ZombieApplication.class,args);
    }
}
