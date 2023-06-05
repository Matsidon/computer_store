package easyBot.testTask.dto.update;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import easyBot.testTask.dto.create.*;
import lombok.*;

import java.util.UUID;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = DesktopUpdateDto.class, name = "desktop"),
        @JsonSubTypes.Type(value = HardDriveUpdateDto.class, name = "hardDrive"),
        @JsonSubTypes.Type(value = LaptopUpdateDto.class, name = "laptop"),
        @JsonSubTypes.Type(value = ScreenUpdateDto.class, name = "screen")})
public abstract class ProductUpdateDto extends ProductInputDto {
    private UUID id;
}
