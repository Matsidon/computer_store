package easyBot.testTask.dto.create;
import lombok.*;
import org.springframework.lang.NonNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LaptopInputDto extends ProductInputDto {
    @NonNull
    private Integer sizeType;
}
