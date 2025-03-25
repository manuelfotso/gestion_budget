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

import Finance_app.financeApp.entities.Rapport;
import Finance_app.financeApp.entities.User;
import Finance_app.financeApp.service.RapportService;
import Finance_app.financeApp.service.UserService;

@RestController
@RequestMapping("/api/rapports")
public class RapportController {

	 @Autowired
	    private RapportService rapportService;

	    @Autowired
	    private UserService userService; // Injection de UserService

	    // Créer un nouveau rapport
	    @PostMapping
	    public ResponseEntity<Rapport> createRapport(@RequestBody Rapport rapport) {
	        Rapport savedRapport = rapportService.saveOrUpdate(rapport);
	        if (savedRapport != null) {
	            return ResponseEntity.ok(savedRapport);
	        } else {
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    // Récupérer tous les rapports
	    @GetMapping
	    public ResponseEntity<List<Rapport>> getAllRapports() {
	        List<Rapport> rapports = rapportService.getAll();
	        return ResponseEntity.ok(rapports);
	    }

	    // Récupérer un rapport par son ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Rapport> getRapportById(@PathVariable Short id) {
	        Rapport rapport = rapportService.findByIdRapport(id);
	        if (rapport != null) {
	            return ResponseEntity.ok(rapport);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Mettre à jour un rapport
	    @PutMapping("/{id}")
	    public ResponseEntity<Rapport> updateRapport(@PathVariable Short id, @RequestBody Rapport rapport) {
	        Rapport existingRapport = rapportService.findByIdRapport(id);
	        if (existingRapport != null) {
	            rapport.setIdRapport(id); // Assurez-vous que l'ID est correctement défini
	            Rapport updatedRapport = rapportService.saveOrUpdate(rapport);
	            return ResponseEntity.ok(updatedRapport);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Supprimer un rapport par son ID
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteRapport(@PathVariable Short id) {
	        Rapport deletedRapport = rapportService.delete(id);
	        if (deletedRapport != null) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Rechercher des rapports par mot-clé (période)
	    @GetMapping("/search")
	    public ResponseEntity<List<Rapport>> searchRapports(@RequestParam String keyword) {
	        List<Rapport> rapports = rapportService.searchRapports(keyword);
	        return ResponseEntity.ok(rapports);
	    }

	    // Récupérer des rapports par période
	    @GetMapping("/by-periode")
	    public ResponseEntity<List<Rapport>> getRapportsByPeriode(@RequestParam String periode) {
	        List<Rapport> rapports = rapportService.findByPeriode(periode);
	        return ResponseEntity.ok(rapports);
	    }

	    // Récupérer des rapports par total des dépenses
	    @GetMapping("/by-depenses")
	    public ResponseEntity<List<Rapport>> getRapportsByTotalDepenses(@RequestParam BigDecimal totalDepenses) {
	        List<Rapport> rapports = rapportService.findByTotalDepenses(totalDepenses);
	        return ResponseEntity.ok(rapports);
	    }

	    // Récupérer des rapports par total des revenus
	    @GetMapping("/by-revenus")
	    public ResponseEntity<List<Rapport>> getRapportsByTotalRevenus(@RequestParam BigDecimal totalRevenus) {
	        List<Rapport> rapports = rapportService.findByTotalRevenus(totalRevenus);
	        return ResponseEntity.ok(rapports);
	    }

	    // Récupérer les rapports d'un utilisateur
	    @GetMapping("/by-user/{userId}")
	    public ResponseEntity<List<Rapport>> getRapportsByUser(@PathVariable Integer userId) {
	        User user = userService.findByIdUtilisateur(userId); // Utilisation de userService
	        if (user != null) {
	            List<Rapport> rapports = rapportService.findByUser(user);
	            return ResponseEntity.ok(rapports);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
