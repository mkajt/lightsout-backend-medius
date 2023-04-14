package com.medius.lightsout;

import com.medius.lightsout.entity.Problem;
import com.medius.lightsout.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;


@SpringBootApplication
public class LightsoutApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(LightsoutApplication.class, args);
		ProblemRepository lightsoutRepository = configurableApplicationContext.getBean(ProblemRepository.class);

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
		Problem problem1 = new Problem(numbers);
		lightsoutRepository.save(problem1);
	}

}
