package Finance_app.financeApp.controllers;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Finance_app.financeApp.entities.Budgetmensuel;
import Finance_app.financeApp.entities.User;
import Finance_app.financeApp.entities.Categorie;
import Finance_app.financeApp.service.BudgetmensuelService;
import Finance_app.financeApp.service.UserService;
import Finance_app.financeApp.service.CategorieService;

@RestController
@RequestMapping("/api/budgets")
public class BudgetmensuelController {

	 @Autowired
	    private BudgetmensuelService budgetmensuelService;

	    @Autowired
	    private UserService userService; // Injection de UserService

	    @Autowired
	    private CategorieService categorieService; // Injection de CategorieService

	    // Créer un nouveau budget mensuel
	    @PostMapping
	    public ResponseEntity<Budgetmensuel> createBudget(@RequestBody Budgetmensuel budget) {
	        Budgetmensuel savedBudget = budgetmensuelService.saveOrUpdate(budget);
	        if (savedBudget != null) {
	            return ResponseEntity.ok(savedBudget);
	        } else {
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    // Récupérer tous les budgets mensuels
	    @GetMapping
	    public ResponseEntity<List<Budgetmensuel>> getAllBudgets() {
	        List<Budgetmensuel> budgets = budgetmensuelService.getAll();
	        return ResponseEntity.ok(budgets);
	    }

	    // Récupérer un budget mensuel par son ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Budgetmensuel> getBudgetById(@PathVariable Integer id) {
	        Budgetmensuel budget = budgetmensuelService.findByIdBudget(id);
	        if (budget != null) {
	            return ResponseEntity.ok(budget);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Mettre à jour un budget mensuel
	    @PutMapping("/{id}")
	    public ResponseEntity<Budgetmensuel> updateBudget(@PathVariable Integer id, @RequestBody Budgetmensuel budget) {
	        Budgetmensuel existingBudget = budgetmensuelService.findByIdBudget(id);
	        if (existingBudget != null) {
	            budget.setIdBudget(id); // Assurez-vous que l'ID est correctement défini
	            Budgetmensuel updatedBudget = budgetmensuelService.saveOrUpdate(budget);
	            return ResponseEntity.ok(updatedBudget);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Supprimer un budget mensuel par son ID
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteBudget(@PathVariable Integer id) {
	        Budgetmensuel deletedBudget = budgetmensuelService.delete(id);
	        if (deletedBudget != null) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Rechercher des budgets mensuels par mot-clé (mois)
	    @GetMapping("/search")
	    public ResponseEntity<List<Budgetmensuel>> searchBudgets(@RequestParam String keyword) {
	        List<Budgetmensuel> budgets = budgetmensuelService.searchBudgets(keyword);
	        return ResponseEntity.ok(budgets);
	    }

	    // Récupérer des budgets mensuels par montant maximum
	    @GetMapping("/by-montant")
	    public ResponseEntity<List<Budgetmensuel>> getBudgetsByMontantMax(@RequestParam BigDecimal montantMax) {
	        List<Budgetmensuel> budgets = budgetmensuelService.findByMontantMax(montantMax);
	        return ResponseEntity.ok(budgets);
	    }

	    // Récupérer des budgets mensuels par mois
	    @GetMapping("/by-mois")
	    public ResponseEntity<List<Budgetmensuel>> getBudgetsByMois(@RequestParam String mois) {
	        List<Budgetmensuel> budgets = budgetmensuelService.findByMois(mois);
	        return ResponseEntity.ok(budgets);
	    }

	    // Récupérer des budgets mensuels par statut d'alerte
	    @GetMapping("/by-alerte")
	    public ResponseEntity<List<Budgetmensuel>> getBudgetsByAlerteEnvoyee(@RequestParam Boolean alerteEnvoyee) {
	        List<Budgetmensuel> budgets = budgetmensuelService.findByAlerteEnvoyee(alerteEnvoyee);
	        return ResponseEntity.ok(budgets);
	    }

	    // Récupérer les budgets mensuels d'un utilisateur
	    @GetMapping("/by-user/{userId}")
	    public ResponseEntity<List<Budgetmensuel>> getBudgetsByUser(@PathVariable Integer userId) {
	        User user = userService.findByIdUtilisateur(userId); // Utilisation de userService
	        if (user != null) {
	            List<Budgetmensuel> budgets = budgetmensuelService.findByUser(user);
	            return ResponseEntity.ok(budgets);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Récupérer les budgets mensuels d'une catégorie
	    @GetMapping("/by-categorie/{categorieId}")
	    public ResponseEntity<List<Budgetmensuel>> getBudgetsByCategorie(@PathVariable Integer categorieId) {
	        Categorie categorie = categorieService.findByIdCategorie(categorieId); // Utilisation de categorieService
	        if (categorie != null) {
	            List<Budgetmensuel> budgets = budgetmensuelService.findByCategorie(categorie);
	            return ResponseEntity.ok(budgets);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
