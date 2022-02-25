package com.ryxen;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.ryxen.config.BlidingProperties;


@SpringBootApplication
@EnableConfigurationProperties(BlidingProperties.class)
public class StartServer {
	public static void main(String[] args) {
		SpringApplication.run(StartServer.class, args);
	}
}
