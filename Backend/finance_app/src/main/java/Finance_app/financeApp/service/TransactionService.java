package Finance_app.financeApp.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Finance_app.financeApp.entities.Categorie;
import Finance_app.financeApp.entities.Comptebancaire;
import Finance_app.financeApp.entities.Transaction;
import Finance_app.financeApp.entities.User;
import Finance_app.financeApp.repos.TransactionRepos;

@Service
public class TransactionService {

	

    @Autowired
    private TransactionRepos transactionRepos;

    // Sauvegarder ou mettre à jour une transaction
    public Transaction saveOrUpdate(Transaction transaction) {
        if (transaction.getMontant() != null && transaction.getDateTransaction() != null) {
            return transactionRepos.save(transaction);
        }
        return null;
    }

    // Récupérer toutes les transactions
    public List<Transaction> getAll() {
        return transactionRepos.findAll();
    }

    // Récupérer une transaction par son ID
    public Transaction findByIdTransaction(Integer idTransaction) {
        Optional<Transaction> transaction = transactionRepos.findById(idTransaction);
        return transaction.orElse(null);
    }

    // Récupérer les transactions par montant
    public List<Transaction> findByMontant(BigDecimal montant) {
        return transactionRepos.findByMontant(montant);
    }

    // Récupérer les transactions par date
    public List<Transaction> findByDateTransaction(Date dateTransaction) {
        return transactionRepos.findByDateTransaction(dateTransaction);
    }

    // Récupérer les transactions par description
    public List<Transaction> findByDescription(String description) {
        return transactionRepos.findByDescription(description);
    }

    // Supprimer une transaction par son ID
    public Transaction delete(Integer idTransaction) {
        Optional<Transaction> transaction = transactionRepos.findById(idTransaction);
        if (transaction.isPresent()) {
            transactionRepos.deleteById(idTransaction);
            return transaction.get();
        }
        return null;
    }

    // Rechercher des transactions par mot-clé (description)
    public List<Transaction> searchTransactions(String motCle) {
        return transactionRepos.findByDescriptionContaining(motCle);
    }

    // Récupérer les transactions par utilisateur
    public List<Transaction> findByUser(User user) {
        return transactionRepos.findByIdUtilisateur(user);
    }

    // Récupérer les transactions par catégorie
    public List<Transaction> findByCategorie(Categorie categorie) {
        return transactionRepos.findByIdCategorie(categorie);
    }

    // Récupérer les transactions par compte bancaire
    public List<Transaction> findByCompteBancaire(Comptebancaire compte) {
        return transactionRepos.findByIdCompte(compte);
    }
}
