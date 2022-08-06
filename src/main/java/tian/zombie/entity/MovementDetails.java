package tian.zombie.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class MovementDetails {
    static Map<String, Integer> movement = new HashMap<>();;
    static {
        movement.put("R",1);
        movement.put("L",-1);
        movement.put("D",1);
        movement.put("U",-1);
    }

    public int getDirection(String move) {
        return movement.get(move);
    }
}
