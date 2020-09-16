package com.nuance.shark.hacks.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.nuance.shark.hacks.demo.common.SharedConstants;

@SpringBootApplication(scanBasePackages = SharedConstants.BASE_PACKAGE)
@EnableJpaRepositories(SharedConstants.BASE_PACKAGE)
@EntityScan(SharedConstants.BASE_PACKAGE)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
