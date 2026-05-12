package ma.plateforme.main;

import ma.plateforme.entities.abstrait.Abonnement;
import ma.plateforme.entities.interfaces.Reducible;
import ma.plateforme.entities.video.AbonnementVideo;
import ma.plateforme.entities.musique.AbonnementMusique;
import ma.plateforme.entities.jeux.AbonnementJeux;

public class TestAbonnements {
    public static void main(String[] args) {
        // Création d'instances
        AbonnementVideo subVideo1 = new AbonnementVideo(1, "Ahmed", 50.0, "HD");
        AbonnementVideo subVideo2 = new AbonnementVideo(2, "Sara", 50.0, "4K");
        AbonnementMusique subMusique = new AbonnementMusique(3, "Youssef", 30.0, true);
        AbonnementJeux subJeux = new AbonnementJeux(4, "Fatima", 80.0, 150);

        // --- 1. Tableau Abonnement[] ---
        System.out.println("=================================================");
        System.out.println("             TEST DES ABONNEMENTS                ");
        System.out.println("=================================================");
        Abonnement[] abonnements = { subVideo1, subVideo2, subMusique, subJeux };

        for (Abonnement abo : abonnements) {
            System.out.println(abo.toString());
            System.out.println("-> Coût mensuel : " + abo.calculerCoutMensuel() + " DH");
            System.out.println("-> Score de satisfaction : " + abo.calculerScoreSatisfaction() + " / 100\n");
        }

        // --- 2. Tableau Reducible[] ---
        System.out.println("=================================================");
        System.out.println("             TEST DES RÉDUCTIONS                 ");
        System.out.println("=================================================");
        Reducible[] reducibles = { subVideo1, subVideo2, subMusique };

        // Test d'une réduction valide (20%)
        System.out.println("--- Application d'une réduction de 20% ---");
        for (Reducible r : reducibles) {
            r.appliquerReduction(20.0);
        }

        System.out.println("\n--- Application d'une réduction de 45% ---");
        // Test d'une réduction invalide (45%) qui devrait être refusée (> 30%)
        for (Reducible r : reducibles) {
            r.appliquerReduction(45.0);
        }

        System.out.println("\n=================================================");
        System.out.println("         COÛT FINAL APRÈS RÉDUCTIONS             ");
        System.out.println("=================================================");
        for (Abonnement abo : abonnements) {
            System.out.println(abo.getNomUtilisateur() + " paiera : " + abo.calculerCoutMensuel() + " DH");
        }
    }
}
