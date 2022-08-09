package tian.zombie.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tian.zombie.entity.Coordinate;
import tian.zombie.entity.Creature;
import tian.zombie.entity.Grid;
import tian.zombie.entity.Zombie;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ZombieMovementRecorder {
    private final Map<Character, Coordinate> zombieMovingDirection;

    private void recordZombieInfection(Queue<Zombie> zombiesQueue, Map<Coordinate, Creature> creatureLocation, Zombie zombie, Grid grid) {
        if (grid.isCreatureExisting(zombie)) {
            Zombie newZombie = infectCreature(creatureLocation, zombie.getPosition(), grid);
            zombiesQueue.add(newZombie);
        }
    }

    public List<Zombie> zombieStartMoving(List<Zombie> zombies, Map<Coordinate, Creature> creatureLocation, String directions, Grid grid) {
        Queue<Zombie> zombiesQueue = new LinkedList<>(zombies);
        List<Zombie> allZombie = new ArrayList<>();
        while (!zombiesQueue.isEmpty()) {
            Zombie zombie = zombiesQueue.poll();
            for (int j = 0; j < directions.length(); j++) {
                zombie.move(zombieMovingDirection.get(directions.charAt(j)), grid.getGridSize());
                recordZombieInfection(zombiesQueue, creatureLocation, zombie, grid);
            }
            allZombie.add(zombie);
        }
        return allZombie;
    }

    private Zombie infectCreature(Map<Coordinate, Creature> creaturesLocation, Coordinate zombieLocation, Grid grid) {
        creaturesLocation.remove(zombieLocation);
        grid.removeCreatureFromGrid(zombieLocation);
        Coordinate infectLocation = new Coordinate(zombieLocation);
        return new Zombie(infectLocation);
    }
}
