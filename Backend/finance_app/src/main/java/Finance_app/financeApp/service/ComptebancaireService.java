package Finance_app.financeApp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Finance_app.financeApp.entities.Comptebancaire;
import Finance_app.financeApp.entities.User;
import Finance_app.financeApp.repos.ComptebancaireRepos;
@Service
public class ComptebancaireService {

	   @Autowired
	    private ComptebancaireRepos comptebancaireRepos;

	    // Sauvegarder ou mettre à jour un compte bancaire
	    public Comptebancaire saveOrUpdate(Comptebancaire compte) {
	        if (compte.getNomBanque() != null && !compte.getNomBanque().isEmpty() &&
	            compte.getNumeroCompte() != null && !compte.getNumeroCompte().isEmpty() &&
	            compte.getSoldeInitial() != null && compte.getDevise() != null && !compte.getDevise().isEmpty()) {
	            return comptebancaireRepos.save(compte);
	        }
	        return null;
	    }

	    // Récupérer tous les comptes bancaires
	    public List<Comptebancaire> getAll() {
	        return comptebancaireRepos.findAll();
	    }

	    // Récupérer un compte bancaire par son ID
	    public Comptebancaire findByIdCompte(Integer idCompte) {
	        Optional<Comptebancaire> compte = comptebancaireRepos.findById(idCompte);
	        return compte.orElse(null);
	    }

	    // Récupérer un compte bancaire par le nom de la banque
	    public List<Comptebancaire> findByNomBanque(String nomBanque) {
	        return comptebancaireRepos.findByNomBanque(nomBanque);
	    }

	    // Récupérer un compte bancaire par le numéro de compte
	    public Comptebancaire findByNumeroCompte(String numeroCompte) {
	        return comptebancaireRepos.findByNumeroCompte(numeroCompte);
	    }

	    

	    // Supprimer un compte bancaire par son ID
	    public Comptebancaire delete(Integer idCompte) {
	        Optional<Comptebancaire> compte = comptebancaireRepos.findById(idCompte);
	        if (compte.isPresent()) {
	            comptebancaireRepos.deleteById(idCompte);
	            return compte.get();
	        }
	        return null;
	    }

	    // Rechercher des comptes bancaires par mot-clé (nom de la banque ou numéro de compte)
	    public List<Comptebancaire> searchComptes(String motCle) {
	        return comptebancaireRepos.findByNomBanqueContainingOrNumeroCompteContaining(motCle, motCle);
	    }

	    // Récupérer les comptes bancaires d'un utilisateur
	    public List<Comptebancaire> findByUser(User user) {
	        return comptebancaireRepos.findByIdUtilisateur(user);
	    }
}
