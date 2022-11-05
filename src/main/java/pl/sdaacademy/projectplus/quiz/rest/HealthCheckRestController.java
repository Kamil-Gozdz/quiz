package pl.sdaacademy.projectplus.quiz.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.projectplus.quiz.dto.HealthCheckDto;

@RestController
@RequestMapping("/api/health")
public class HealthCheckRestController {

    @GetMapping
    public HealthCheckDto healthCheck() {
        return new HealthCheckDto(true, "It' working");

    }

}
