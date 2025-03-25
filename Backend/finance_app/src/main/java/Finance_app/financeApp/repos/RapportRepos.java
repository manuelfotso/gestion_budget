package Finance_app.financeApp.repos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Finance_app.financeApp.entities.Rapport;
import Finance_app.financeApp.entities.User;
public interface RapportRepos extends JpaRepository<Rapport, Short> {
	 List<Rapport> findByPeriode(String periode);
	    List<Rapport> findByTotalDepenses(BigDecimal totalDepenses);
	    List<Rapport> findByTotalRevenus(BigDecimal totalRevenus);
	    List<Rapport> findByPeriodeContaining(String periode);
	    List<Rapport> findByIdUtilisateur(User user);
}
