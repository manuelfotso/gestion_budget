package Finance_app.financeApp.repos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Finance_app.financeApp.entities.Transaction;
import Finance_app.financeApp.entities.User;
import Finance_app.financeApp.entities.Categorie;
import Finance_app.financeApp.entities.Comptebancaire;
public interface TransactionRepos extends JpaRepository<Transaction, Integer> {
	
	List<Transaction> findByMontant(BigDecimal montant);
    List<Transaction> findByDateTransaction(Date dateTransaction);
    List<Transaction> findByDescription(String description);
    List<Transaction> findByDescriptionContaining(String motCle);
    List<Transaction> findByIdUtilisateur(User user);
    List<Transaction> findByIdCategorie(Categorie categorie);
    List<Transaction> findByIdCompte(Comptebancaire compte);
}
