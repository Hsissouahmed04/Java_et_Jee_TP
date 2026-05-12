package tp2.partie3;

import tp2.partie1.CompteBancaire;
import tp2.partie2.Banque;

public class TestBanque {
    public static void main(String[] args) {
        System.out.println("--- 1. Création de la banque ---");
        // 1. Créez une banque 'MarocBank' (capacité 1500).
        Banque banque = new Banque("MarocBank", 1500);

        System.out.println("\n--- 2. Création des trois comptes ---");
        // 2. Créez trois comptes c1, c2 et c3.
        CompteBancaire c1 = new CompteBancaire("Alice", 2000, 500);
        CompteBancaire c2 = new CompteBancaire("Bob", 3000, 1000);
        CompteBancaire c3 = new CompteBancaire("Charlie", 1500, 200);

        System.out.println("\n--- 3. Ajout des comptes à la banque ---");
        // 3. Ajoutez-les à la banque.
        banque.ajouterCompte(c1);
        banque.ajouterCompte(c2);
        banque.ajouterCompte(c3);

        System.out.println("\n--- 4. Opérations (Dépôt/Retrait sur c1, Virement c2 -> c3) ---");
        // 4. Effectuez : dépôt/retrait sur c1 et virement de c2 vers c3.
        c1.deposer(500); // Solde passe à 2500
        System.out.println("Retrait de 2800 MAD sur c1 :");
        c1.retirer(2800); // Solde passe à -300 (Autorisé car limite = 500)
        
        System.out.println("Virement de 1000 MAD de c2 vers c3 :");
        c2.virementVers(c3, 1000); // Bob perd 1000, Charlie gagne 1000

        // 5. Affichez tous les comptes.
        banque.afficherTous();

        System.out.println("--- 6. Calcul des intérêts pour le compte c2 ---");
        // 6. Appelez sur c2: calculerSoldeAvecInterets() et calculerSoldeAvecInterets(0.015).
        double soldeInteretBase = c2.calculerSoldeAvecInterets();
        double soldeInteretBonus = c2.calculerSoldeAvecInterets(0.015);
        
        System.out.println("Solde actuel de c2 (Bob) : " + c2.getSolde() + " MAD");
        System.out.println("Solde avec intérêts standard : " + soldeInteretBase + " MAD");
        System.out.println("Solde avec intérêts + bonus (+1.5%) : " + soldeInteretBonus + " MAD");

        System.out.println("\n--- 7. Informations Globales ---");
        // 7. Affichez le nombre total de comptes créés et le taux d’intérêt annuel.
        System.out.println("Nombre total de comptes créés : " + CompteBancaire.getNbComptes());
        System.out.println("Taux d'intérêt annuel : " + (CompteBancaire.getTauxInteretAnnuel() * 100) + "%");
    }
}
