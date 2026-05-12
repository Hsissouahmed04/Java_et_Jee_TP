package tp1.partie2_tableaux;

import java.util.Scanner;

public class SaisieAffichageTableau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez la taille du tableau : ");
        int taille = scanner.nextInt();
        
        int[] tableau = new int[taille];
        
        // Saisie des éléments
        for (int i = 0; i < taille; i++) {
            System.out.print("Entrez l'élément " + (i + 1) + " : ");
            tableau[i] = scanner.nextInt();
        }
        
        // Affichage des éléments
        System.out.print("Contenu du tableau : ");
        for (int i = 0; i < taille; i++) {
            System.out.print(tableau[i] + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}
