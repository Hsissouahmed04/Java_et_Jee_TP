package tp1.partie2_tableaux;

import java.util.Scanner;

public class MaxTableau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez la taille du tableau : ");
        int taille = scanner.nextInt();
        
        int[] tableau = new int[taille];
        
        // Saisie des éléments du tableau
        for (int i = 0; i < taille; i++) {
            System.out.print("Entrez l'élément " + (i + 1) + " : ");
            tableau[i] = scanner.nextInt();
        }
        
        // Initialisation du max avec le premier élément
        int max = tableau[0];
        
        // Recherche du maximum
        for (int i = 1; i < taille; i++) {
            if (tableau[i] > max) {
                max = tableau[i];
            }
        }
        
        System.out.println("Le maximum du tableau est : " + max);
        
        scanner.close();
    }
}
