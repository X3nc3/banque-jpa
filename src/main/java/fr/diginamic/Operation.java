package fr.diginamic;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "OPERATION")
public class Operation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATE")
    private LocalDateTime date;
    @Column(name = "MONTANT")
    private Double montant;
    @Column(name = "MOTIF")
    private String motif;
    @ManyToOne
    @JoinColumn(name = "ID_COMPTE")
    private Compte compte;

    public Operation() {}

    public Operation(LocalDateTime date, Double montant, String motif, Compte compte) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        setCompte(compte);
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
     * @return date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Setter
     *
     * @param date date
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Getter
     *
     * @return montant
     */
    public Double getMontant() {
        return montant;
    }

    /**
     * Setter
     *
     * @param montant montant
     */
    public void setMontant(Double montant) {
        this.montant = montant;
    }

    /**
     * Getter
     *
     * @return motif
     */
    public String getMotif() {
        return motif;
    }

    /**
     * Setter
     *
     * @param motif motif
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }

    /**
     * Getter
     *
     * @return compte
     */
    public Compte getCompte() {
        return compte;
    }

    /**
     * Setter
     *
     * @param compte compte
     */
    public void setCompte(Compte compte) {
        if (this.compte != null) {
            this.compte.getOperations().remove(this);
        }

        this.compte = compte;

        if (this.compte != null) {
            this.compte.getOperations().add(this);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Operation{");
        sb.append("id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", montant=").append(montant);
        sb.append(", motif='").append(motif).append('\'');
        sb.append(", compte=").append(compte);
        sb.append('}');
        return sb.toString();
    }
}
