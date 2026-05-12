package tp1.partie1_boucles;

import java.util.Scanner;

public class TableMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez un nombre pour afficher sa table de multiplication : ");
        int nombre = scanner.nextInt();
        
        // Affichage de la table de 1 à 10
        for (int i = 1; i <= 10; i++) {
            System.out.println(nombre + " x " + i + " = " + (nombre * i));
        }
        
        scanner.close();
    }
}
