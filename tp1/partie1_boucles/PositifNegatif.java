package tp1.partie1_boucles;

import java.util.Scanner;

public class PositifNegatif {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez un nombre : ");
        int nombre = scanner.nextInt();
        
        // Vérification si le nombre est positif, négatif ou nul
        if (nombre > 0) {
            System.out.println("Le nombre est positif.");
        } else if (nombre < 0) {
            System.out.println("Le nombre est négatif.");
        } else {
            System.out.println("Le nombre est nul.");
        }
        
        scanner.close();
    }
}
