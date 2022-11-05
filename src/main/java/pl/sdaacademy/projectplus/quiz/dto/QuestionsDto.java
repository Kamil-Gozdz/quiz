package pl.sdaacademy.projectplus.quiz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
public class QuestionsDto {
    @JsonProperty("response_code")
    private int responseCode;

    List<QuestionDto> results;

    @Getter
    @ToString
    @NoArgsConstructor
    public static class QuestionDto {
        private String category;
        private String type;
        private String difficulty;
        private String question;
        @JsonProperty("correct_answer")
        private String correctAnswer;
        @JsonProperty("incorrect_answers")
        private List<String> incorrectAnswers;

    }
}
