package application.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import application.modelo.Actividad;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ServiceTests {

	private final Logger LOGGER = LoggerFactory.getLogger(ServiceTests.class);

	@Autowired
	private ActividadService as;
	
	@Test
	public void findAllTest() {
		List<Actividad> la = as.findAllActividades();
		
		//la.stream().forEach(a -> a.fullToString());
	}
}
