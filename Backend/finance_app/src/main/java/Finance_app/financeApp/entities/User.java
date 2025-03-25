/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Finance_app.financeApp.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByIdUtilisateur", query = "SELECT u FROM User u WHERE u.idUtilisateur = :idUtilisateur"),
    @NamedQuery(name = "User.findByNom", query = "SELECT u FROM User u WHERE u.nom = :nom"),
    @NamedQuery(name = "User.findByPrenom", query = "SELECT u FROM User u WHERE u.prenom = :prenom"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByMotDePasse", query = "SELECT u FROM User u WHERE u.motDePasse = :motDePasse"),
    @NamedQuery(name = "User.findBySexe", query = "SELECT u FROM User u WHERE u.sexe = :sexe"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findByLoginuser", query = "SELECT u FROM User u WHERE u.loginuser = :loginuser"),
    @NamedQuery(name = "User.findByDateCreation", query = "SELECT u FROM User u WHERE u.dateCreation = :dateCreation")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_utilisateur")
    private Integer idUtilisateur;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "mot_de_passe")
    private String motDePasse;
    @Basic(optional = false)
    @Column(name = "sexe")
    private String sexe;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "loginuser")
    private String loginuser;
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateur")
    private Collection<Budgetmensuel> budgetmensuelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateur")
    private Collection<Categorie> categorieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateur")
    private Collection<Rapport> rapportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateur")
    private Collection<Comptebancaire> comptebancaireCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateur")
    private Collection<Transaction> transactionCollection;

    public User() {
    }

    public User(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public User(Integer idUtilisateur, String nom, String email, String motDePasse, String sexe, String phone, String loginuser) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.sexe = sexe;
        this.phone = phone;
        this.loginuser = loginuser;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoginuser() {
        return loginuser;
    }

    public void setLoginuser(String loginuser) {
        this.loginuser = loginuser;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Collection<Budgetmensuel> getBudgetmensuelCollection() {
        return budgetmensuelCollection;
    }

    public void setBudgetmensuelCollection(Collection<Budgetmensuel> budgetmensuelCollection) {
        this.budgetmensuelCollection = budgetmensuelCollection;
    }

    public Collection<Categorie> getCategorieCollection() {
        return categorieCollection;
    }

    public void setCategorieCollection(Collection<Categorie> categorieCollection) {
        this.categorieCollection = categorieCollection;
    }

    public Collection<Rapport> getRapportCollection() {
        return rapportCollection;
    }

    public void setRapportCollection(Collection<Rapport> rapportCollection) {
        this.rapportCollection = rapportCollection;
    }

    public Collection<Comptebancaire> getComptebancaireCollection() {
        return comptebancaireCollection;
    }

    public void setComptebancaireCollection(Collection<Comptebancaire> comptebancaireCollection) {
        this.comptebancaireCollection = comptebancaireCollection;
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
        hash += (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUtilisateur == null && other.idUtilisateur != null) || (this.idUtilisateur != null && !this.idUtilisateur.equals(other.idUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Finance_app.financeApp.entities.User[ idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
