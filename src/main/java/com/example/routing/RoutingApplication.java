package com.example.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.HashMap;

@SpringBootApplication
public class RoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutingApplication.class, args);
	}
}
