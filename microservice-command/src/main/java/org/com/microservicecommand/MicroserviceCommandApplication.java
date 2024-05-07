package org.com.microservicecommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroserviceCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCommandApplication.class, args);
	}

}
