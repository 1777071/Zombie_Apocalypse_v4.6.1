package tian.zombie.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tian.zombie.entity.Coordinate;
import tian.zombie.entity.Creature;
import tian.zombie.entity.Zombie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class LocationPrinter {
    public void printZombieLocation(List<Zombie> zombies) {
        log.info("zombies’ positions: \n");
        zombies.forEach((zombie) -> log.info(zombie.getPosition().printLocation()));
    }

    public void printCreatureLocation(Map<Coordinate, Creature> creatureLocation) {
        List<Creature> creatures = new ArrayList<>(creatureLocation.values());
        log.info("creatures' position: \n");
        if (creatures.size() == 0) {
            log.info("none");
            return;
        }
        creatures.forEach((creature) -> log.info(creature.getPosition().printLocation()));
    }
}
