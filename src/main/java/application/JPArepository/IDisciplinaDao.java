package application.JPArepository;

import org.springframework.data.jpa.repository.JpaRepository;
import application.modelo.Disciplina;

public interface IDisciplinaDao extends JpaRepository<Disciplina, Long> {

}
