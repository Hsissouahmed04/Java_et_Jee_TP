package ma.tp6.exercice5.treemap;

import java.util.Map;
import java.util.TreeMap;

public class ClassementEtudiants {
    private TreeMap<Integer, String> classement;

    public ClassementEtudiants() {
        this.classement = new TreeMap<>();
    }

    public void ajouterEtudiant(Integer rang, String nomEtudiant) {
        classement.put(rang, nomEtudiant);
        System.out.println("L'étudiant " + nomEtudiant + " a été ajouté à la position " + rang + ".");
    }

    public void supprimerParRang(Integer rang) {
        if (classement.remove(rang) != null) {
            System.out.println("L'étudiant au rang " + rang + " a été retiré du classement.");
        } else {
            System.out.println("Aucun étudiant trouvé au rang " + rang + ".");
        }
    }

    public void modifierNomParRang(Integer rang, String nouveauNom) {
        if (classement.containsKey(rang)) {
            classement.put(rang, nouveauNom);
            System.out.println("Le nom de l'étudiant au rang " + rang + " a été mis à jour en : " + nouveauNom);
        } else {
            System.out.println("Rang " + rang + " introuvable pour la modification.");
        }
    }

    public String obtenirEtudiant(Integer rang) {
        return classement.get(rang);
    }

    public void afficherClassement() {
        if (classement.isEmpty()) {
            System.out.println("Le classement est vide.");
        } else {
            System.out.println("--- Classement Général Automatique ---");
            for (Map.Entry<Integer, String> entry : classement.entrySet()) {
                System.out.println("Rang " + entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    public void afficherExtremes() {
        if (!classement.isEmpty()) {
            Map.Entry<Integer, String> premier = classement.firstEntry();
            Map.Entry<Integer, String> dernier = classement.lastEntry();

            System.out.println("Premier du classement : " + premier.getValue() + " (Rang " + premier.getKey() + ")");
            System.out.println("Dernier du classement : " + dernier.getValue() + " (Rang " + dernier.getKey() + ")");
        } else {
            System.out.println("Impossible d'afficher les extrêmes, le classement est vide.");
        }
    }
}
