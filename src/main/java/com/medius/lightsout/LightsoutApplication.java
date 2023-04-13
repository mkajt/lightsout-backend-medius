package com.medius.lightsout;

import com.medius.lightsout.entity.Problem;
import com.medius.lightsout.repository.LightsoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class LightsoutApplication implements CommandLineRunner {

	@Autowired
	LightsoutRepository lightsoutRepository;

	public static void main(String[] args) {
		SpringApplication.run(LightsoutApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(0);
		numbers.add(0);
		numbers.add(1);
		numbers.add(0);
		numbers.add(1);
		numbers.add(0);
		numbers.add(0);
		numbers.add(0);
		numbers.add(1);

		Problem problem1 = new Problem(0, numbers);
		lightsoutRepository.add(problem1);
	}
}
