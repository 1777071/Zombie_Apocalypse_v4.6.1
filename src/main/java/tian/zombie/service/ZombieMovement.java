package tian.zombie.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tian.zombie.entity.Coordinate;

import java.util.Map;

@Slf4j
@Service
public class ZombieMovement {
    @Autowired
    private Map<String, Coordinate> zombieMovingDirection;

    public void zombieMoving(Coordinate zombie, String direction, int gridSize) {
        zombie.setPositionX(Math.floorMod(zombie.getPositionX() + zombieMovingDirection.get(direction).getPositionX(), gridSize));
        zombie.setPositionY(Math.floorMod(zombie.getPositionY() + zombieMovingDirection.get(direction).getPositionY(), gridSize));
    }

}
