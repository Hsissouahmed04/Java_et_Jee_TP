package ma.tp6.exercice3.sets;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GestionMatieres {
    private Set<String> ensembleMatieres;

    public GestionMatieres() {
        this.ensembleMatieres = new HashSet<>();
    }

    public void ajouterMatiere(String matiere) {
        // add() retourne false si l'élément existe déjà
        if (ensembleMatieres.add(matiere)) {
            System.out.println("La matière '" + matiere + "' a été ajoutée avec succès.");
        } else {
            System.out.println("La matière '" + matiere + "' existe déjà (doublon ignoré).");
        }
    }

    public void supprimerMatiere(String matiere) {
        if (ensembleMatieres.remove(matiere)) {
            System.out.println("La matière '" + matiere + "' a été supprimée.");
        } else {
            System.out.println("Impossible de supprimer : la matière '" + matiere + "' est introuvable.");
        }
    }

    public boolean rechercherMatiere(String matiere) {
        return ensembleMatieres.contains(matiere);
    }

    public void afficherMatieres() {
        System.out.println("--- Liste brute des matières (HashSet) ---");
        for (String matiere : ensembleMatieres) {
            System.out.println("- " + matiere);
        }
    }

    public void afficherMatieresTriees() {
        // En transférant le HashSet vers un TreeSet, on obtient automatiquement un tri alphabétique
        Set<String> matieresTriees = new TreeSet<>(ensembleMatieres);
        System.out.println("--- Liste triée des matières (TreeSet) ---");
        for (String matiere : matieresTriees) {
            System.out.println("- " + matiere);
        }
    }
}
