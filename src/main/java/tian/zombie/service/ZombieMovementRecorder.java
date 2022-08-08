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
            infectCreature(creatureLocation, zombie, grid, zombiesQueue);
        }
    }

    public List<Zombie> zombieStartMoving(List<Zombie> zombies, Map<Coordinate, Creature> creatureLocation, String directions, Grid grid) {
        Queue<Zombie> zombiesQueue = new LinkedList<>(zombies);
        List<Zombie> allZombie = new ArrayList<>();
        while (!zombiesQueue.isEmpty()) {
            Zombie zombie = zombiesQueue.poll();
            allZombie.add(zombie);
            for (int j = 0; j < directions.length(); j++) {
                zombie.move(zombieMovingDirection.get(directions.charAt(j)), grid.getGridSize());
                recordZombieInfection(zombiesQueue, creatureLocation, zombie, grid);
            }
        }
        return allZombie;
    }

    private void infectCreature(Map<Coordinate, Creature> creatureLocation, Zombie zombie, Grid grid, Queue<Zombie> zombiesQueue) {
        creatureLocation.remove(zombie.getPosition());
        grid.removeCreatureFromGrid(zombie.getPosition());
        Coordinate infectLocation = new Coordinate(zombie.getPosition().getPositionX(), zombie.getPosition().getPositionY());
        Zombie newZombie = new Zombie(infectLocation);
        zombiesQueue.add(newZombie);

    }
}
