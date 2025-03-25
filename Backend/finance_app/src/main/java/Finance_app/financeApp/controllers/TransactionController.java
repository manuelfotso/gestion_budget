package Finance_app.financeApp.controllers;


import java.util.Date;
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
import Finance_app.financeApp.entities.Comptebancaire;
import Finance_app.financeApp.entities.Transaction;
import Finance_app.financeApp.entities.User;
import Finance_app.financeApp.service.TransactionService;
import Finance_app.financeApp.service.UserService;
import Finance_app.financeApp.service.CategorieService;
import Finance_app.financeApp.service.ComptebancaireService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	
	 @Autowired
	    private TransactionService transactionService;

	 @Autowired
	    private UserService userService; // Injection de UserService

	    @Autowired
	    private CategorieService categorieService; // Injection de CategorieService

	    @Autowired
	    private ComptebancaireService compteService; // Injection de CompteServic
	    // Créer une nouvelle transaction
	    @PostMapping
	    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
	        Transaction savedTransaction = transactionService.saveOrUpdate(transaction);
	        if (savedTransaction != null) {
	            return ResponseEntity.ok(savedTransaction);
	        } else {
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    // Récupérer toutes les transactions
	    @GetMapping
	    public ResponseEntity<List<Transaction>> getAllTransactions() {
	        List<Transaction> transactions = transactionService.getAll();
	        return ResponseEntity.ok(transactions);
	    }

	    // Récupérer une transaction par son ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Transaction> getTransactionById(@PathVariable Integer id) {
	        Transaction transaction = transactionService.findByIdTransaction(id);
	        if (transaction != null) {
	            return ResponseEntity.ok(transaction);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Mettre à jour une transaction
	    @PutMapping("/{id}")
	    public ResponseEntity<Transaction> updateTransaction(@PathVariable Integer id, @RequestBody Transaction transaction) {
	        Transaction existingTransaction = transactionService.findByIdTransaction(id);
	        if (existingTransaction != null) {
	            transaction.setIdTransaction(id); // Assurez-vous que l'ID est correctement défini
	            Transaction updatedTransaction = transactionService.saveOrUpdate(transaction);
	            return ResponseEntity.ok(updatedTransaction);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Supprimer une transaction par son ID
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer id) {
	        Transaction deletedTransaction = transactionService.delete(id);
	        if (deletedTransaction != null) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Rechercher des transactions par mot-clé (description)
	    @GetMapping("/search")
	    public ResponseEntity<List<Transaction>> searchTransactions(@RequestParam String keyword) {
	        List<Transaction> transactions = transactionService.searchTransactions(keyword);
	        return ResponseEntity.ok(transactions);
	    }

	   
	    // Récupérer les transactions par date
	    @GetMapping("/by-date")
	    public ResponseEntity<List<Transaction>> getTransactionsByDate(@RequestParam Date date) {
	        List<Transaction> transactions = transactionService.findByDateTransaction(date);
	        return ResponseEntity.ok(transactions);
	    }

	    // Récupérer les transactions par utilisateur
	    @GetMapping("/by-user/{userId}")
	    public ResponseEntity<List<Transaction>> getTransactionsByUser(@PathVariable Integer userId) {
	        // Supposons que vous avez un service pour récupérer un User par son ID
	        User user = userService.findByIdUtilisateur(userId);
	        if (user != null) {
	            List<Transaction> transactions = transactionService.findByUser(user);
	            return ResponseEntity.ok(transactions);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Récupérer les transactions par catégorie
	    @GetMapping("/by-categorie/{categorieId}")
	    public ResponseEntity<List<Transaction>> getTransactionsByCategorie(@PathVariable Integer categorieId) {
	        // Supposons que vous avez un service pour récupérer une Categorie par son ID
	        Categorie categorie = categorieService.findByIdCategorie(categorieId);
	        if (categorie != null) {
	            List<Transaction> transactions = transactionService.findByCategorie(categorie);
	            return ResponseEntity.ok(transactions);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Récupérer les transactions par compte bancaire
	    @GetMapping("/by-compte/{compteId}")
	    public ResponseEntity<List<Transaction>> getTransactionsByCompte(@PathVariable Integer compteId) {
	        // Supposons que vous avez un service pour récupérer un Comptebancaire par son ID
	        Comptebancaire compte = compteService.findByIdCompte(compteId);
	        if (compte != null) {
	            List<Transaction> transactions = transactionService.findByCompteBancaire(compte);
	            return ResponseEntity.ok(transactions);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
