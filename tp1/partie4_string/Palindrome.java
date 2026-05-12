package tp1.partie4_string;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez un mot : ");
        String mot = scanner.nextLine().toLowerCase(); // On ignore la casse
        
        boolean estPalindrome = true;
        int longueur = mot.length();
        
        // On compare les caractères des extrémités vers le centre
        for (int i = 0; i < longueur / 2; i++) {
            if (mot.charAt(i) != mot.charAt(longueur - 1 - i)) {
                estPalindrome = false;
                break;
            }
        }
        
        if (estPalindrome) {
            System.out.println("Le mot est un palindrome.");
        } else {
            System.out.println("Le mot n'est pas un palindrome.");
        }
        
        scanner.close();
    }
}
