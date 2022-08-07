package tian.zombie.entity;

import lombok.Data;

@Data
public class Coordinate {
    private int positionX;
    private int positionY;

    public Coordinate(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }
}
