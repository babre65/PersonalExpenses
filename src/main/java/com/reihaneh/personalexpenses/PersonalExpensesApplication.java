package com.reihaneh.personalexpenses;

import com.reihaneh.personalexpenses.service.UserService;
import com.reihaneh.personalexpenses.service.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@Slf4j
public class PersonalExpensesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalExpensesApplication.class, args);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            UserDto userDto = new UserDto();
            userDto.setFirstName("Ali");
            userDto.setUsername("ali");
            userDto.setPassword("123");
            userDto = userService.save(userDto);
            log.info("saved user : {}", userDto);
        };
    }
}
