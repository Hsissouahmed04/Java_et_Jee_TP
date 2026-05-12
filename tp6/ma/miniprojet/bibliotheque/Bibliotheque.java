package ma.tp6.miniprojet.bibliotheque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bibliotheque {
    // ArrayList pour stocker tous les livres disponibles et empruntés
    private List<Livre> inventaireLivres;
    
    // HashSet pour maintenir une liste unique des catégories existantes
    private Set<String> categories;
    
    // HashMap pour lier un livre (emprunté) à l'emprunteur (nom)
    private Map<Livre, String> empruntsActuels;

    public Bibliotheque() {
        this.inventaireLivres = new ArrayList<>();
        this.categories = new HashSet<>();
        this.empruntsActuels = new HashMap<>();
    }

    public void ajouterLivre(Livre livre) {
        if (!inventaireLivres.contains(livre)) {
            inventaireLivres.add(livre);
            categories.add(livre.getCategorie());
            System.out.println("Livre ajouté à la bibliothèque : " + livre.getTitre());
        } else {
            System.out.println("Erreur : Ce livre (ISBN " + livre.getIsbn() + ") existe déjà dans l'inventaire.");
        }
    }

    public void supprimerLivre(String isbn) {
        Livre livreASupprimer = rechercherLivreParIsbn(isbn);
        if (livreASupprimer != null) {
            // S'il est emprunté, on le retire aussi des emprunts
            empruntsActuels.remove(livreASupprimer);
            inventaireLivres.remove(livreASupprimer);
            System.out.println("Le livre " + livreASupprimer.getTitre() + " a été retiré de la bibliothèque.");
        } else {
            System.out.println("Impossible de supprimer : Livre non trouvé.");
        }
    }

    public Livre rechercherLivreParIsbn(String isbn) {
        for (Livre l : inventaireLivres) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    public void emprunterLivre(String isbn, String nomEmprunteur) {
        Livre livre = rechercherLivreParIsbn(isbn);
        
        if (livre == null) {
            System.out.println("Erreur : Ce livre n'existe pas dans la bibliothèque.");
            return;
        }

        if (empruntsActuels.containsKey(livre)) {
            System.out.println("Erreur : Le livre '" + livre.getTitre() + "' est déjà emprunté par " + empruntsActuels.get(livre) + ".");
        } else {
            empruntsActuels.put(livre, nomEmprunteur);
            System.out.println(nomEmprunteur + " a emprunté le livre : " + livre.getTitre());
        }
    }

    public void retournerLivre(String isbn) {
        Livre livre = rechercherLivreParIsbn(isbn);
        
        if (livre != null && empruntsActuels.containsKey(livre)) {
            empruntsActuels.remove(livre);
            System.out.println("Le livre '" + livre.getTitre() + "' a été retourné avec succès.");
        } else {
            System.out.println("Erreur : Ce livre n'est pas actuellement marqué comme emprunté.");
        }
    }

    public void afficherInventaire() {
        System.out.println("--- Inventaire Complet des Livres ---");
        for (Livre l : inventaireLivres) {
            System.out.println(l);
        }
    }

    public void afficherCategories() {
        System.out.println("--- Catégories Disponibles ---");
        for (String categorie : categories) {
            System.out.println("- " + categorie);
        }
    }

    public void afficherEmprunts() {
        if (empruntsActuels.isEmpty()) {
            System.out.println("Aucun livre n'est actuellement emprunté.");
        } else {
            System.out.println("--- Liste des Emprunts Actuels ---");
            for (Map.Entry<Livre, String> entry : empruntsActuels.entrySet()) {
                System.out.println("Livre : '" + entry.getKey().getTitre() + "' | Emprunteur : " + entry.getValue());
            }
        }
    }
}
