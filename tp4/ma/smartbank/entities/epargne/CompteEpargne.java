package ma.smartbank.entities.epargne;

import ma.smartbank.entities.base.Compte;

public class CompteEpargne extends Compte {
    private double tauxInteret;

    public CompteEpargne(int numero, double solde, double tauxInteret) {
        super(numero, solde);
        this.tauxInteret = tauxInteret;
    }

    public void calculerInteret() {
        double interet = solde * (tauxInteret / 100);
        solde += interet;
        System.out.println("Intérêts calculés et ajoutés : " + interet + ". Nouveau solde : " + solde);
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Taux d'intérêt : " + tauxInteret + "%");
    }
}
