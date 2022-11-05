package pl.sdaacademy.projectplus.quiz.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class CategoriesDto {

    @JsonProperty("trivia_categories")
    private List<CategoryDto> categories;

    @Getter
    @ToString
    @NoArgsConstructor
    public static class CategoryDto {
        private int id;
        private String name;
    }
}
