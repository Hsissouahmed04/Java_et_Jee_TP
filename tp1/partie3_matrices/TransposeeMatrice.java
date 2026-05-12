package tp1.partie3_matrices;

import java.util.Scanner;

public class TransposeeMatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez le nombre de lignes : ");
        int lignes = scanner.nextInt();
        
        System.out.print("Entrez le nombre de colonnes : ");
        int colonnes = scanner.nextInt();
        
        int[][] matrice = new int[lignes][colonnes];
        
        // Saisie de la matrice
        System.out.println("Veuillez saisir les éléments de la matrice :");
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                System.out.print("Élément [" + i + "][" + j + "] : ");
                matrice[i][j] = scanner.nextInt();
            }
        }
        
        // Affichage de la matrice transposée (les colonnes deviennent les lignes)
        System.out.println("La matrice transposée est :");
        for (int j = 0; j < colonnes; j++) {
            for (int i = 0; i < lignes; i++) {
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
