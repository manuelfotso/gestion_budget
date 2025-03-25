/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Finance_app.financeApp.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "transaction")
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t"),
    @NamedQuery(name = "Transaction.findByIdTransaction", query = "SELECT t FROM Transaction t WHERE t.idTransaction = :idTransaction"),
    @NamedQuery(name = "Transaction.findByMontant", query = "SELECT t FROM Transaction t WHERE t.montant = :montant"),
    @NamedQuery(name = "Transaction.findByDateTransaction", query = "SELECT t FROM Transaction t WHERE t.dateTransaction = :dateTransaction"),
    @NamedQuery(name = "Transaction.findByDescription", query = "SELECT t FROM Transaction t WHERE t.description = :description")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transaction")
    private Integer idTransaction;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "montant")
    private BigDecimal montant;
    @Column(name = "date_transaction")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTransaction;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    @ManyToOne(optional = false)
    private User idUtilisateur;
    @JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie")
    @ManyToOne
    private Categorie idCategorie;
    @JoinColumn(name = "id_compte", referencedColumnName = "id_compte")
    @ManyToOne
    private Comptebancaire idCompte;

    public Transaction() {
    }

    public Transaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Transaction(Integer idTransaction, BigDecimal montant) {
        this.idTransaction = idTransaction;
        this.montant = montant;
    }

    public Integer getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(User idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Categorie getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Categorie idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Comptebancaire getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Comptebancaire idCompte) {
        this.idCompte = idCompte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaction != null ? idTransaction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.idTransaction == null && other.idTransaction != null) || (this.idTransaction != null && !this.idTransaction.equals(other.idTransaction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Finance_app.financeApp.entities.Transaction[ idTransaction=" + idTransaction + " ]";
    }
    
}
