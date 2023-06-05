package easyBot.testTask.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, length = 16, nullable = false)
    private UUID id;
    @Column(name = "serial_number")
    private String serialNumber;
    private String maker;
    private int price;
    private int count;
}
