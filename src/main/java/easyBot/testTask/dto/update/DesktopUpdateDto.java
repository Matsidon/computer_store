package easyBot.testTask.dto.update;

import easyBot.testTask.model.FormFactor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DesktopUpdateDto extends ProductUpdateDto {
    @NonNull
    private FormFactor formFactor;
}
