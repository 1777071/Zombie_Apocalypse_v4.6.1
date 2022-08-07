package tian.zombie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ZombieApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZombieApplication.class, args);
    }
}
