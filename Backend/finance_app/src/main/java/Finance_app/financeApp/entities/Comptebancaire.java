/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Finance_app.financeApp.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "comptebancaire")
@NamedQueries({
    @NamedQuery(name = "Comptebancaire.findAll", query = "SELECT c FROM Comptebancaire c"),
    @NamedQuery(name = "Comptebancaire.findByIdCompte", query = "SELECT c FROM Comptebancaire c WHERE c.idCompte = :idCompte"),
    @NamedQuery(name = "Comptebancaire.findByNomBanque", query = "SELECT c FROM Comptebancaire c WHERE c.nomBanque = :nomBanque"),
    @NamedQuery(name = "Comptebancaire.findByNumeroCompte", query = "SELECT c FROM Comptebancaire c WHERE c.numeroCompte = :numeroCompte"),
    @NamedQuery(name = "Comptebancaire.findBySoldeInitial", query = "SELECT c FROM Comptebancaire c WHERE c.soldeInitial = :soldeInitial"),
    @NamedQuery(name = "Comptebancaire.findByDevise", query = "SELECT c FROM Comptebancaire c WHERE c.devise = :devise"),
    @NamedQuery(name = "Comptebancaire.findByDateCreation", query = "SELECT c FROM Comptebancaire c WHERE c.dateCreation = :dateCreation")})
public class Comptebancaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_compte")
    private Integer idCompte;
    @Basic(optional = false)
    @Column(name = "nom_banque")
    private String nomBanque;
    @Basic(optional = false)
    @Column(name = "numero_compte")
    private String numeroCompte;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "solde_initial")
    private BigDecimal soldeInitial;
    @Basic(optional = false)
    @Column(name = "devise")
    private String devise;
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    @ManyToOne(optional = false)
    private User idUtilisateur;
    @OneToMany(mappedBy = "idCompte")
    private Collection<Transaction> transactionCollection;

    public Comptebancaire() {
    }

    public Comptebancaire(Integer idCompte) {
        this.idCompte = idCompte;
    }

    public Comptebancaire(Integer idCompte, String nomBanque, String numeroCompte, BigDecimal soldeInitial, String devise) {
        this.idCompte = idCompte;
        this.nomBanque = nomBanque;
        this.numeroCompte = numeroCompte;
        this.soldeInitial = soldeInitial;
        this.devise = devise;
    }

    public Integer getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Integer idCompte) {
        this.idCompte = idCompte;
    }

    public String getNomBanque() {
        return nomBanque;
    }

    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public BigDecimal getSoldeInitial() {
        return soldeInitial;
    }

    public void setSoldeInitial(BigDecimal soldeInitial) {
        this.soldeInitial = soldeInitial;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public User getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(User idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Collection<Transaction> getTransactionCollection() {
        return transactionCollection;
    }

    public void setTransactionCollection(Collection<Transaction> transactionCollection) {
        this.transactionCollection = transactionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompte != null ? idCompte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comptebancaire)) {
            return false;
        }
        Comptebancaire other = (Comptebancaire) object;
        if ((this.idCompte == null && other.idCompte != null) || (this.idCompte != null && !this.idCompte.equals(other.idCompte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Finance_app.financeApp.entities.Comptebancaire[ idCompte=" + idCompte + " ]";
    }
    
}
