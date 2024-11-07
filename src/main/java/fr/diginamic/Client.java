package fr.diginamic;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "DATE_NAISSANCE")
    private LocalDate dateNaissance;
    @ManyToOne
    @JoinColumn(name = "ID_BANQUE")
    private Banque banque;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "compo", joinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"))
    private Set<Compte> comptes;
    @Embedded
    private Adresse adresse;

    {
        comptes = new HashSet<>();
    }

    public Client() {}

    public Client(String nom, String prenom, LocalDate dateNaissance, Banque banque, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        setBanque(banque);
        this.adresse = adresse;
    }

    public void ajouterCompte (Compte compte){
        if (compte != null) {
            this.comptes.add(compte);
            compte.getClients().add(this);
        }
    }

    public void suprimerCompte (Compte compte){
        if (compte != null) {
            this.comptes.remove(compte);
            compte.getClients().remove(this);
        }
    }

    /**
     * Getter
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter
     *
     * @param nom nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter
     *
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter
     *
     * @param prenom prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getter
     *
     * @return dateNaissance
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Setter
     *
     * @param dateNaissance dateNaissance
     */
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Getter
     *
     * @return banque
     */
    public Banque getBanque() {
        return banque;
    }

    /**
     * Setter
     *
     * @param banque banque
     */
    public void setBanque(Banque banque) {
        if (this.banque != null) {
            this.banque.getClients().remove(this);
        }

        this.banque = banque;

        if (this.banque != null) {
            this.banque.getClients().add(this);
        }
    }

    /**
     * Getter
     *
     * @return comptes
     */
    public Set<Compte> getComptes() {
        return comptes;
    }

    /**
     * Setter
     *
     * @param comptes comptes
     */
    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    /**
     * Getter
     *
     * @return adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Setter
     *
     * @param adresse adresse
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append(", banque=").append(banque);
        sb.append(", adresse=").append(adresse);
        sb.append('}');
        return sb.toString();
    }
}
