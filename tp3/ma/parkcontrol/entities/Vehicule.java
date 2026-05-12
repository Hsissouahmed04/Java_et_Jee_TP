package ma.parkcontrol.entities;

public class Vehicule {
    protected String matricule;
    protected String marque;

    public Vehicule(String matricule, String marque) {
        this.matricule = matricule;
        this.marque = marque;
    }

    public void stationner() {
        System.out.println("Le véhicule " + matricule + " de marque " + marque + " est stationné dans une place standard.");
    }

    public void afficher() {
        System.out.println("Véhicule [Matricule: " + matricule + ", Marque: " + marque + "]");
    }
}
