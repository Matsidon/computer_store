package easyBot.testTask.dto.create;

import easyBot.testTask.model.FormFactor;
import lombok.*;
import org.springframework.lang.NonNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DesktopInputDto extends ProductInputDto {
    @NonNull
    private FormFactor formFactor;
}
