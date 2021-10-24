package com.clc.bop.buzzard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class BuzzardApp {
	public static void main(String[] args) {
		SpringApplication.run(BuzzardApp.class, args);
	}
}
