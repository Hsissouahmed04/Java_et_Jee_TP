package ma.shopexpress.main;

import ma.shopexpress.lecture.LecteurDonnees;
import ma.shopexpress.paiement.ServicePaiement;
import ma.shopexpress.ressources.GestionTransactions;

public class Application {
    public static void main(String[] args) {
        System.out.println("=== TP 7 : Gestion des Exceptions - ShopExpress ===\n");

        System.out.println("--- Partie 1 & 2 : Paiement (try/catch/finally et exceptions manuelles) ---");
        ServicePaiement servicePaiement = new ServicePaiement();
        System.out.println("> Test 1 : Paiement valide");
        servicePaiement.effectuerPaiement(50.0, 100.0);
        
        System.out.println("\n> Test 2 : Solde insuffisant");
        servicePaiement.effectuerPaiement(150.0, 100.0);
        
        System.out.println("\n> Test 3 : Montant négatif");
        servicePaiement.effectuerPaiement(-20.0, 100.0);


        System.out.println("\n--- Partie 3 : Lecture de données (throws et propagation) ---");
        LecteurDonnees lecteur = new LecteurDonnees();
        String[] montantsTest = {"150.5", "invalid", "-10.0"};
        
        for (String mStr : montantsTest) {
            try {
                System.out.println("\n> Lecture de la chaîne : '" + mStr + "'");
                double m = lecteur.lireMontant(mStr);
                System.out.println("Succès : Montant lu = " + m);
            } catch (NumberFormatException e) {
                // Interception de l'erreur technique propagée par lireMontant
                System.err.println("Erreur Technique : Impossible de convertir '" + mStr + "' en nombre.");
            } catch (IllegalArgumentException e) {
                // Interception de l'erreur métier propagée par lireMontant
                System.err.println("Erreur Métier : " + e.getMessage());
            }
        }


        System.out.println("\n--- Partie 4 : Gestion des transactions (multi-catch) ---");
        String[] transactions = {"Tx1", null, "Tx3"};
        GestionTransactions gestion = new GestionTransactions(transactions);
        
        System.out.println("\n> Test 1 : Index valide");
        gestion.lireTransaction(0);
        
        System.out.println("\n> Test 2 : Élément null dans le tableau");
        gestion.lireTransaction(1);
        
        System.out.println("\n> Test 3 : Index hors limites");
        gestion.lireTransaction(5);
        
        System.out.println("\n> Test 4 : Tableau complètement null");
        GestionTransactions gestionNull = new GestionTransactions(null);
        gestionNull.lireTransaction(0);
    }
}
