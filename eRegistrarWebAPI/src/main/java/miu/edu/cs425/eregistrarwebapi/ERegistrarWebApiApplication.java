package miu.edu.cs425.eregistrarwebapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ERegistrarWebApiApplication {

	public static void main(String[] args) {


		SpringApplication.run(ERegistrarWebApiApplication.class, args);
	}

}
