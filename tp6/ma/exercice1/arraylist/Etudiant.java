package ma.tp6.exercice1.arraylist;

public class Etudiant implements Comparable<Etudiant> {
    private String nom;
    private double moyenne;

    public Etudiant(String nom, double moyenne) {
        this.nom = nom;
        this.moyenne = moyenne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    @Override
    public int compareTo(Etudiant autre) {
        // Tri décroissant par moyenne (le plus grand en premier)
        return Double.compare(autre.moyenne, this.moyenne);
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", moyenne=" + moyenne +
                '}';
    }
}
