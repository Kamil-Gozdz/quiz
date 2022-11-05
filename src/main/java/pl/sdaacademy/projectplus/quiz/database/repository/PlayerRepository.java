package pl.sdaacademy.projectplus.quiz.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdaacademy.projectplus.quiz.database.entity.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

}
