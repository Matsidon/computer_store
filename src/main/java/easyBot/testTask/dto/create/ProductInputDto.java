package easyBot.testTask.dto.create;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = DesktopInputDto.class, name = "desktop"),
        @JsonSubTypes.Type(value = HardDriveInputDto.class, name = "hardDrive"),
        @JsonSubTypes.Type(value = LaptopInputDto.class, name = "laptop"),
        @JsonSubTypes.Type(value = ScreenInputDto.class, name = "screen")})
public abstract class ProductInputDto {
    private String serialNumber;
    private String maker;
    private int price;
    private int count;
}
