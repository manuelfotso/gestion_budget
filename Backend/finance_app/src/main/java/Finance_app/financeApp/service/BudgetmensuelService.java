package Finance_app.financeApp.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Finance_app.financeApp.entities.Budgetmensuel;
import Finance_app.financeApp.entities.User;
import Finance_app.financeApp.entities.Categorie;
import Finance_app.financeApp.repos.BudgetmensuelRepos;

@Service
public class BudgetmensuelService {

	   @Autowired
	    private BudgetmensuelRepos budgetmensuelRepos;

	    // Sauvegarder ou mettre à jour un budget mensuel
	    public Budgetmensuel saveOrUpdate(Budgetmensuel budget) {
	        if (budget.getMontantMax() != null && budget.getMois() != null && !budget.getMois().isEmpty()) {
	            return budgetmensuelRepos.save(budget);
	        }
	        return null;
	    }

	    // Récupérer tous les budgets mensuels
	    public List<Budgetmensuel> getAll() {
	        return budgetmensuelRepos.findAll();
	    }

	    // Récupérer un budget mensuel par son ID
	    public Budgetmensuel findByIdBudget(Integer idBudget) {
	        Optional<Budgetmensuel> budget = budgetmensuelRepos.findById(idBudget);
	        return budget.orElse(null);
	    }

	    // Récupérer des budgets mensuels par montant maximum
	    public List<Budgetmensuel> findByMontantMax(BigDecimal montantMax) {
	        return budgetmensuelRepos.findByMontantMax(montantMax);
	    }

	    // Récupérer des budgets mensuels par mois
	    public List<Budgetmensuel> findByMois(String mois) {
	        return budgetmensuelRepos.findByMois(mois);
	    }

	    // Récupérer des budgets mensuels par statut d'alerte
	    public List<Budgetmensuel> findByAlerteEnvoyee(Boolean alerteEnvoyee) {
	        return budgetmensuelRepos.findByAlerteEnvoyee(alerteEnvoyee);
	    }

	    // Supprimer un budget mensuel par son ID
	    public Budgetmensuel delete(Integer idBudget) {
	        Optional<Budgetmensuel> budget = budgetmensuelRepos.findById(idBudget);
	        if (budget.isPresent()) {
	            budgetmensuelRepos.deleteById(idBudget);
	            return budget.get();
	        }
	        return null;
	    }

	    // Rechercher des budgets mensuels par mot-clé (mois)
	    public List<Budgetmensuel> searchBudgets(String motCle) {
	        return budgetmensuelRepos.findByMoisContaining(motCle);
	    }

	    // Récupérer les budgets mensuels d'un utilisateur
	    public List<Budgetmensuel> findByUser(User user) {
	        return budgetmensuelRepos.findByIdUtilisateur(user);
	    }

	    // Récupérer les budgets mensuels d'une catégorie
	    public List<Budgetmensuel> findByCategorie(Categorie categorie) {
	        return budgetmensuelRepos.findByIdCategorie(categorie);
	    }
}
