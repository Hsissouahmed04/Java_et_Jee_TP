package tp2.partie1;

public class CompteBancaire {
    // 3. Variables statiques pour l'ensemble des comptes
    private static int nbComptes = 0;
    private static double tauxInteretAnnuel = 0.03; // 3% par défaut

    // 2. Attributs privés
    private int numero;
    private String titulaire;
    private double solde;
    private double decouvertAutorise;

    // 4. Constructeur par défaut
    public CompteBancaire() {
        nbComptes++;
        this.numero = nbComptes; // Génère un numéro unique
        this.titulaire = "Anonyme";
        this.solde = 0.0;
        this.decouvertAutorise = 0.0;
    }

    // 5. Constructeur paramétré
    public CompteBancaire(String titulaire, double soldeInitial, double decouvertAutorise) {
        nbComptes++;
        this.numero = nbComptes;
        this.setTitulaire(titulaire); // Utilisation du setter pour la validation
        this.solde = soldeInitial;
        this.setDecouvertAutorise(decouvertAutorise); // Utilisation du setter pour la validation
    }

    // 6. Méthodes get/set avec validations
    public int getNumero() {
        return numero;
    }

    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        if (titulaire != null && !titulaire.trim().isEmpty()) {
            this.titulaire = titulaire;
        } else {
            System.out.println("Erreur : le titulaire ne peut pas être vide.");
            this.titulaire = "Inconnu";
        }
    }

    public double getSolde() {
        return solde;
    }

    // Pas de validation spécifique demandée pour setSolde, mais on pourrait éviter les valeurs aberrantes
    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public void setDecouvertAutorise(double decouvertAutorise) {
        if (decouvertAutorise >= 0) {
            this.decouvertAutorise = decouvertAutorise;
        } else {
            System.out.println("Erreur : le découvert autorisé ne peut pas être négatif.");
            this.decouvertAutorise = 0;
        }
    }

    // 7. Méthode afficher()
    public void afficher() {
        System.out.println("-----------------------------------");
        System.out.println("Compte N° " + numero);
        System.out.println("Titulaire : " + titulaire);
        System.out.println("Solde : " + solde + " MAD");
        System.out.println("Découvert autorisé : " + decouvertAutorise + " MAD");
        System.out.println("-----------------------------------");
    }

    // 8. Opérations de dépôt, retrait et virement
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            // System.out.println("Dépôt réussi. Nouveau solde : " + solde + " MAD");
        } else {
            System.out.println("Montant de dépôt invalide.");
        }
    }

    public void retirer(double montant) {
        // Le montant doit être positif et le solde après retrait ne doit pas dépasser le découvert
        if (montant > 0 && (solde - montant >= -decouvertAutorise)) {
            solde -= montant;
            // System.out.println("Retrait réussi. Nouveau solde : " + solde + " MAD");
        } else {
            System.out.println("Retrait refusé.");
        }
    }

    public void virementVers(CompteBancaire autre, double montant) {
        if (montant > 0 && (this.solde - montant >= -this.decouvertAutorise)) {
            this.solde -= montant;
            autre.solde += montant;
            System.out.println("Virement effectué avec succès vers le compte de " + autre.getTitulaire());
        } else {
            System.out.println("Virement impossible : montant ou solde insuffisant.");
        }
    }

    // 9. Deux versions de calculerSoldeAvecInterets() (Surcharge de méthodes)
    public double calculerSoldeAvecInterets() {
        return this.solde + (this.solde * tauxInteretAnnuel);
    }

    public double calculerSoldeAvecInterets(double bonus) {
        return this.solde + (this.solde * (tauxInteretAnnuel + bonus));
    }

    // 10. Méthodes statiques pour nbComptes et tauxInteretAnnuel
    public static int getNbComptes() {
        return nbComptes;
    }

    public static double getTauxInteretAnnuel() {
        return tauxInteretAnnuel;
    }

    public static void setTauxInteretAnnuel(double taux) {
        if (taux >= 0) {
            tauxInteretAnnuel = taux;
        } else {
            System.out.println("Erreur : le taux ne peut pas être négatif.");
        }
    }
}
