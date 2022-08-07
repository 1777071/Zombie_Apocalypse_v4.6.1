package tian.zombie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tian.zombie.entity.Coordinate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ZombieConfig {

    @Bean
    public Map<String, Coordinate> zombieMovingDirection() {
        Map<String,Coordinate> movement = new HashMap<>();
        movement.put("R", new Coordinate(1,0));
        movement.put("L", new Coordinate(-1,0));
        movement.put("D", new Coordinate(0,1));
        movement.put("U", new Coordinate(0,-1));
        return movement;
    }
}
