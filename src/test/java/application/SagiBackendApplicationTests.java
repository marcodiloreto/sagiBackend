package application;

import application.JPArepository.IPersonaDao;
import application.modelo.Persona;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SagiBackendApplicationTests {

	private final Logger LOGGER = LoggerFactory.getLogger(SagiBackendApplicationTests.class);

	@Autowired
	private IPersonaDao pDao;

	@Test
	void contextLoads() {

		List<Persona> personas = pDao.findAll();

		for (Persona p : personas) {
			LOGGER.info(p.toString());
		}
	}

}
