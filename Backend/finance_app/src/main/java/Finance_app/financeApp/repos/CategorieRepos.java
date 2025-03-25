package Finance_app.financeApp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Finance_app.financeApp.entities.Categorie;
public interface CategorieRepos extends JpaRepository<Categorie, Integer> {

	 Categorie findByNomCategorie(String nomCategorie);
	    List<Categorie> findByType(String type);
	    List<Categorie> findByNomCategorieContainingOrTypeContaining(String nomCategorie, String type);
}
