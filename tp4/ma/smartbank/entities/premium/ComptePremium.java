package ma.smartbank.entities.premium;

import ma.smartbank.entities.base.Compte;

public class ComptePremium extends Compte {
    private double bonusDepot;

    public ComptePremium(int numero, double solde, double bonusDepot) {
        super(numero, solde);
        this.bonusDepot = bonusDepot;
    }

    @Override
    public void deposer(double montant) {
        if (montant > 0) {
            double totalDepot = montant + bonusDepot;
            solde += totalDepot;
            System.out.println("Dépôt de " + montant + " effectué avec un bonus de " + bonusDepot + ". Nouveau solde : " + solde);
        } else {
            System.out.println("Montant de dépôt invalide.");
        }
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Bonus par dépôt : " + bonusDepot);
    }
}
