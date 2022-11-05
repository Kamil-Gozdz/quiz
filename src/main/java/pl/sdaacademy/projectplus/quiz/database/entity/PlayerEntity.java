package pl.sdaacademy.projectplus.quiz.database.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "PLAYERS")
@NoArgsConstructor
public class PlayerEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

    public PlayerEntity(String name) {
        this.name = name;
    }
}
