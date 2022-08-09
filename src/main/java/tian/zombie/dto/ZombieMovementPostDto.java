package tian.zombie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tian.zombie.entity.Creature;
import tian.zombie.entity.Zombie;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZombieMovementPostDto {
    @NotBlank
    private Integer gridSize;

    @NotNull
    private List<Zombie> zombies;

    @NotNull
    private List<Creature> creatures;

    @NotNull
    private String move;
}
