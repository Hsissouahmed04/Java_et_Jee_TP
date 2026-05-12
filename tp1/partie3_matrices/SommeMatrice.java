package tp1.partie3_matrices;

import java.util.Scanner;

public class SommeMatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez le nombre de lignes : ");
        int lignes = scanner.nextInt();
        
        System.out.print("Entrez le nombre de colonnes : ");
        int colonnes = scanner.nextInt();
        
        int[][] matrice = new int[lignes][colonnes];
        long somme = 0;
        
        // Saisie de la matrice et calcul de la somme
        System.out.println("Veuillez saisir les éléments de la matrice :");
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                System.out.print("Élément [" + i + "][" + j + "] : ");
                matrice[i][j] = scanner.nextInt();
                somme += matrice[i][j]; // Ajout direct à la somme
            }
        }
        
        System.out.println("La somme des éléments de la matrice est : " + somme);
        
        scanner.close();
    }
}
