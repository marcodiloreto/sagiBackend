package application.JPArepository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class JpaRepositoryTests {

	private final Logger LOGGER = LoggerFactory.getLogger(JpaRepositoryTests.class);

	@Autowired
	private IPersonaDao pDao;
	
	@Autowired
	private IActividadDao aDao;
	
//	//@Test
//	public void personaFindAll() {
//		List<Persona> personas = pDao.findAll();
//
//		for (Persona p : personas) {
//			LOGGER.info(p.toString());
//		}
//	}
//
//	//@Test
//	public void personaFindByID() {
//
//		LOGGER.info(pDao.findById(2L).toString());
//	}
//
//	@Test
//	public void lazyTest() {
//		Optional<Persona> op = pDao.findById(2L);
//		if(op.isPresent()) {
//			//Persona p = ;
//			System.out.println(op.get()/*p.getActividades()*/);
//			
//		}
//		
//	}
	
//	@Test
//	public void disciplinaTest() {
//		Actividad a = aDao.findById(1L).get();
//		a.setPersonas(aDao.getPersonas(a.getID()));
//		System.out.println(a.getPersonas());
//	}
//	
}
