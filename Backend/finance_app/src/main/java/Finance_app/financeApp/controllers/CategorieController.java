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

import Finance_app.financeApp.entities.Categorie;
import Finance_app.financeApp.service.CategorieService;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

	@Autowired
    private CategorieService categorieService;

    // Créer une nouvelle catégorie
    @PostMapping
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
        Categorie savedCategorie = categorieService.saveOrUpdate(categorie);
        if (savedCategorie != null) {
            return ResponseEntity.ok(savedCategorie);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Récupérer toutes les catégories
    @GetMapping
    public ResponseEntity<List<Categorie>> getAllCategories() {
        List<Categorie> categories = categorieService.getAll();
        return ResponseEntity.ok(categories);
    }

    // Récupérer une catégorie par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable Integer id) {
        Categorie categorie = categorieService.findByIdCategorie(id);
        if (categorie != null) {
            return ResponseEntity.ok(categorie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Mettre à jour une catégorie
    @PutMapping("/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable Integer id, @RequestBody Categorie categorie) {
        Categorie existingCategorie = categorieService.findByIdCategorie(id);
        if (existingCategorie != null) {
            categorie.setIdCategorie(id); // Assurez-vous que l'ID est correctement défini
            Categorie updatedCategorie = categorieService.saveOrUpdate(categorie);
            return ResponseEntity.ok(updatedCategorie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer une catégorie par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable Integer id) {
        Categorie deletedCategorie = categorieService.delete(id);
        if (deletedCategorie != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Rechercher des catégories par mot-clé (nom ou type)
    @GetMapping("/search")
    public ResponseEntity<List<Categorie>> searchCategories(@RequestParam String keyword) {
        List<Categorie> categories = categorieService.searchCategories(keyword);
        return ResponseEntity.ok(categories);
    }

    // Récupérer des catégories par type
    @GetMapping("/by-type")
    public ResponseEntity<List<Categorie>> getCategoriesByType(@RequestParam String type) {
        List<Categorie> categories = categorieService.findByType(type);
        return ResponseEntity.ok(categories);
    }

    // Récupérer une catégorie par son nom
    @GetMapping("/by-nom")
    public ResponseEntity<Categorie> getCategorieByNom(@RequestParam String nomCategorie) {
        Categorie categorie = categorieService.findByNomCategorie(nomCategorie);
        if (categorie != null) {
            return ResponseEntity.ok(categorie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
