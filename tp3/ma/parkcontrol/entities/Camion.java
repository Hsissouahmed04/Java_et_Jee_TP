package ma.parkcontrol.entities;

public class Camion extends Vehicule {
    private double chargeMax;

    public Camion(String matricule, String marque, double chargeMax) {
        super(matricule, marque);
        this.chargeMax = chargeMax;
    }

    @Override
    public void stationner() {
        System.out.println("Le camion " + matricule + " est stationné dans la zone pour véhicules lourds.");
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Type: Camion, Charge max: " + chargeMax + " tonnes");
    }
}
