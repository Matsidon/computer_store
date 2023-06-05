package easyBot.testTask.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "laptops")
public class Laptop extends Product {
    @Column(name = "size_type")
    private Integer sizeType;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public Laptop(Integer sizeType) {
        super();
        this.sizeType = sizeType;
    }

}
