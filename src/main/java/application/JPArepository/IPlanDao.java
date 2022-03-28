package application.JPArepository;

import org.springframework.data.jpa.repository.JpaRepository;
import application.modelo.Plan;

public interface IPlanDao extends JpaRepository<Plan, Long> {

}
