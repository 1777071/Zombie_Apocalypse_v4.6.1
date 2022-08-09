package tian.zombie.service;

import org.junit.jupiter.api.Test;
import tian.zombie.entity.Coordinate;
import tian.zombie.entity.Creature;
import tian.zombie.entity.Grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreaturesLocationRecorderTest {

    @Test
    void recordCreatureLocation() {
        Creature creature1 = new Creature(new Coordinate(1, 2));
        Creature creature2 = new Creature(new Coordinate(2, 3));
        List<Creature> creatures = new ArrayList<>();
        creatures.add(creature1);
        creatures.add(creature2);
        CreaturesLocationRecorder creaturesLocationRecorder = new CreaturesLocationRecorder();
        Grid grid = new Grid(4);
        Map<Coordinate, Creature> creatureLocation = creaturesLocationRecorder.recordCreatureLocation(grid, creatures);
        int[][] matrix = grid.getMatrix();
        assertEquals(1, matrix[1][2]);
        assertEquals(1, matrix[2][3]);
    }
}
