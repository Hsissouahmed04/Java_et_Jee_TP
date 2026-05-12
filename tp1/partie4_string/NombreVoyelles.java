package tp1.partie4_string;

import java.util.Scanner;

public class NombreVoyelles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez une chaîne de caractères : ");
        String chaine = scanner.nextLine().toLowerCase(); // Conversion en minuscules pour faciliter le comptage
        
        int compteurVoyelles = 0;
        
        // Parcours de la chaîne caractère par caractère
        for (int i = 0; i < chaine.length(); i++) {
            char c = chaine.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
                compteurVoyelles++;
            }
        }
        
        System.out.println("Le nombre de voyelles dans la chaîne est : " + compteurVoyelles);
        
        scanner.close();
    }
}
