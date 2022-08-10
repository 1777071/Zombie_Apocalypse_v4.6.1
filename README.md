# Zombie_Apocalypse

## Main tech stacks and tools
- Spring Boot
- Junit4
- Grandle
- Java 11

## Context

After the nuclear war, a strange and deadly virus has infected the planet producing mindless zombies. These zombies now wander the world converting any remaining living creatures they find to zombies as well. The world is represented by an n x n grid on which zombies and creatures live. The location of zombies and creatures can be addressed using zero-indexed x-y coordinates. The top left corner of the world is (x: 0, y: 0). The horizontal coordinate is represented by x, and the vertical coordinate is represented by y. At the beginning of the program, a single zombie awakes and begins to move around the grid following a sequence of movements. Valid movements are Up, Down, Left, Right. The movement sequence is represented by a string of single character movements, e.g. RDRU (Right, Down, Right, Up). Zombies can move through the edge of the grid, appearing on the directly opposite side. For a 10x10 grid, a zombie moving left from (0, 4) will move to (9, 4); a zombie moving down from (3, 9) will move to (3, 0). Each time a zombie takes a step, the new location should be logged, eg: zombie 0 moved to (2,3). If a zombie occupies the same square as a creature, the creature is transformed into another zombie. Each time a zombie infects a creature this should be logged, eg: zombie 0 infected creature at (3,3) The creatures are aware of the zombie’s presence but are so frightened that they never move. Once a zombie has completed its movement, the first newly created zombie moves using the same sequence as the original zombie, then the second newly created zombie moves, and so on, in order of infection. Each zombie performs the same sequence of moves. Once all zombies have completed moving, the final positions of all zombies and creatures should be output, then the program ends


### Input:

The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0. The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover’s position, and the second line is a series of instructions telling the rover how to explore the plateau. The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover’s orientation. Each rover will be finished sequentially, which means that the second rover won’t start to move until the first one has finished moving.


### Output:

The output for each rover should be its final co-ordinates and heading.

#### Example: <br> 
input: <br>

```
5 5
1 2 N
3 3 E
1 3 N
5 1 E
```
output: <br>

```
1 3 N
5 1 E
```



## How to run this project
1. Clone this repository into local computer
2. Open the project folder with the intellij IDEA.
3. Change the Java version to Java 11 in intellij. <br>
4. Go to the src/main/java/MarsRoversApplication.java 
5. Modify the run configuration, set "input" as program arguments, then run the main function.

