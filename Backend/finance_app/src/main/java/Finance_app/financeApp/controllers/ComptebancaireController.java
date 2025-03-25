package Finance_app.financeApp.controllers;


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

import Finance_app.financeApp.entities.Comptebancaire;
import Finance_app.financeApp.entities.User;
import Finance_app.financeApp.service.ComptebancaireService;
import Finance_app.financeApp.service.UserService;

@RestController
@RequestMapping("/api/comptes")
public class ComptebancaireController {

    @Autowired
    private ComptebancaireService comptebancaireService;

    @Autowired
    private UserService userService; // Injection de UserService

    // Créer un nouveau compte bancaire
    @PostMapping
    public ResponseEntity<Comptebancaire> createCompte(@RequestBody Comptebancaire compte) {
        Comptebancaire savedCompte = comptebancaireService.saveOrUpdate(compte);
        if (savedCompte != null) {
            return ResponseEntity.ok(savedCompte);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Récupérer tous les comptes bancaires
    @GetMapping
    public ResponseEntity<List<Comptebancaire>> getAllComptes() {
        List<Comptebancaire> comptes = comptebancaireService.getAll();
        return ResponseEntity.ok(comptes);
    }

    // Récupérer un compte bancaire par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Comptebancaire> getCompteById(@PathVariable Integer id) {
        Comptebancaire compte = comptebancaireService.findByIdCompte(id);
        if (compte != null) {
            return ResponseEntity.ok(compte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Mettre à jour un compte bancaire
    @PutMapping("/{id}")
    public ResponseEntity<Comptebancaire> updateCompte(@PathVariable Integer id, @RequestBody Comptebancaire compte) {
        Comptebancaire existingCompte = comptebancaireService.findByIdCompte(id);
        if (existingCompte != null) {
            compte.setIdCompte(id); // Assurez-vous que l'ID est correctement défini
            Comptebancaire updatedCompte = comptebancaireService.saveOrUpdate(compte);
            return ResponseEntity.ok(updatedCompte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un compte bancaire par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompte(@PathVariable Integer id) {
        Comptebancaire deletedCompte = comptebancaireService.delete(id);
        if (deletedCompte != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Rechercher des comptes bancaires par mot-clé (nom de la banque ou numéro de compte)
    @GetMapping("/search")
    public ResponseEntity<List<Comptebancaire>> searchComptes(@RequestParam String keyword) {
        List<Comptebancaire> comptes = comptebancaireService.searchComptes(keyword);
        return ResponseEntity.ok(comptes);
    }

    // Récupérer des comptes bancaires par nom de la banque
    @GetMapping("/by-banque")
    public ResponseEntity<List<Comptebancaire>> getComptesByNomBanque(@RequestParam String nomBanque) {
        List<Comptebancaire> comptes = comptebancaireService.findByNomBanque(nomBanque);
        return ResponseEntity.ok(comptes);
    }

    

   

    // Récupérer les comptes bancaires d'un utilisateur
    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Comptebancaire>> getComptesByUser(@PathVariable Integer userId) {
        User user = userService.findByIdUtilisateur(userId); // Utilisation de userService
        if (user != null) {
            List<Comptebancaire> comptes = comptebancaireService.findByUser(user);
            return ResponseEntity.ok(comptes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
