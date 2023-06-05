package easyBot.testTask.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "desktops")
public class Desktop extends Product {
    @Column(name = "form_factor")
    private FormFactor formFactor;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public Desktop(FormFactor formFactor) {
        super();
        this.formFactor = formFactor;
    }
}
