package com.Retos.CicloTres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.Retos.CicloTres.model"})
@SpringBootApplication
public class CicloTresApplication {

	public static void main(String[] args) {
		SpringApplication.run(CicloTresApplication.class, args);
	}

}
