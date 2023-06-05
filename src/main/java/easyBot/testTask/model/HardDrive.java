package easyBot.testTask.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "hard_drives")
public class HardDrive extends Product {
    private double GB;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID id;

    public HardDrive(double GB) {
        super();
        this.GB = GB;
    }
}
