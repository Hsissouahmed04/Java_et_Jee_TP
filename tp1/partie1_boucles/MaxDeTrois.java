package tp1.partie1_boucles;

import java.util.Scanner;

public class MaxDeTrois {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez le premier nombre : ");
        int nb1 = scanner.nextInt();
        
        System.out.print("Entrez le deuxième nombre : ");
        int nb2 = scanner.nextInt();
        
        System.out.print("Entrez le troisième nombre : ");
        int nb3 = scanner.nextInt();
        
        // Initialisation du max avec le premier nombre
        int max = nb1;
        
        // Comparaison avec les autres nombres
        if (nb2 > max) {
            max = nb2;
        }
        if (nb3 > max) {
            max = nb3;
        }
        
        System.out.println("Le maximum est : " + max);
        
        scanner.close();
    }
}
