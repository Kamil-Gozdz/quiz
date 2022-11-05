package pl.sdaacademy.projectplus.quiz;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sdaacademy.projectplus.quiz.database.entity.PlayerEntity;
import pl.sdaacademy.projectplus.quiz.database.repository.PlayerRepository;
import pl.sdaacademy.projectplus.quiz.service.QuizDataService;

import javax.transaction.Transactional;
import java.util.List;

@Log
@Component
public class StartUpRunner implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private QuizDataService quizDataService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        log.info("Executing startup actions...");
        playerRepository.save(new PlayerEntity("John"));
        playerRepository.save(new PlayerEntity("Patrick"));
        playerRepository.save(new PlayerEntity("Adam"));

        log.info("List of players from database: ");
        List<PlayerEntity> playersFromDatabase = playerRepository.findAll();
        for(PlayerEntity player: playersFromDatabase){
            log.info("Retrieved player " + player);
        }
        quizDataService.getQuizCategories();
    }
}
