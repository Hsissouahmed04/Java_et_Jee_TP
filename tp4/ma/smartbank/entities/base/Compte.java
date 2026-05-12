package ma.smartbank.entities.base;

public class Compte {
    protected int numero;
    protected double solde;

    public Compte(int numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public int getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + " effectué. Nouveau solde : " + solde);
        } else {
            System.out.println("Montant de dépôt invalide.");
        }
    }

    public void retirer(double montant) {
        if (montant > 0 && solde >= montant) {
            solde -= montant;
            System.out.println("Retrait de " + montant + " effectué. Nouveau solde : " + solde);
        } else {
            System.out.println("Retrait refusé : solde insuffisant.");
        }
    }

    public void afficher() {
        System.out.println("Compte N° : " + numero);
        System.out.println("Solde : " + solde);
    }
}
