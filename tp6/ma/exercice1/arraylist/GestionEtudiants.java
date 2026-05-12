package ma.tp6.exercice1.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionEtudiants {
    private List<Etudiant> listeEtudiants;

    public GestionEtudiants() {
        this.listeEtudiants = new ArrayList<>();
    }

    public void ajouterEtudiant(Etudiant e) {
        listeEtudiants.add(e);
        System.out.println("Étudiant ajouté avec succès.");
    }

    public void supprimerEtudiant(Etudiant e) {
        if (listeEtudiants.remove(e)) {
            System.out.println("Étudiant supprimé avec succès.");
        } else {
            System.out.println("Étudiant introuvable.");
        }
    }

    public Etudiant rechercherEtudiant(String nom) {
        for (Etudiant e : listeEtudiants) {
            if (e.getNom().equalsIgnoreCase(nom)) {
                return e;
            }
        }
        return null;
    }

    public void trierParMoyenne() {
        Collections.sort(listeEtudiants);
        System.out.println("Liste triée par moyenne (ordre décroissant).");
    }

    public void afficherEtudiants() {
        if (listeEtudiants.isEmpty()) {
            System.out.println("Aucun étudiant dans la liste.");
        } else {
            System.out.println("--- Liste des étudiants ---");
            for (Etudiant e : listeEtudiants) {
                System.out.println(e);
            }
        }
    }
}
