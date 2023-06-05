package easyBot.testTask.dto.create;

import lombok.*;
import org.springframework.lang.NonNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HardDriveInputDto extends ProductInputDto {
    @NonNull
    private double GB;
}
