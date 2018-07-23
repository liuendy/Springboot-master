package com.master;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@SpringBootApplication
public class SpringbootFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFeignApplication.class, args);
	}

	@RestController
	class HelloController {

		@PostMapping("/user")
		public UserDto user(@RequestBody UserDto userDto) throws Exception {
			return userDto;
		}

	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	static class UserDto {

		private String userName;
		private LocalDate birthday;

	}

	@Bean
	public ObjectMapper serializingObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.registerModule(new JavaTimeModule());
		return objectMapper;
	}
}
