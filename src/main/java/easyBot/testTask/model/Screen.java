package easyBot.testTask.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "screens")
public class Screen extends Product {
    private double diagonal;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public Screen(double diagonal) {
        super();
        this.diagonal = diagonal;
    }

}
