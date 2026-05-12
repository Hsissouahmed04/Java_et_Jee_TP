package ma.plateforme.entities.jeux;

import ma.plateforme.entities.abstrait.Abonnement;

public class AbonnementJeux extends Abonnement {
    private int catalogueJeuxActifs;

    public AbonnementJeux(int id, String nomUtilisateur, double prixDeBase, int catalogueJeuxActifs) {
        super(id, nomUtilisateur, prixDeBase);
        this.catalogueJeuxActifs = catalogueJeuxActifs;
    }

    @Override
    public double calculerCoutMensuel() {
        // Le coût peut augmenter en fonction de la taille du catalogue actif
        double cout = this.prixDeBase;
        if (catalogueJeuxActifs > 100) {
            cout += 20.0;
        }
        return cout;
    }

    @Override
    public int calculerScoreSatisfaction() {
        int score = 50 + (catalogueJeuxActifs / 10);
        return Math.min(score, 100);
    }

    @Override
    public String toString() {
        return super.toString() + " - Type: Jeux [Catalogue=" + catalogueJeuxActifs + " jeux]";
    }
}
