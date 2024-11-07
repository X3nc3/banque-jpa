package fr.diginamic;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "LIVRET_A")
public class LivretA extends Compte{

    @Column(name = "TAUX")
    private double taux;

    public LivretA() {
    }

    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
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
        final StringBuilder sb = new StringBuilder("LivretA{");
        sb.append("taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}
