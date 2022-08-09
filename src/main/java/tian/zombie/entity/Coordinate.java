package tian.zombie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinate {
    private int positionX;
    private int positionY;

    public Coordinate(Coordinate coordinate) {
        this.positionX = coordinate.getPositionX();
        this.positionY = coordinate.getPositionY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return positionX == that.positionX && positionY == that.positionY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionX, positionY);
    }

    public String printLocation() {
        return "(" + positionX + "," + positionY + ")";
    }
}
