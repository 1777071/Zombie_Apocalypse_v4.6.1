package tian.zombie.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tian.zombie.entity.Coordinate;
import tian.zombie.entity.Grid;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZombieMovementRecorderTest {
    @Autowired
    private ZombieMovement zombieMovement;

    @Test
    void recordZombieMovement(){
        Coordinate creatures = new Coordinate(1,2);
        Grid grid = new Grid(4);
        ZombieMovementRecorder zombieMovementRecorder = new ZombieMovementRecorder(zombieMovement);
        zombieMovementRecorder.recordCreature(grid, creatures);
        int[][] matrix = grid.getMatrix();
        assertEquals(1,matrix[1][2]);
    }
}
