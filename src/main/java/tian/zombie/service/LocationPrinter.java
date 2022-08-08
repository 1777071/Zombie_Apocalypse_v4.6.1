package tian.zombie.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tian.zombie.entity.Creature;
import tian.zombie.entity.Zombie;

import java.util.List;

@Slf4j
@Service
public class LocationPrinter {
    public void zombiePrinter(List<Zombie> zombies) {
        log.info("zombies’ positions: \n");
        zombies.forEach((zombie) -> log.info(zombie.getPosition().printLocation()));
    }

    public void creaturePrinter(List<Creature> creatures) {
        log.info("creatures' position: \n");
        if (creatures.size() == 0) {
            log.info("none");
            return;
        }
       creatures.forEach((creature) -> log.info(creature.getPosition().printLocation()));
    }
}
