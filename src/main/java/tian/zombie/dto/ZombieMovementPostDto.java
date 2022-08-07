package tian.zombie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import tian.zombie.entity.Coordinate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
public class ZombieMovementPostDto {
    @NotBlank
    private Integer gridSize;

    @NotNull
    private List<Coordinate> zombies;

    @NotNull
    private List<Coordinate> creatures;

    @NotNull
    private String move;
}
