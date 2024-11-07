package fr.diginamic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "ASSURANCE_VIE")
public class AssuranceVie extends Compte{

    @Column(name = "DATE_FIN", nullable = false)
    private LocalDate dateFin;
    @Column(name = "NAME")
    private double taux;

    public AssuranceVie() {
    }

    public AssuranceVie(String numero, Double solde, LocalDate dateFin, double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    /**
     * Getter
     *
     * @return dateFin
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * Setter
     *
     * @param dateFin dateFin
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Getter
     *
     * @return taux
     */
    public double getTaux() {
        return taux;
    }

    /**
     * Setter
     *
     * @param taux taux
     */
    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AssuranceVie{");
        sb.append("dateFin=").append(dateFin);
        sb.append(", taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}
