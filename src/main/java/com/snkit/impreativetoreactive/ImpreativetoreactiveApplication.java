package com.snkit.impreativetoreactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ImpreativetoreactiveApplication  implements CommandLineRunner{
	
	@Autowired
	UserAddServiceImpl userAddService;

	public static void main(String[] args) {
		SpringApplication.run(ImpreativetoreactiveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userAddService.getUserAdd();
		
	}

}

