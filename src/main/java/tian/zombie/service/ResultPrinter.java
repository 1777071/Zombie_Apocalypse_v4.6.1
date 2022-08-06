package tian.zombie.service;

import tian.zombie.entity.Creature;
import tian.zombie.entity.Zombie;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
public class ResultPrinter {
    public void zombiePrinter(List<Zombie> zombies){
        log.info("zombies’ positions: \n");
        zombies.forEach((zombie) -> {
            log.info("("+ zombie.getPositionX() + ","+ zombie.getPositionY() + ")");
        });
    }

    public void creaturePrinter(List<Creature> creatures){
        if(creatures.size() == 0){
            log.info("none");
            return;
        }
        log.info("creatures' position: \n");
        creatures.forEach((creature) -> {
            log.info("("+ creature.getPositionX() + ","+ creature.getPositionY() + ")");
        });
    }
}
