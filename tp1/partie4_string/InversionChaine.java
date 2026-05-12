package tp1.partie4_string;

import java.util.Scanner;

public class InversionChaine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez une chaîne de caractères : ");
        String chaine = scanner.nextLine();
        
        String chaineInverse = "";
        
        // Construction de la chaîne inversée
        for (int i = chaine.length() - 1; i >= 0; i--) {
            chaineInverse += chaine.charAt(i);
        }
        
        System.out.println("La chaîne inversée est : " + chaineInverse);
        
        scanner.close();
    }
}
