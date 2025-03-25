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
@Table(name = "rapport")
@NamedQueries({
    @NamedQuery(name = "Rapport.findAll", query = "SELECT r FROM Rapport r"),
    @NamedQuery(name = "Rapport.findByIdRapport", query = "SELECT r FROM Rapport r WHERE r.idRapport = :idRapport"),
    @NamedQuery(name = "Rapport.findByPeriode", query = "SELECT r FROM Rapport r WHERE r.periode = :periode"),
    @NamedQuery(name = "Rapport.findByTotalDepenses", query = "SELECT r FROM Rapport r WHERE r.totalDepenses = :totalDepenses"),
    @NamedQuery(name = "Rapport.findByTotalRevenus", query = "SELECT r FROM Rapport r WHERE r.totalRevenus = :totalRevenus")})
public class Rapport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rapport")
    private Short idRapport;
    @Basic(optional = false)
    @Column(name = "periode")
    private String periode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "total_depenses")
    private BigDecimal totalDepenses;
    @Basic(optional = false)
    @Column(name = "total_revenus")
    private BigDecimal totalRevenus;
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    @ManyToOne(optional = false)
    private User idUtilisateur;

    public Rapport() {
    }

    public Rapport(Short idRapport) {
        this.idRapport = idRapport;
    }

    public Rapport(Short idRapport, String periode, BigDecimal totalDepenses, BigDecimal totalRevenus) {
        this.idRapport = idRapport;
        this.periode = periode;
        this.totalDepenses = totalDepenses;
        this.totalRevenus = totalRevenus;
    }

    public Short getIdRapport() {
        return idRapport;
    }

    public void setIdRapport(Short idRapport) {
        this.idRapport = idRapport;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public BigDecimal getTotalDepenses() {
        return totalDepenses;
    }

    public void setTotalDepenses(BigDecimal totalDepenses) {
        this.totalDepenses = totalDepenses;
    }

    public BigDecimal getTotalRevenus() {
        return totalRevenus;
    }

    public void setTotalRevenus(BigDecimal totalRevenus) {
        this.totalRevenus = totalRevenus;
    }

    public User getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(User idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRapport != null ? idRapport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rapport)) {
            return false;
        }
        Rapport other = (Rapport) object;
        if ((this.idRapport == null && other.idRapport != null) || (this.idRapport != null && !this.idRapport.equals(other.idRapport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Finance_app.financeApp.entities.Rapport[ idRapport=" + idRapport + " ]";
    }
    
}
