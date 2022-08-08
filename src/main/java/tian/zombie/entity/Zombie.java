package tian.zombie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Zombie {
    private Coordinate position;

    public void move(Coordinate movement, int gridSize){
      position.setPositionX(Math.floorMod(position.getPositionX() + movement.getPositionX(), gridSize));
      position.setPositionY(Math.floorMod(position.getPositionY() + movement.getPositionY(), gridSize));
    }

}
