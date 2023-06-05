package easyBot.testTask.utils;

import easyBot.testTask.dto.create.*;
import easyBot.testTask.dto.update.*;
import easyBot.testTask.model.*;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toProduct(ProductInputDto productInputDto) {
        if (LaptopInputDto.class.equals(productInputDto.getClass())) {
            Laptop laptop = new Laptop(((LaptopInputDto) productInputDto).getSizeType());
            laptop.setSerialNumber(productInputDto.getSerialNumber());
            laptop.setMaker(productInputDto.getMaker());
            laptop.setCount(productInputDto.getCount());
            laptop.setPrice(productInputDto.getPrice());
            return laptop;
        } else if (DesktopInputDto.class.equals(productInputDto.getClass())) {
            Desktop desktop = new Desktop(((DesktopInputDto) productInputDto).getFormFactor());
            desktop.setSerialNumber(productInputDto.getSerialNumber());
            desktop.setMaker(productInputDto.getMaker());
            desktop.setCount(productInputDto.getCount());
            desktop.setPrice(productInputDto.getPrice());
            return desktop;
        } else if (ScreenInputDto.class.equals(productInputDto.getClass())) {
            Screen screen = new Screen((((ScreenInputDto) productInputDto).getDiagonal()));
            screen.setSerialNumber(productInputDto.getSerialNumber());
            screen.setMaker(productInputDto.getMaker());
            screen.setCount(productInputDto.getCount());
            screen.setPrice(productInputDto.getPrice());
            return screen;
        } else {
            HardDrive hardDrive = new HardDrive(((HardDriveInputDto) productInputDto).getGB());
            hardDrive.setSerialNumber(productInputDto.getSerialNumber());
            hardDrive.setMaker(productInputDto.getMaker());
            hardDrive.setCount(productInputDto.getCount());
            hardDrive.setPrice(productInputDto.getPrice());
            return hardDrive;
        }
    }
    public Product toProduct(ProductUpdateDto productUpdateDto) {
        if (LaptopUpdateDto.class.equals(productUpdateDto.getClass())) {
            Laptop laptop = new Laptop(((LaptopUpdateDto) productUpdateDto).getSizeType());
            laptop.setSerialNumber(productUpdateDto.getSerialNumber());
            laptop.setMaker(productUpdateDto.getMaker());
            laptop.setCount(productUpdateDto.getCount());
            laptop.setPrice(productUpdateDto.getPrice());
            laptop.setId(productUpdateDto.getId());
            return laptop;
        } else if (DesktopUpdateDto.class.equals(productUpdateDto.getClass())) {
            Desktop desktop = new Desktop(((DesktopUpdateDto) productUpdateDto).getFormFactor());
            desktop.setSerialNumber(productUpdateDto.getSerialNumber());
            desktop.setMaker(productUpdateDto.getMaker());
            desktop.setCount(productUpdateDto.getCount());
            desktop.setPrice(productUpdateDto.getPrice());
            desktop.setId(productUpdateDto.getId());
            return desktop;
        } else if (ScreenUpdateDto.class.equals(productUpdateDto.getClass())) {
            Screen screen = new Screen((((ScreenUpdateDto) productUpdateDto).getDiagonal()));
            screen.setSerialNumber(productUpdateDto.getSerialNumber());
            screen.setMaker(productUpdateDto.getMaker());
            screen.setCount(productUpdateDto.getCount());
            screen.setPrice(productUpdateDto.getPrice());
            screen.setId(productUpdateDto.getId());
            return screen;
        } else {
            HardDrive hardDrive = new HardDrive(((HardDriveUpdateDto) productUpdateDto).getGB());
            hardDrive.setSerialNumber(productUpdateDto.getSerialNumber());
            hardDrive.setMaker(productUpdateDto.getMaker());
            hardDrive.setCount(productUpdateDto.getCount());
            hardDrive.setPrice(productUpdateDto.getPrice());
            hardDrive.setId(productUpdateDto.getId());
            return hardDrive;
        }
    }
}
