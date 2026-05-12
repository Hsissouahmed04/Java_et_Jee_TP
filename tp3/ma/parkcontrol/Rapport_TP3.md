# RAPPORT DE TRAVAUX PRATIQUES (TP3)
## Programmation Orientée Objet en Java : Héritage et Polymorphisme

---


*   **Nom et Prénom :** ahmed hsissou
*   **Lien du dépôt GitHub :** https://github.com/Hsissouahmed04


---

### 3. Code Source (Implémentation)

#### 3.1. Package : `ma.parkcontrol.entities`

**Fichier : `Vehicule.java` (Classe Mère)**
```java
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
```

**Fichier : `Voiture.java` (Classe Fille)**
```java
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
```

**Fichier : `Moto.java` (Classe Fille)**
```java
package ma.parkcontrol.entities;

public class Moto extends Vehicule {
    private boolean avecCasque;

    public Moto(String matricule, String marque, boolean avecCasque) {
        super(matricule, marque);
        this.avecCasque = avecCasque;
    }

    @Override
    public void stationner() {
        System.out.println("La moto " + matricule + " est stationnée dans la place réservée aux deux-roues.");
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Type: Moto, Casque inclus: " + (avecCasque ? "Oui" : "Non"));
    }
}
```

**Fichier : `Camion.java` (Classe Fille)**
```java
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
```

#### 3.2. Package : `ma.parkcontrol.main`

**Fichier : `TestParking.java` (Classe Principale)**
```java
package ma.parkcontrol.main;

import ma.parkcontrol.entities.*;

public class TestParking {
    public static void main(String[] args) {
        // 1. Démonstration du Polymorphisme (Upcasting)
        Vehicule[] parking = new Vehicule[4];
        
        parking[0] = new Voiture("1111-A-1", "Dacia", 5);
        parking[1] = new Voiture("2222-B-2", "Peugeot", 3);
        parking[2] = new Moto("3333-C-3", "Yamaha", true);
        parking[3] = new Camion("4444-D-4", "Volvo", 15.5);
        
        System.out.println("=== 1. DEMONSTRATION DU POLYMORPHISME ===");
        for (Vehicule v : parking) {
            v.afficher();
            v.stationner();
            System.out.println("--------------------------------------");
        }
        
        // 2. Utilisation de l'opérateur instanceof
        System.out.println("\n=== 2. FILTRAGE : AFFICHAGE UNIQUEMENT DES VOITURES ===");
        for (Vehicule v : parking) {
            if (v instanceof Voiture) {
                v.afficher();
                System.out.println("--------------------------------------");
            }
        }

        // 3. Analyse du Downcasting et de l'Exception
        System.out.println("\n=== 3. ANALYSE DE L'EXCEPTION (DOWNCASTING) ===");
        try {
            Vehicule x = new Moto("5555-E-5", "Honda", false);
            // La ligne suivante provoque une ClassCastException
            Voiture v1 = (Voiture) x; 
        } catch (ClassCastException e) {
            System.out.println("Erreur interceptée : " + e.toString());
            System.out.println("Explication de l'erreur :");
            System.out.println("Le compilateur autorise le cast car 'x' est de type 'Vehicule' (classe mère de Voiture).");
            System.out.println("Cependant, à l'exécution (Runtime), la JVM vérifie l'objet réel en mémoire. L'objet est une 'Moto'.");
            System.out.println("Comme une Moto ne peut pas être transformée en Voiture (elles sont sœurs, pas parent-enfant), la JVM lève une ClassCastException.");
        }
    }
}
```

---

### 4. Exécution 


```text
=== 1. DEMONSTRATION DU POLYMORPHISME ===
Véhicule [Matricule: 1111-A-1, Marque: Dacia]
Type: Voiture, Nombre de portes: 5
La voiture 1111-A-1 est stationnée dans la zone des voitures.
--------------------------------------
Véhicule [Matricule: 2222-B-2, Marque: Peugeot]
Type: Voiture, Nombre de portes: 3
La voiture 2222-B-2 est stationnée dans la zone des voitures.
--------------------------------------
Véhicule [Matricule: 3333-C-3, Marque: Yamaha]
Type: Moto, Casque inclus: Oui
La moto 3333-C-3 est stationnée dans la place réservée aux deux-roues.
--------------------------------------
Véhicule [Matricule: 4444-D-4, Marque: Volvo]
Type: Camion, Charge max: 15.5 tonnes
Le camion 4444-D-4 est stationné dans la zone pour véhicules lourds.
--------------------------------------

=== 2. FILTRAGE : AFFICHAGE UNIQUEMENT DES VOITURES ===
Véhicule [Matricule: 1111-A-1, Marque: Dacia]
Type: Voiture, Nombre de portes: 5
--------------------------------------
Véhicule [Matricule: 2222-B-2, Marque: Peugeot]
Type: Voiture, Nombre de portes: 3
--------------------------------------

=== 3. ANALYSE DE L'EXCEPTION (DOWNCASTING) ===
Erreur interceptée : java.lang.ClassCastException: class ma.parkcontrol.entities.Moto cannot be cast to class ma.parkcontrol.entities.Voiture
Explication de l'erreur :
Le compilateur autorise le cast car 'x' est de type 'Vehicule' (classe mère de Voiture).
Cependant, à l'exécution (Runtime), la JVM vérifie l'objet réel en mémoire. L'objet est une 'Moto'.
Comme une Moto ne peut pas être transformée en Voiture (elles sont sœurs, pas parent-enfant), la JVM lève une ClassCastException.
```

