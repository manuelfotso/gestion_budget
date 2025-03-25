package Finance_app.financeApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import Finance_app.financeApp.entities.User;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepos extends JpaRepository<User, Integer> {
	 User findByNom(String nom);
	    User findByPrenom(String prenom);
	    User findByEmail(String email);
	    User findByLoginuser(String loginuser);
	    List<User> findByDateCreation(Date dateCreation);
	    List<User> findByNomContainingOrPrenomContainingOrEmailContaining(String nom, String prenom, String email);
}
