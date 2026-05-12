package ma.plateforme.entities.video;

import ma.plateforme.entities.abstrait.Abonnement;
import ma.plateforme.entities.interfaces.Reducible;

public class AbonnementVideo extends Abonnement implements Reducible {
    private String qualite; // e.g., "HD", "4K"
    private double reductionActuelle = 0.0;

    public AbonnementVideo(int id, String nomUtilisateur, double prixDeBase, String qualite) {
        super(id, nomUtilisateur, prixDeBase);
        this.qualite = qualite;
    }

    @Override
    public double calculerCoutMensuel() {
        double cout = this.prixDeBase;
        if ("4K".equalsIgnoreCase(qualite)) {
            cout += 30.0; // Supplément pour la 4K
        }
        return cout * (1 - reductionActuelle);
    }

    @Override
    public int calculerScoreSatisfaction() {
        int score = 70; // Score de base
        if ("4K".equalsIgnoreCase(qualite)) {
            score += 30; // Bonus pour une meilleure qualité
        }
        return Math.min(score, 100);
    }

    @Override
    public boolean appliquerReduction(double pourcentage) {
        if (pourcentage > 30) {
            System.out.println("Refus (Vidéo) : La réduction demandée (" + pourcentage + "%) dépasse la limite de 30%.");
            return false;
        }
        this.reductionActuelle = pourcentage / 100.0;
        System.out.println("Succès (Vidéo) : Réduction de " + pourcentage + "% appliquée.");
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " - Type: Vidéo [Qualité=" + qualite + "]";
    }
}
