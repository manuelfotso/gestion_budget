package Finance_app.financeApp.controllers;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Finance_app.financeApp.service.UserService;
import Finance_app.financeApp.entities.User;
@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    // Créer un nouvel utilisateur
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveOrUpdate(user);
        if (savedUser != null) {
            return ResponseEntity.ok(savedUser);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Récupérer tous les utilisateurs
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    // Récupérer un utilisateur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.findByIdUtilisateur(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Mettre à jour un utilisateur
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        User existingUser = userService.findByIdUtilisateur(id);
        if (existingUser != null) {
            user.setIdUtilisateur(id); // Assurez-vous que l'ID est correctement défini
            User updatedUser = userService.saveOrUpdate(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un utilisateur par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        User deletedUser = userService.delete(id);
        if (deletedUser != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Rechercher des utilisateurs par mot-clé (nom, prénom ou email)
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam String keyword) {
        List<User> users = userService.searchUsers(keyword);
        return ResponseEntity.ok(users);
    }

    // Récupérer un utilisateur par son nom
    @GetMapping("/by-nom")
    public ResponseEntity<User> getUserByNom(@RequestParam String nom) {
        User user = userService.findByNom(nom);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Récupérer un utilisateur par son prénom
    @GetMapping("/by-prenom")
    public ResponseEntity<User> getUserByPrenom(@RequestParam String prenom) {
        User user = userService.findByPrenom(prenom);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Récupérer un utilisateur par son email
    @GetMapping("/by-email")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Récupérer un utilisateur par son login
    @GetMapping("/by-login")
    public ResponseEntity<User> getUserByLogin(@RequestParam String login) {
        User user = userService.findByLoginuser(login);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Récupérer des utilisateurs par date de création
    @GetMapping("/by-date-creation")
    public ResponseEntity<List<User>> getUsersByDateCreation(@RequestParam Date dateCreation) {
        List<User> users = userService.findByDateCreation(dateCreation);
        return ResponseEntity.ok(users);
    }
}
