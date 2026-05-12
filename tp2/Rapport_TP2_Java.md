# Rapport de Travaux Pratiques : TP 2 - Classes et Objets (Java)

**Nom et Prénom :** ahmed hsissou  
**Lien GitHub :** https://github.com/Hsissouahmed04


---

## Partie 1 : Classe `CompteBancaire`

### Code Source : `CompteBancaire.java`
```java
package tp2.partie1;

public class CompteBancaire {
    private static int nbComptes = 0;
    private static double tauxInteretAnnuel = 0.03; // 3%

    private int numero;
    private String titulaire;
    private double solde;
    private double decouvertAutorise;

    public CompteBancaire() {
        nbComptes++;
        this.numero = nbComptes;
        this.titulaire = "Anonyme";
        this.solde = 0.0;
        this.decouvertAutorise = 0.0;
    }

    public CompteBancaire(String titulaire, double soldeInitial, double decouvertAutorise) {
        nbComptes++;
        this.numero = nbComptes;
        this.setTitulaire(titulaire);
        this.solde = soldeInitial;
        this.setDecouvertAutorise(decouvertAutorise);
    }

    // Getters et Setters
    public int getNumero() { return numero; }
    public String getTitulaire() { return titulaire; }
    public void setTitulaire(String titulaire) {
        if (titulaire != null && !titulaire.trim().isEmpty()) {
            this.titulaire = titulaire;
        } else {
            System.out.println("Erreur : le titulaire ne peut pas être vide.");
            this.titulaire = "Inconnu";
        }
    }

    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
    public double getDecouvertAutorise() { return decouvertAutorise; }
    public void setDecouvertAutorise(double decouvertAutorise) {
        if (decouvertAutorise >= 0) {
            this.decouvertAutorise = decouvertAutorise;
        } else {
            System.out.println("Erreur : le découvert ne peut pas être négatif.");
            this.decouvertAutorise = 0;
        }
    }

    public void afficher() {
        System.out.println("-----------------------------------");
        System.out.println("Compte N° " + numero);
        System.out.println("Titulaire : " + titulaire);
        System.out.println("Solde : " + solde + " MAD");
        System.out.println("Découvert autorisé : " + decouvertAutorise + " MAD");
        System.out.println("-----------------------------------");
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
        } else {
            System.out.println("Montant de dépôt invalide.");
        }
    }

    public void retirer(double montant) {
        if (montant > 0 && (solde - montant >= -decouvertAutorise)) {
            solde -= montant;
        } else {
            System.out.println("Retrait refusé.");
        }
    }

    public void virementVers(CompteBancaire autre, double montant) {
        if (montant > 0 && (this.solde - montant >= -this.decouvertAutorise)) {
            this.solde -= montant;
            autre.solde += montant;
            System.out.println("Virement effectué avec succès vers le compte de " + autre.getTitulaire());
        } else {
            System.out.println("Virement impossible : montant ou solde insuffisant.");
        }
    }

    public double calculerSoldeAvecInterets() {
        return this.solde + (this.solde * tauxInteretAnnuel);
    }

    public double calculerSoldeAvecInterets(double bonus) {
        return this.solde + (this.solde * (tauxInteretAnnuel + bonus));
    }

    public static int getNbComptes() { return nbComptes; }
    public static double getTauxInteretAnnuel() { return tauxInteretAnnuel; }
    public static void setTauxInteretAnnuel(double taux) {
        if (taux >= 0) tauxInteretAnnuel = taux;
    }
}
```

### Exécution (Partie 1)

```text
--- Test de la création des comptes ---
-----------------------------------
Compte N° 1
Titulaire : Anonyme
Solde : 0.0 MAD
Découvert autorisé : 0.0 MAD
-----------------------------------
-----------------------------------
Compte N° 2
Titulaire : Alice
Solde : 1000.0 MAD
Découvert autorisé : 500.0 MAD
-----------------------------------

--- Test des retraits selon l'exemple du TP ---
Cas 1 : Retrait de 1200 MAD
-----------------------------------
Compte N° 2
Titulaire : Alice
Solde : -200.0 MAD
Découvert autorisé : 500.0 MAD
-----------------------------------

Cas 2 : Retrait de 1600 MAD (en partant du solde initial de 1000 MAD)
Retrait refusé.

--- Test du nombre total de comptes ---
Nombre total de comptes créés : 2
```

---

## Partie 2 : Classe `Banque`

### Code Source : `Banque.java`
```java
package tp2.partie2;

import tp2.partie1.CompteBancaire;

public class Banque {
    private String nom;
    private CompteBancaire[] comptes;
    private int nbActuels;

    public Banque(String nom, int capaciteMaximale) {
        this.nom = nom;
        this.comptes = new CompteBancaire[capaciteMaximale];
        this.nbActuels = 0;
    }

    public void ajouterCompte(CompteBancaire c) {
        if (nbActuels < comptes.length) {
            comptes[nbActuels] = c;
            nbActuels++;
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
    
    public String getNom() { return nom; }
    public int getNbActuels() { return nbActuels; }
}
```

---

## Partie 3 : Classe de test finale `TestBanque`


### Code Source : `TestBanque.java`
```java
package tp2.partie3;

import tp2.partie1.CompteBancaire;
import tp2.partie2.Banque;

public class TestBanque {
    public static void main(String[] args) {
        System.out.println("--- 1. Création de la banque ---");
        Banque banque = new Banque("MarocBank", 1500);

        System.out.println("\n--- 2. Création des trois comptes ---");
        CompteBancaire c1 = new CompteBancaire("Alice", 2000, 500);
        CompteBancaire c2 = new CompteBancaire("Bob", 3000, 1000);
        CompteBancaire c3 = new CompteBancaire("Charlie", 1500, 200);

        System.out.println("\n--- 3. Ajout des comptes à la banque ---");
        banque.ajouterCompte(c1);
        banque.ajouterCompte(c2);
        banque.ajouterCompte(c3);

        System.out.println("\n--- 4. Opérations (Dépôt/Retrait sur c1, Virement c2 -> c3) ---");
        c1.deposer(500); // 2000 + 500 = 2500
        System.out.println("Retrait de 2800 MAD sur c1 :");
        c1.retirer(2800); // Passe à -300
        
        System.out.println("Virement de 1000 MAD de c2 vers c3 :");
        c2.virementVers(c3, 1000); // Bob perd 1000, Charlie gagne 1000

        // 5. Affichez tous les comptes.
        banque.afficherTous();

        System.out.println("--- 6. Calcul des intérêts pour le compte c2 ---");
        double soldeInteretBase = c2.calculerSoldeAvecInterets();
        double soldeInteretBonus = c2.calculerSoldeAvecInterets(0.015);
        
        System.out.println("Solde actuel de c2 (Bob) : " + c2.getSolde() + " MAD");
        System.out.println("Solde avec intérêts standard : " + soldeInteretBase + " MAD");
        System.out.println("Solde avec intérêts + bonus (+1.5%) : " + soldeInteretBonus + " MAD");

        System.out.println("\n--- 7. Informations Globales ---");
        System.out.println("Nombre total de comptes créés : " + CompteBancaire.getNbComptes());
        System.out.println("Taux d'intérêt annuel appliqué : " + (CompteBancaire.getTauxInteretAnnuel() * 100) + "%");
    }
}
```

### Exécution (Partie 3)


```text
--- 1. Création de la banque ---

--- 2. Création des trois comptes ---

--- 3. Ajout des comptes à la banque ---

--- 4. Opérations (Dépôt/Retrait sur c1, Virement c2 -> c3) ---
Retrait de 2800 MAD sur c1 :
Virement de 1000 MAD de c2 vers c3 :
Virement effectué avec succès vers le compte de Charlie

=== Liste des comptes de la banque : MarocBank ===
-----------------------------------
Compte N° 1
Titulaire : Alice
Solde : -300.0 MAD
Découvert autorisé : 500.0 MAD
-----------------------------------
-----------------------------------
Compte N° 2
Titulaire : Bob
Solde : 2000.0 MAD
Découvert autorisé : 1000.0 MAD
-----------------------------------
-----------------------------------
Compte N° 3
Titulaire : Charlie
Solde : 2500.0 MAD
Découvert autorisé : 200.0 MAD
-----------------------------------
==================================================

--- 6. Calcul des intérêts pour le compte c2 ---
Solde actuel de c2 (Bob) : 2000.0 MAD
Solde avec intérêts standard : 2060.0 MAD
Solde avec intérêts + bonus (+1.5%) : 2090.0 MAD

--- 7. Informations Globales ---
Nombre total de comptes créés : 3
Taux d'intérêt annuel appliqué : 3.0%
```
