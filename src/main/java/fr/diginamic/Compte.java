package fr.diginamic;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "COMPTE")
public class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NUMERO", unique = true, nullable = false)
    private String numero;
    @Column(name = "SOLDE")
    private double solde;
    @OneToMany(mappedBy = "compte", cascade = CascadeType.PERSIST)
    private Set<Operation> operations;
    @ManyToMany(mappedBy = "comptes")
    private Set<Client> clients;

    {
        operations = new HashSet<>();
        clients = new HashSet<>();
    }

    public Compte() {}

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public void ajouterClient(Client client) {
        if (client != null) {
            client.ajouterCompte(this);
        }
    }

    public void suprimerCompte(Client client) {
        if (client != null) {
            client.suprimerCompte(this);
        }
    }

    public void ajouterOperation(Operation operation) {
        operation.setCompte(this);
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
     * @return numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Setter
     *
     * @param numero numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Getter
     *
     * @return solde
     */
    public Double getSolde() {
        return solde;
    }

    /**
     * Setter
     *
     * @param solde solde
     */
    public void setSolde(Double solde) {
        this.solde = solde;
    }

    /**
     * Getter
     *
     * @return operations
     */
    public Set<Operation> getOperations() {
        return operations;
    }

    /**
     * Setter
     *
     * @param operations operations
     */
    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    /**
     * Getter
     *
     * @return clients
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * Setter
     *
     * @param clients clients
     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Compte{");
        sb.append("id=").append(id);
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", solde=").append(solde);
        sb.append('}');
        return sb.toString();
    }
}
