package application;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication
public class SagiBackendApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SagiBackendApplication.class, args);
		
		for (String s : ctx.getBeanDefinitionNames()) {
			System.out.println(s);
		}
		
		
	}

	
}
