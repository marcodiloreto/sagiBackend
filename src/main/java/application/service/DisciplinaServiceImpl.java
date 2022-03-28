package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import application.JPArepository.IDisciplinaDao;
import application.modelo.Disciplina;
import application.modelo.Persona;

@Service("disciplinaService")
public class DisciplinaServiceImpl implements DisciplinaService {

	@Autowired
	private IDisciplinaDao dDao;

	@Override
	public List<Disciplina> findAllDisciplinas() {
		return dDao.findAll();
	}

	@Override
	public Page<Disciplina> findAllDisciplinas(Pageable pageable) {
		return dDao.findAll(pageable);
	}

	@Override
	public Disciplina findDisciplinaById(Long id) {
		return dDao.getById(id);
	}

	@Override
	public Disciplina saveDisciplina(Disciplina d) {
		return dDao.save(d);
	}

	@Override
	public boolean deleteDisciplina(Long id) {
		try {
			dDao.deleteById(id);
		} catch (Exception e) {
			System.out.println("occurió un error al borrar la disciplina");
			return false;
		}
		return true;
	}
}
