package tp1.partie3_matrices;

import java.util.Scanner;

public class AffichageMatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[][] matrice = new int[3][3];
        
        // Saisie de la matrice 3x3
        System.out.println("Veuillez saisir les éléments de la matrice 3x3 :");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Élément [" + i + "][" + j + "] : ");
                matrice[i][j] = scanner.nextInt();
            }
        }
        
        // Affichage de la matrice
        System.out.println("Voici la matrice saisie :");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.println(); // Retour à la ligne pour chaque nouvelle ligne
        }
        
        scanner.close();
    }
}
