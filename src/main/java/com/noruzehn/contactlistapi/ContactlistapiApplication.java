package com.noruzehn.contactlistapi;

import com.noruzehn.contactlistapi.entity.Contact;
import com.noruzehn.contactlistapi.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactlistapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactlistapiApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ContactRepository contactRepository) {
        return (args) -> {
            List<Contact> contacts = Arrays.asList(
                    new Contact("Jorge", "jorge@gmail.com", LocalDateTime.now()),
                    new Contact("Juan", "juan@gmail.com", LocalDateTime.now()),
                    new Contact("Daniel", "daniel@gmail.com", LocalDateTime.now()),
                    new Contact("Ana", "ana@gmail.com", LocalDateTime.now()),
                    new Contact("Kevin", "kevin@gmail.com", LocalDateTime.now())
            );
            contactRepository.saveAll(contacts);
        };
    }
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}