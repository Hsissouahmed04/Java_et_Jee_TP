package ma.smartbank.main;

import ma.smartbank.entities.base.Compte;
import ma.smartbank.entities.courant.CompteCourant;
import ma.smartbank.entities.epargne.CompteEpargne;
import ma.smartbank.entities.premium.ComptePremium;

public class TestBanque {
    public static void main(String[] args) {
        // 1. Tableau polymorphe avec les 4 comptes demandés
        Compte[] comptes = new Compte[4];
        comptes[0] = new Compte(1001, 5000.0);
        comptes[1] = new CompteCourant(1002, 3000.0, 1000.0);
        comptes[2] = new CompteEpargne(1003, 8000.0, 5.0);
        comptes[3] = new ComptePremium(1004, 15000.0, 50.0);

        System.out.println("=== AFFICHAGE DES COMPTES ===");
        for (Compte compte : comptes) {
            compte.afficher(); // Appel polymorphique (super.afficher() utilisé en interne pour les enfants)
            System.out.println("---------------------------");
        }

        // Tests de dépôt et retrait via le polymorphisme
        System.out.println("=== OPERATIONS SUR LES COMPTES ===");
        comptes[1].retirer(3500.0); // Retrait utilisant le découvert (CompteCourant)
        comptes[3].deposer(1000.0); // Dépôt avec bonus premium (ComptePremium)
        System.out.println("---------------------------");

        // 2. Filtrage instanceof pour les comptes épargne
        System.out.println("=== FILTRAGE INSTANCEOF ===");
        for (Compte compte : comptes) {
            if (compte instanceof CompteEpargne) {
                System.out.println("Compte Epargne trouvé (N° " + compte.getNumero() + ") !");
                // On cast le compte en CompteEpargne pour utiliser la méthode spécifique
                CompteEpargne ce = (CompteEpargne) compte;
                ce.calculerInteret();
            }
        }
        System.out.println("---------------------------");

        // 3. Downcasting provoquant une erreur (ClassCastException)
        System.out.println("=== TEST DE DOWNCASTING INVALIDE ===");
        try {
            /* 
             * EXPLICATION :
             * Le compte à l'indice 2 (comptes[2]) a été instancié en tant que CompteEpargne.
             * Bien que CompteCourant et CompteEpargne héritent tous deux de la classe de base Compte,
             * ils n'ont pas de relation d'héritage directe entre eux (ce sont des classes "sœurs").
             * Le compilateur Java autorise le cast car comptes[2] est de type statique Compte,
             * mais à l'exécution (runtime), la JVM vérifie le type réel et voit qu'un CompteEpargne 
             * ne peut pas être forcé en CompteCourant. Cela provoque une ClassCastException.
             */
            System.out.println("Tentative de downcasting de comptes[2] (type réel = CompteEpargne) vers CompteCourant...");
            CompteCourant cc = (CompteCourant) comptes[2]; 
            cc.retirer(100); // Cette ligne ne sera jamais atteinte
        } catch (ClassCastException e) {
            System.out.println("Erreur attrapée : " + e.toString());
            System.out.println("-> C'est normal ! Un CompteEpargne ne peut pas être casté en CompteCourant.");
        }
    }
}
