package com.intesxsoft.studyingproject;

import com.intesxsoft.studyingproject.config.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyingProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[] {StudyingProjectApplication.class, JpaConfig.class}, args);
    }

}
