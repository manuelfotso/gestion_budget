/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Finance_app.financeApp.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author USER
 */
@Entity
@Table(name = "budgetmensuel")
@NamedQueries({
    @NamedQuery(name = "Budgetmensuel.findAll", query = "SELECT b FROM Budgetmensuel b"),
    @NamedQuery(name = "Budgetmensuel.findByIdBudget", query = "SELECT b FROM Budgetmensuel b WHERE b.idBudget = :idBudget"),
    @NamedQuery(name = "Budgetmensuel.findByMontantMax", query = "SELECT b FROM Budgetmensuel b WHERE b.montantMax = :montantMax"),
    @NamedQuery(name = "Budgetmensuel.findByMois", query = "SELECT b FROM Budgetmensuel b WHERE b.mois = :mois"),
    @NamedQuery(name = "Budgetmensuel.findByAlerteEnvoyee", query = "SELECT b FROM Budgetmensuel b WHERE b.alerteEnvoyee = :alerteEnvoyee")})
public class Budgetmensuel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_budget")
    private Integer idBudget;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "montant_max")
    private BigDecimal montantMax;
    @Basic(optional = false)
    @Column(name = "mois")
    private String mois;
    @Column(name = "alerte_envoyee")
    private Boolean alerteEnvoyee;
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    @ManyToOne(optional = false)
    private User idUtilisateur;
    @JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie")
    @ManyToOne
    private Categorie idCategorie;

    public Budgetmensuel() {
    }

    public Budgetmensuel(Integer idBudget) {
        this.idBudget = idBudget;
    }

    public Budgetmensuel(Integer idBudget, BigDecimal montantMax, String mois) {
        this.idBudget = idBudget;
        this.montantMax = montantMax;
        this.mois = mois;
    }

    public Integer getIdBudget() {
        return idBudget;
    }

    public void setIdBudget(Integer idBudget) {
        this.idBudget = idBudget;
    }

    public BigDecimal getMontantMax() {
        return montantMax;
    }

    public void setMontantMax(BigDecimal montantMax) {
        this.montantMax = montantMax;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Boolean getAlerteEnvoyee() {
        return alerteEnvoyee;
    }

    public void setAlerteEnvoyee(Boolean alerteEnvoyee) {
        this.alerteEnvoyee = alerteEnvoyee;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBudget != null ? idBudget.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Budgetmensuel)) {
            return false;
        }
        Budgetmensuel other = (Budgetmensuel) object;
        if ((this.idBudget == null && other.idBudget != null) || (this.idBudget != null && !this.idBudget.equals(other.idBudget))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Finance_app.financeApp.entities.Budgetmensuel[ idBudget=" + idBudget + " ]";
    }
    
}
