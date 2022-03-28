package application;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import application.JPArepository.IActividadDao;

@SpringBootApplication
public class SagiBackendApplication {
	
//	@Autowired
//	private static IActividadDao aDao;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
//		ApplicationContext ctx = 
				SpringApplication.run(SagiBackendApplication.class, args);
		
		
		
	}
	
}
