package com.mehmetpekdemir.fileexport;

import com.mehmetpekdemir.fileexport.entity.TutorialEntity;
import com.mehmetpekdemir.fileexport.repository.TutorialRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@SpringBootApplication
public class FileExportApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileExportApplication.class, args);
    }

    @Bean
    CommandLineRunner createData(TutorialRepository tutorialRepository) {
        return (args) -> {
            tutorialRepository.save(new TutorialEntity("Title1", "Description1", true));
            tutorialRepository.save(new TutorialEntity("Title2", "Description2", true));
            tutorialRepository.save(new TutorialEntity("Title3", "Description3", true));
        };
    }

}
