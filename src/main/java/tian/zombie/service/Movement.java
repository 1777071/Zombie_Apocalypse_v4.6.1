package tian.zombie.service;

import lombok.extern.slf4j.Slf4j;
import tian.zombie.entity.MovementDetails;
import tian.zombie.entity.Zombie;

import java.util.List;

@Slf4j
public class Movement {
    public boolean crossLine(int currentPosition, int gridSize){
        return currentPosition >= gridSize;
    }
    public void zombieMoving(Zombie zombie, String direction, int gridSize){
        MovementDetails movementDetails = new MovementDetails();
        int lateralMovement = direction.equals("R") || direction.equals("L") ? zombie.getPositionX() + movementDetails.getDirection(direction) : zombie.getPositionX();
        int longitudinalMovement = direction.equals("U") || direction.equals("D") ? zombie.getPositionY() + movementDetails.getDirection(direction) : zombie.getPositionY();

        int currentXPosition = crossLine(lateralMovement,gridSize) ? 0 : lateralMovement;
        int currentYPosition = crossLine(longitudinalMovement,gridSize) ? 0 : longitudinalMovement;

        zombie.setPositionX(currentXPosition);
        zombie.setPositionY(currentYPosition);
    }

}
