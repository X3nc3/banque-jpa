package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Adresse adresse1 = new Adresse(32, "le val profond", 91570, "Biévres");

        Banque banque1 = new Banque("BNP");

        Client client1 = new Client("OGIER", "Maxence", LocalDate.now(), banque1, adresse1);
        Client client2 = new Client("OGIER", "Adeline", LocalDate.now(), banque1, adresse1);

        Compte compteJoint = new LivretA("123", 1000, 3.5);
        Compte assuranceVie = new AssuranceVie("321", 10000.00, LocalDate.now(), 1.5 );

        Operation debit = new Virement(LocalDateTime.now(), 10.00, "cadeau", compteJoint, "toto");
        Operation credit = new Virement(LocalDateTime.now(), 5.00, "remboursement", compteJoint, "toto");

        compteJoint.ajouterClient(client1);
        compteJoint.ajouterClient((client2));

        client1.ajouterCompte(compteJoint);
        client1.ajouterCompte(assuranceVie);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp-banque");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(banque1);
        em.persist(compteJoint);
        em.persist(assuranceVie);
        em.persist(debit);
        em.persist(credit);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}