package com.reihaneh.personalexpenses;

import com.reihaneh.personalexpenses.config.ApplicationProperties;
import com.reihaneh.personalexpenses.domain.enums.ExpenseType;
import com.reihaneh.personalexpenses.domain.enums.PaymentType;
import com.reihaneh.personalexpenses.service.CategoryService;
import com.reihaneh.personalexpenses.service.ExpenseService;
import com.reihaneh.personalexpenses.service.UserService;
import com.reihaneh.personalexpenses.service.dto.CategoryDto;
import com.reihaneh.personalexpenses.service.dto.ExpenseDto;
import com.reihaneh.personalexpenses.service.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
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
    CommandLineRunner run(UserService userService, CategoryService categoryService, ExpenseService expenseService) {
        return args -> {
            UserDto userDto = new UserDto();
            userDto.setFirstName("Ali");
            userDto.setUsername("ali");
            userDto.setPassword("123");
            userDto = userService.save(userDto);
            log.info("saved user : {}", userDto);

            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName("Food");
            categoryDto = categoryService.save(categoryDto);
            log.info("Category Saved : {}", categoryDto);

            ExpenseDto expenseDto = new ExpenseDto();
            expenseDto.setAmount(BigDecimal.valueOf(10));
            expenseDto.setType(ExpenseType.EXPENSE);
            expenseDto.setPaymentType(PaymentType.CARD);
            expenseDto.setPurchaseDate(LocalDateTime.now());
            expenseDto.setNote("Groceries");
            expenseDto.setCategoryId(categoryDto.getId());
            expenseDto.setUserId(userDto.getId());
            expenseDto = expenseService.save(expenseDto);
            log.info("Expense saved : {}", expenseDto);
        };
    }
}
