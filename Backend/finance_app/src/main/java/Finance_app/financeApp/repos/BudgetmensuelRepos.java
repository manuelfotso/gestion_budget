package Finance_app.financeApp.repos;
 
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Finance_app.financeApp.entities.Budgetmensuel;
import Finance_app.financeApp.entities.User;
import Finance_app.financeApp.entities.Categorie;

public interface BudgetmensuelRepos extends JpaRepository<Budgetmensuel, Integer> {
	List<Budgetmensuel> findByMontantMax(BigDecimal montantMax);
    List<Budgetmensuel> findByMois(String mois);
    List<Budgetmensuel> findByAlerteEnvoyee(Boolean alerteEnvoyee);
    List<Budgetmensuel> findByMoisContaining(String mois);
    List<Budgetmensuel> findByIdUtilisateur(User user);
    List<Budgetmensuel> findByIdCategorie(Categorie categorie);
}
