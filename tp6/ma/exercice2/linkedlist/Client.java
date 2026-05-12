package ma.tp6.exercice2.linkedlist;

public class Client {
    private String nom;
    private int numeroBillet;

    public Client(String nom, int numeroBillet) {
        this.nom = nom;
        this.numeroBillet = numeroBillet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumeroBillet() {
        return numeroBillet;
    }

    public void setNumeroBillet(int numeroBillet) {
        this.numeroBillet = numeroBillet;
    }

    @Override
    public String toString() {
        return "Client [Billet n°" + numeroBillet + " : " + nom + "]";
    }
}
