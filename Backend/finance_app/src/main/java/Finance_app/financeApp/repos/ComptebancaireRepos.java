package Finance_app.financeApp.repos;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Finance_app.financeApp.entities.Comptebancaire;
import Finance_app.financeApp.entities.User;
public interface ComptebancaireRepos  extends JpaRepository<Comptebancaire, Integer> {

	 List<Comptebancaire> findByNomBanque(String nomBanque);
	    Comptebancaire findByNumeroCompte(String numeroCompte);
	    List<Comptebancaire> findByDevise(String devise);
	    List<Comptebancaire> findByDateCreation(Date dateCreation);
	    List<Comptebancaire> findByNomBanqueContainingOrNumeroCompteContaining(String nomBanque, String numeroCompte);
	    List<Comptebancaire> findByIdUtilisateur(User user);
}
