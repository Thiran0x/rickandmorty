package com.desafio.rickandmorty.rickandmorty;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RickandmortyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RickandmortyApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		//System.out.println("Hello");
	}
}
