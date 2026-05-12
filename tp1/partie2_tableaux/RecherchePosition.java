package tp1.partie2_tableaux;

import java.util.Scanner;

public class RecherchePosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialisation d'un tableau pour l'exercice
        int[] tableau = {10, 25, 30, 45, 50};
        
        System.out.print("Entrez la valeur à rechercher : ");
        int valeurRecherchee = scanner.nextInt();
        
        int position = -1;
        
        // Recherche de la valeur
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i] == valeurRecherchee) {
                position = i;
                break; // On arrête la recherche si trouvé
            }
        }
        
        // Affichage du résultat
        if (position != -1) {
            System.out.println("La valeur " + valeurRecherchee + " se trouve à l'indice : " + position);
        } else {
            System.out.println("La valeur " + valeurRecherchee + " n'est pas dans le tableau.");
        }
        
        scanner.close();
    }
}
