package com.sp.sb.flash.config;

import com.sp.sb.flash.entity.Guardian;
import com.sp.sb.flash.entity.Student;
import com.sp.sb.flash.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student suresh = new Student("Suresh", "Paulrajan", "suresh@email.com", LocalDate.of(1992, Month.JUNE, 8));
            Student pavithra = new Student( "Pavithra", "Suresh","pavithra@email.com", LocalDate.of(1997, Month.MAY, 26));
            Student vikki = new Student("Vignesh", "Kumar", "vikki@email.com", LocalDate.of(1992, Month.MAY, 23), new Guardian("Guard_Name","guard_email@email.com","5500339922"));

//            repository.saveAll(
//                    List.of(suresh, pavithra, vikki)
//            );
        };
    }
}
