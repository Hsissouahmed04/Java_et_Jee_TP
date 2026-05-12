package ma.plateforme.entities.abstrait;

public abstract class Abonnement {
    protected int id;
    protected String nomUtilisateur;
    protected double prixDeBase;

    public Abonnement(int id, String nomUtilisateur, double prixDeBase) {
        this.id = id;
        this.nomUtilisateur = nomUtilisateur;
        this.prixDeBase = prixDeBase;
    }

    // Méthodes abstraites
    public abstract double calculerCoutMensuel();
    public abstract int calculerScoreSatisfaction();

    public int getId() {
        return id;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public double getPrixDeBase() {
        return prixDeBase;
    }

    @Override
    public String toString() {
        return "Abonnement [id=" + id + ", utilisateur=" + nomUtilisateur + ", prix de base=" + prixDeBase + "]";
    }
}
