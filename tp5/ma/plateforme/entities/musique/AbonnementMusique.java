package ma.plateforme.entities.musique;

import ma.plateforme.entities.abstrait.Abonnement;
import ma.plateforme.entities.interfaces.Reducible;

public class AbonnementMusique extends Abonnement implements Reducible {
    private boolean sansPublicite;
    private double reductionActuelle = 0.0;

    public AbonnementMusique(int id, String nomUtilisateur, double prixDeBase, boolean sansPublicite) {
        super(id, nomUtilisateur, prixDeBase);
        this.sansPublicite = sansPublicite;
    }

    @Override
    public double calculerCoutMensuel() {
        double cout = this.prixDeBase;
        if (sansPublicite) {
            cout += 15.0; // Supplément pour enlever les pubs
        }
        return cout * (1 - reductionActuelle);
    }

    @Override
    public int calculerScoreSatisfaction() {
        int score = 60; // Score de base
        if (sansPublicite) {
            score += 40; // Les utilisateurs aiment ne pas avoir de pub
        }
        return Math.min(score, 100);
    }

    @Override
    public boolean appliquerReduction(double pourcentage) {
        if (pourcentage > 30) {
            System.out.println("Refus (Musique) : La réduction demandée (" + pourcentage + "%) dépasse la limite de 30%.");
            return false;
        }
        this.reductionActuelle = pourcentage / 100.0;
        System.out.println("Succès (Musique) : Réduction de " + pourcentage + "% appliquée.");
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " - Type: Musique [Sans Pub=" + sansPublicite + "]";
    }
}
