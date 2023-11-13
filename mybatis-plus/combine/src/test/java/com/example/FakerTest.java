package com.example;

import com.example.bean.entity.AccountInfo;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;

@SpringBootTest(classes = MybatisPlusApplication.class)
public class FakerTest {

    @Test
    public void test01(){
        for (int i = 0; i < 100; i++) {
            Faker faker = new Faker(new Locale("en"));

            String username = faker.name().username();
            String password = faker.internet().password();
            String fullName = faker.name().fullName();
            AccountInfo.Gender gender = faker.options().option(AccountInfo.Gender.class);
            LocalDate dateOfBirth = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String email = faker.internet().emailAddress();
            String phoneNumber = faker.phoneNumber().cellPhone();
            String address = faker.address().fullAddress();
            LocalDateTime registrationDate = LocalDateTime.now();
            LocalDateTime lastLogin = registrationDate.minusDays(faker.number().numberBetween(1, 30));
            boolean active = faker.bool().bool();

            AccountInfo accountInfo = new AccountInfo(
                    username, password, fullName, gender, dateOfBirth, email, phoneNumber, address, active
            );
            System.out.println(phoneNumber);
//        System.out.println(accountInfo);
        }
    }

}
