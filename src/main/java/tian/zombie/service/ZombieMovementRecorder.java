package tian.zombie.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tian.zombie.entity.Coordinate;
import tian.zombie.entity.Creature;
import tian.zombie.entity.Grid;
import tian.zombie.entity.Zombie;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ZombieMovementRecorder {
    private final Map<Character, Coordinate> zombieMovingDirection;

    private void recordZombieMovement(Queue<Zombie> zombiesQueue, List<Creature> creatures, Map<Coordinate,Creature> creatureLocation, Zombie zombie, Grid grid) {
        if (grid.isCreatureExisting(zombie)) {
            infectCreature(creatures, creatureLocation, zombie, grid, zombiesQueue);
        }
    }

    public List<Zombie> zombieMoving(List<Zombie> zombies, List<Creature> creatures, Map<Coordinate,Creature> creatureLocation, String directions, Grid grid) {
        Queue<Zombie> zombiesQueue = new LinkedList<>(zombies);
        List<Zombie> allZombie = new ArrayList<>();
        while(zombiesQueue.size()>0){
            Zombie zombie = zombiesQueue.poll();
            allZombie.add(zombie);
            for (int j = 0 ; j< directions.length(); j++){
                zombie.move(zombieMovingDirection.get(directions.charAt(j)), grid.getGridSize());
                recordZombieMovement(zombiesQueue, creatures, creatureLocation, zombie, grid);
            }
        }
        return allZombie;
    }

    private void infectCreature(List<Creature> creatures, Map<Coordinate,Creature> creatureLocation, Zombie zombie, Grid grid, Queue<Zombie> zombiesQueue) {
        if(creatureLocation.containsKey(zombie.getPosition())){
            creatures.remove(creatureLocation.get(zombie.getPosition()));
            creatureLocation.remove(zombie.getPosition());
        }
        grid.removeCreatureFromGrid(zombie.getPosition());
        Coordinate infectLocation = new Coordinate(zombie.getPosition().getPositionX(), zombie.getPosition().getPositionY());
        Zombie newZombie = new Zombie(infectLocation);
        zombiesQueue.add(newZombie);

    }
}
