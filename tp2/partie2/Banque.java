package tp2.partie2;

import tp2.partie1.CompteBancaire; // Import de la classe de la partie 1

public class Banque {
    // 1. Attributs
    private String nom;
    private CompteBancaire[] comptes; // Tableau d'objets CompteBancaire
    private int nbActuels; // Nombre de comptes actuellement dans la banque

    // 2. Constructeur paramétré
    public Banque(String nom, int capaciteMaximale) {
        this.nom = nom;
        this.comptes = new CompteBancaire[capaciteMaximale];
        this.nbActuels = 0;
    }

    // 3. Implémentation des méthodes
    public void ajouterCompte(CompteBancaire c) {
        // Vérifie s'il reste de la place dans le tableau
        if (nbActuels < comptes.length) {
            comptes[nbActuels] = c;
            nbActuels++;
            // System.out.println("Compte de " + c.getTitulaire() + " ajouté à la banque " + nom);
        } else {
            System.out.println("Impossible d'ajouter le compte : la banque est pleine.");
        }
    }

    public void afficherTous() {
        System.out.println("\n=== Liste des comptes de la banque : " + nom + " ===");
        if (nbActuels == 0) {
            System.out.println("Aucun compte n'a encore été ajouté.");
        } else {
            for (int i = 0; i < nbActuels; i++) {
                comptes[i].afficher();
            }
        }
        System.out.println("==================================================");
    }
    
    // Getters optionnels mais recommandés
    public String getNom() {
        return nom;
    }

    public int getNbActuels() {
        return nbActuels;
    }
}
