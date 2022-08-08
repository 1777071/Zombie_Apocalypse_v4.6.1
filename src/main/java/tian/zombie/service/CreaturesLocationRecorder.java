package tian.zombie.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tian.zombie.entity.Coordinate;
import tian.zombie.entity.Creature;
import tian.zombie.entity.Grid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CreaturesLocationRecorder {

    public Map<Coordinate, Creature> recordCreatureLocation(Grid grid, List<Creature> creatures) {
        Map<Coordinate, Creature> creatureLocation = new HashMap<>();
        for (Creature creature : creatures) {
            grid.recordCreatureLocationInGrid(creature.getPosition());
            creatureLocation.put(creature.getPosition(), creature);
        }
        return creatureLocation;
    }

}
