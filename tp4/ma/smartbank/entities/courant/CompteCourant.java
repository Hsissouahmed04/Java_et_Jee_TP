package ma.smartbank.entities.courant;

import ma.smartbank.entities.base.Compte;

public class CompteCourant extends Compte {
    private double decouvertAutorise;

    public CompteCourant(int numero, double solde, double decouvertAutorise) {
        super(numero, solde);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retirer(double montant) {
        if (montant > 0 && (solde + decouvertAutorise) >= montant) {
            solde -= montant;
            System.out.println("Retrait de " + montant + " effectué. Nouveau solde : " + solde);
        } else {
            System.out.println("Retrait refusé : fonds insuffisants, même avec le découvert autorisé.");
        }
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Découvert autorisé : " + decouvertAutorise);
    }
}
