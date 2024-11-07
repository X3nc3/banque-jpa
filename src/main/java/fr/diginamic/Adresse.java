package fr.diginamic;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class Adresse implements Serializable {

    private int numero;
    private String rue;
    private int codePostal;
    private  String ville;

    public Adresse() {
    }

    public Adresse(int numero, String rue, int codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    /**
     * Getter
     *
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Setter
     *
     * @param numero numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Getter
     *
     * @return rue
     */
    public String getRue() {
        return rue;
    }

    /**
     * Setter
     *
     * @param rue rue
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     * Getter
     *
     * @return codePostal
     */
    public int getCodePostal() {
        return codePostal;
    }

    /**
     * Setter
     *
     * @param codePostal codePostal
     */
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * Getter
     *
     * @return ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * Setter
     *
     * @param ville ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adresse{");
        sb.append("numero=").append(numero);
        sb.append(", rue='").append(rue).append('\'');
        sb.append(", codePostal=").append(codePostal);
        sb.append(", ville='").append(ville).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
