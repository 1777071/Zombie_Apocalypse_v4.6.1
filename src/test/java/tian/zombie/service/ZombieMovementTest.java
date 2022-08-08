package tian.zombie.service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tian.zombie.entity.Coordinate;
import tian.zombie.entity.Creature;
import tian.zombie.entity.Grid;
import tian.zombie.entity.Zombie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ZombieMovementTest {
    @Autowired
    private ZombieMovementRecorder zombieMovementRecorder;

    @Test
    void zombieHorizontalMoving() {
        Zombie zombie1 = new Zombie(new Coordinate(0,1));
        List<Zombie> zombieList= new ArrayList<>();
        zombieList.add(zombie1);
        Creature creature1 = new Creature(new Coordinate(3,1));
        Creature creature2 = new Creature(new Coordinate(3,2));
        List<Creature> creatureList = new ArrayList<>();
        creatureList.add(creature1);
        creatureList.add(creature2);
        String directions = "LD";
        CreaturesLocationRecorder creaturesLocationRecorder = new CreaturesLocationRecorder();
        Grid grid = new Grid(4);
        Map<Coordinate,Creature> creatureLocation = creaturesLocationRecorder.recordCreatureLocation(grid, creatureList);
        List<Zombie> zombiesFinalLocation =  zombieMovementRecorder.zombieStartMoving(zombieList,creatureLocation,directions,grid);
        assertEquals(3,zombiesFinalLocation.size());
    }

}
