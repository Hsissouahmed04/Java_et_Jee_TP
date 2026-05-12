package tp1.partie4_string;

import java.util.Scanner;

public class LongueurChaine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez une chaîne de caractères : ");
        String chaine = scanner.nextLine();
        
        // Utilisation de la méthode length() pour obtenir la longueur
        int longueur = chaine.length();
        
        System.out.println("La longueur de la chaîne est : " + longueur);
        
        scanner.close();
    }
}
