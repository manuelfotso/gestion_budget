package Finance_app.financeApp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import Finance_app.financeApp.repos.UserRepos;
import Finance_app.financeApp.entities.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
	
	  @Autowired
	    UserRepos userRepos;

	    public User saveOrUpdate(User user) {
	        if (!user.getNom().isEmpty() && !user.getEmail().isEmpty()) {
	            return userRepos.save(user);
	        }
	        return null;
	    }

	    public List<User> getAll() {
	        return userRepos.findAll();
	    }

	    
	    public User findByIdUtilisateur(Integer idUtilisateur) {
	        Optional<User> user = userRepos.findById(idUtilisateur);
	        return user.orElse(null);
	    }

	    public User findByNom(String nom) {
	        return userRepos.findByNom(nom);
	    }

	    public User findByPrenom(String prenom) {
	        return userRepos.findByPrenom(prenom);
	    }

	    public User findByEmail(String email) {
	        return userRepos.findByEmail(email);
	    }

	    public User findByLoginuser(String loginuser) {
	        return userRepos.findByLoginuser(loginuser);
	    }

	    public List<User> findByDateCreation(Date dateCreation) {
	        return userRepos.findByDateCreation(dateCreation);
	    }
	    
	    public User delete(Integer idUtilisateur) {
	        Optional<User> user = userRepos.findById(idUtilisateur);
	        if (user.isPresent()) {
	            userRepos.deleteById(idUtilisateur);
	            return user.get();
	        }
	        return null;
	    }

	    
	    
	    public List<User> searchUsers(String motCle) {
	        return userRepos.findByNomContainingOrPrenomContainingOrEmailContaining(motCle, motCle, motCle);
	    }

}
