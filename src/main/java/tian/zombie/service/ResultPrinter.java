package tian.zombie.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tian.zombie.entity.Coordinate;

import java.util.List;

@Slf4j
@Service
public class ResultPrinter {
    public void zombiePrinter(List<Coordinate> zombies) {
        log.info("zombies’ positions: \n");
        zombies.forEach((zombie) -> log.info("(" + zombie.getPositionX() + "," + zombie.getPositionY() + ")"));
    }

    public void creaturePrinter(List<Coordinate> creatures) {
        log.info("creatures' position: \n");
        if (creatures.size() == 0) {
            log.info("none");
            return;
        }
        creatures.forEach((creature) -> log.info("(" + creature.getPositionX() + "," + creature.getPositionY() + ")"));
    }
}
