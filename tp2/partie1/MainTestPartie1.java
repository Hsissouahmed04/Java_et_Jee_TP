package tp2.partie1;

public class MainTestPartie1 {
    public static void main(String[] args) {
        System.out.println("--- Test de la création des comptes ---");
        
        // Test du constructeur par défaut
        CompteBancaire compte1 = new CompteBancaire();
        compte1.afficher();
        
        // Test du constructeur paramétré
        CompteBancaire compte2 = new CompteBancaire("Alice", 1000, 500);
        compte2.afficher();
        
        System.out.println("\n--- Test des retraits selon l'exemple du TP ---");
        // Test de l'exemple du TP : 1000 MAD avec découvert de 500 MAD
        System.out.println("Cas 1 : Retrait de 1200 MAD");
        compte2.retirer(1200); // Doit être autorisé
        compte2.afficher();
        
        System.out.println("\nCas 2 : Retrait de 1600 MAD (en partant du solde initial de 1000 MAD)");
        // On remet le solde à 1000
        compte2.setSolde(1000); 
        compte2.retirer(1600); // Doit être refusé
        
        System.out.println("\n--- Test du nombre total de comptes ---");
        System.out.println("Nombre total de comptes créés : " + CompteBancaire.getNbComptes());
    }
}
