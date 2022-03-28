package application.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import application.modelo.Disciplina;

public interface DisciplinaService {

	public List<Disciplina> findAllDisciplinas();

	public Page<Disciplina> findAllDisciplinas(Pageable pageable);

	public Disciplina findDisciplinaById(Long id);

	public Disciplina saveDisciplina(Disciplina Disciplina);

	public boolean deleteDisciplina(Long id);
}
