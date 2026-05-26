package com.homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeworkProjectApplication implements CommandLineRunner {

    private final CakeBaker cakeBaker;

    public HomeworkProjectApplication(CakeBaker cakeBaker){
        this.cakeBaker = cakeBaker;
    }

	public static void main(String[] args) {
		SpringApplication.run(HomeworkProjectApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        cakeBaker.bakeCake();
    }
}
