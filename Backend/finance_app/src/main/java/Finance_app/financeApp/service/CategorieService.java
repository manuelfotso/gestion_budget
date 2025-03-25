package Finance_app.financeApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Finance_app.financeApp.entities.Categorie;
import Finance_app.financeApp.repos.CategorieRepos;

@Service
public class CategorieService {

	 @Autowired
	    private CategorieRepos categorieRepos;

	    // Sauvegarder ou mettre à jour une catégorie
	    public Categorie saveOrUpdate(Categorie categorie) {
	        if (categorie.getNomCategorie() != null && !categorie.getNomCategorie().isEmpty() &&
	            categorie.getType() != null && !categorie.getType().isEmpty()) {
	            return categorieRepos.save(categorie);
	        }
	        return null;
	    }

	    // Récupérer toutes les catégories
	    public List<Categorie> getAll() {
	        return categorieRepos.findAll();
	    }

	    // Récupérer une catégorie par son ID
	    public Categorie findByIdCategorie(Integer idCategorie) {
	        Optional<Categorie> categorie = categorieRepos.findById(idCategorie);
	        return categorie.orElse(null);
	    }

	    // Récupérer une catégorie par son nom
	    public Categorie findByNomCategorie(String nomCategorie) {
	        return categorieRepos.findByNomCategorie(nomCategorie);
	    }

	    // Récupérer des catégories par type
	    public List<Categorie> findByType(String type) {
	        return categorieRepos.findByType(type);
	    }

	    // Supprimer une catégorie par son ID
	    public Categorie delete(Integer idCategorie) {
	        Optional<Categorie> categorie = categorieRepos.findById(idCategorie);
	        if (categorie.isPresent()) {
	            categorieRepos.deleteById(idCategorie);
	            return categorie.get();
	        }
	        return null;
	    }

	    // Rechercher des catégories par mot-clé (nom ou type)
	    public List<Categorie> searchCategories(String motCle) {
	        return categorieRepos.findByNomCategorieContainingOrTypeContaining(motCle, motCle);
	    }
}
