package pl.sdaacademy.projectplus.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HealthCheckDto {

    private boolean status;

    private String message;

}
