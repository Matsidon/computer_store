package easyBot.testTask.dto.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LaptopUpdateDto extends ProductUpdateDto {
    @NonNull
    private Integer sizeType;
}
