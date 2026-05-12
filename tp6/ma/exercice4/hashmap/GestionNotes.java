package ma.tp6.exercice4.hashmap;

import java.util.HashMap;
import java.util.Map;

public class GestionNotes {
    private Map<String, Double> notesEtudiants;

    public GestionNotes() {
        this.notesEtudiants = new HashMap<>();
    }

    public void ajouterOuModifierNote(String nomEtudiant, Double note) {
        notesEtudiants.put(nomEtudiant, note);
        System.out.println("Note enregistrée/mise à jour pour l'étudiant : " + nomEtudiant);
    }

    public void supprimerNote(String nomEtudiant) {
        if (notesEtudiants.remove(nomEtudiant) != null) {
            System.out.println("La note de l'étudiant " + nomEtudiant + " a été supprimée.");
        } else {
            System.out.println("Impossible de supprimer : étudiant " + nomEtudiant + " introuvable.");
        }
    }

    public Double consulterNote(String nomEtudiant) {
        if (notesEtudiants.containsKey(nomEtudiant)) {
            return notesEtudiants.get(nomEtudiant);
        } else {
            System.out.println("Étudiant " + nomEtudiant + " introuvable.");
            return null;
        }
    }

    public void afficherToutesLesNotes() {
        if (notesEtudiants.isEmpty()) {
            System.out.println("Aucune note enregistrée.");
        } else {
            System.out.println("--- Relevé des notes ---");
            for (Map.Entry<String, Double> entry : notesEtudiants.entrySet()) {
                System.out.println("Étudiant: " + entry.getKey() + " | Note: " + entry.getValue());
            }
        }
    }

    public double calculerMoyenneGenerale() {
        if (notesEtudiants.isEmpty()) {
            return 0.0;
        }

        double somme = 0.0;
        for (Double note : notesEtudiants.values()) {
            somme += note;
        }

        return somme / notesEtudiants.size();
    }
}
