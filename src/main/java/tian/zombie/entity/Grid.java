package tian.zombie.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Grid {
    private int gridSize;
    private int[][] matrix;

    public Grid(int gridSize) {
        this.gridSize = gridSize;
        this.matrix = new int[gridSize][gridSize];
    }

    public boolean isCreatureExisting(Zombie zombie){
        return matrix[zombie.getPosition().getPositionX()][zombie.getPosition().getPositionY()] == 1;
    }

    public void removeCreatureFromGrid(Coordinate coordinate){
        matrix[coordinate.getPositionX()][coordinate.getPositionY()] = 0;
    }

    public void recordCreatureLocationInGrid(Coordinate coordinate){
        matrix[coordinate.getPositionX()][coordinate.getPositionY()] = 1;
    }


}
