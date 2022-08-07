package tian.zombie.service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tian.zombie.entity.Coordinate;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ZombieMovementTest {
    @Autowired
    private ZombieMovement zombieMovement;

    @Test
    void zombieHorizontalMoving() {
        Coordinate zombieLocation = new Coordinate(3,3);
        zombieMovement.zombieMoving(zombieLocation,"R",4);
        assertEquals(0,zombieLocation.getPositionX());
        assertEquals(3,zombieLocation.getPositionY());
    }

    @Test
    void zombieLongitudinalMoving(){
        Coordinate zombieLocation = new Coordinate(3,3);
        zombieMovement.zombieMoving(zombieLocation,"D",4);
        assertEquals(3,zombieLocation.getPositionX());
        assertEquals(0,zombieLocation.getPositionY());
    }
}
