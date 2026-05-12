package tp1.partie1_boucles;

import java.util.Scanner;

public class SommeNPremiers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez un nombre entier N : ");
        int n = scanner.nextInt();
        
        int somme = 0;
        int i = 1;
        
        // Calcul de la somme avec une boucle while
        while (i <= n) {
            somme += i;
            i++;
        }
        
        System.out.println("La somme des " + n + " premiers entiers est : " + somme);
        
        scanner.close();
    }
}
