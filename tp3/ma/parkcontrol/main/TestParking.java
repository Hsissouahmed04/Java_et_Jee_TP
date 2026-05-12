package ma.parkcontrol.main;

import ma.parkcontrol.entities.*;

public class TestParking {
    public static void main(String[] args) {
        Vehicule[] parking = new Vehicule[4];
        
        parking[0] = new Voiture("1111-A-1", "Dacia", 5);
        parking[1] = new Voiture("2222-B-2", "Peugeot", 3);
        parking[2] = new Moto("3333-C-3", "Yamaha", true);
        parking[3] = new Camion("4444-D-4", "Volvo", 15.5);
        
        System.out.println("--- Démonstration du Polymorphisme ---");
        for (Vehicule v : parking) {
            v.afficher();
            v.stationner();
            System.out.println("--------------------------------------");
        }
        
        System.out.println("\n--- Affichage uniquement des Voitures (instanceof) ---");
        for (Vehicule v : parking) {
            if (v instanceof Voiture) {
                v.afficher();
                System.out.println("--------------------------------------");
            }
        }
    }
}
