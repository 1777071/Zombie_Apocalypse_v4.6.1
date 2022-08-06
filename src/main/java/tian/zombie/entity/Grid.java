package tian.zombie.entity;

import lombok.Data;

@Data
public class Grid {
    private int gridSize;
    private int [][] matrix;

    public Grid(int gridSize) {
        this.gridSize = gridSize;
        this.matrix = new int[gridSize][gridSize];
    }
}
