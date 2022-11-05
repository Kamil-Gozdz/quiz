package pl.sdaacademy.projectplus.quiz.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pl.sdaacademy.projectplus.quiz.dto.CategoriesDto;
import pl.sdaacademy.projectplus.quiz.dto.QuestionsDto;
import pl.sdaacademy.projectplus.quiz.frontend.Difficulty;
import pl.sdaacademy.projectplus.quiz.frontend.GameOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Log
@Service
@SessionScope
public class OngoingGameService {

    private GameOptions gameOptions;

    private int currentQuestionIndex;

    private int points;

    private List<QuestionsDto.QuestionDto> questions;

    @Autowired
    QuizDataService quizDataService;

    public void init(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
        this.currentQuestionIndex = 0;
        this.points = 0;

        this.questions = quizDataService.getQuizQuestions(gameOptions);

    }

    public int getCurrentQuestionNumber() {
        return currentQuestionIndex + 1;
    }

    public int getTotalQuestionNumber() {
        return questions.size();
    }

    public String getCurrentQuestion() {
        QuestionsDto.QuestionDto dto = questions.get(currentQuestionIndex);
        return dto.getQuestion();
    }

    public List<String> getCurrentQuestionAnswersInRandom() {
        QuestionsDto.QuestionDto dto = questions.get(currentQuestionIndex);

        List<String> answers = new ArrayList<>();
        answers.add(dto.getCorrectAnswer());
        answers.addAll(dto.getIncorrectAnswers());
        Collections.shuffle(answers);
        return answers;
    }

    public boolean checkCorrectAnswerForCurrentQuestionAndUpdatePoints(String userAnswer) {
        QuestionsDto.QuestionDto dto = questions.get(currentQuestionIndex);
        boolean correct = dto.getCorrectAnswer().equals(userAnswer);
        if (correct) {
            points++;
        }
        return correct;
    }

    public int getCurrentPointsForUser() {
        return points;
    }

    public boolean getToNextQuestion() {
        currentQuestionIndex++;
        return currentQuestionIndex < questions.size();
    }

    public Difficulty getDifficulty() {
        return gameOptions.getDifficulty();
    }
public String getCategoryName(){
    Optional<String> category = quizDataService.getQuizCategories().stream()
            .filter(categoryDto -> categoryDto.getId() == gameOptions.getCategoryId())
            .map(CategoriesDto.CategoryDto::getName)
            .findAny();
    return category.orElse(null);

}
}
