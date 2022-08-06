package tian.zombie.service;
import org.apache.commons.lang3.StringUtils;
import tian.zombie.entity.Creature;
import tian.zombie.entity.Zombie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadParams {
    public String getMove() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int getGrid() {
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    public List<Zombie> getZombies() {
        Scanner sc = new Scanner(System.in);
        String[] zombieCollection = StringUtils.substringsBetween(sc.nextLine(),"(",")");
        List<Zombie> zombies = new ArrayList<>();

        try {
            for (String s : zombieCollection) {
                String[] position = s.split(",");
                Zombie zombie = new Zombie();
                zombie.setPositionX(Integer.parseInt(position[0]));
                zombie.setPositionY(Integer.parseInt(position[1]));
                zombies.add(zombie);
            }
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return zombies;
    }

    public List<Creature> getCreatures() {
        Scanner sc = new Scanner(System.in);
        String[] creaturesCollection = StringUtils.substringsBetween(sc.nextLine(),"(",")");
        List<Creature> creatures = new ArrayList<>();
        try {
            for (String s : creaturesCollection) {
                String[] position = s.split(",");
                Creature creature = new Creature();
                creature.setPositionX(Integer.parseInt(position[0]));
                creature.setPositionY(Integer.parseInt(position[1]));
                creatures.add(creature);
            }
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return creatures;
    }
}
