package Finance_app.financeApp.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Finance_app.financeApp.entities.Rapport;
import Finance_app.financeApp.entities.User;
import Finance_app.financeApp.repos.RapportRepos;

@Service
public class RapportService {

	 @Autowired
	    private RapportRepos rapportRepos;

	    // Sauvegarder ou mettre à jour un rapport
	    public Rapport saveOrUpdate(Rapport rapport) {
	        if (rapport.getPeriode() != null && !rapport.getPeriode().isEmpty() &&
	            rapport.getTotalDepenses() != null && rapport.getTotalRevenus() != null) {
	            return rapportRepos.save(rapport);
	        }
	        return null;
	    }

	    // Récupérer tous les rapports
	    public List<Rapport> getAll() {
	        return rapportRepos.findAll();
	    }

	    // Récupérer un rapport par son ID
	    public Rapport findByIdRapport(Short idRapport) {
	        Optional<Rapport> rapport = rapportRepos.findById(idRapport);
	        return rapport.orElse(null);
	    }

	    // Récupérer des rapports par période
	    public List<Rapport> findByPeriode(String periode) {
	        return rapportRepos.findByPeriode(periode);
	    }

	    // Récupérer des rapports par total des dépenses
	    public List<Rapport> findByTotalDepenses(BigDecimal totalDepenses) {
	        return rapportRepos.findByTotalDepenses(totalDepenses);
	    }

	    // Récupérer des rapports par total des revenus
	    public List<Rapport> findByTotalRevenus(BigDecimal totalRevenus) {
	        return rapportRepos.findByTotalRevenus(totalRevenus);
	    }

	    // Supprimer un rapport par son ID
	    public Rapport delete(Short idRapport) {
	        Optional<Rapport> rapport = rapportRepos.findById(idRapport);
	        if (rapport.isPresent()) {
	            rapportRepos.deleteById(idRapport);
	            return rapport.get();
	        }
	        return null;
	    }

	    // Rechercher des rapports par mot-clé (période)
	    public List<Rapport> searchRapports(String motCle) {
	        return rapportRepos.findByPeriodeContaining(motCle);
	    }

	    // Récupérer les rapports d'un utilisateur
	    public List<Rapport> findByUser(User user) {
	        return rapportRepos.findByIdUtilisateur(user);
	    }
}
