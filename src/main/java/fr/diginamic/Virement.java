package fr.diginamic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "VIREMENT")
public class Virement extends Operation{

    @Column(name = "BENEFICIAURE", nullable = false)
    private String beneficiaire;

    public Virement() {
    }

    public Virement(LocalDateTime date, Double montant, String motif, Compte compte, String beneficiaire) {
        super(date, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    /**
     * Getter
     *
     * @return beneficiaire
     */
    public String getBeneficiaire() {
        return beneficiaire;
    }

    /**
     * Setter
     *
     * @param beneficiaire beneficiaire
     */
    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Virement{");
        sb.append("beneficiaire='").append(beneficiaire).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
