package ma.parkcontrol.entities;

public class Voiture extends Vehicule {
    private int nbPortes;

    public Voiture(String matricule, String marque, int nbPortes) {
        super(matricule, marque);
        this.nbPortes = nbPortes;
    }

    @Override
    public void stationner() {
        System.out.println("La voiture " + matricule + " est stationnée dans la zone des voitures.");
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Type: Voiture, Nombre de portes: " + nbPortes);
    }
}
