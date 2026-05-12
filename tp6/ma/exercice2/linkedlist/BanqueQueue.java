package ma.tp6.exercice2.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

public class BanqueQueue {
    private Queue<Client> fileAttente;

    public BanqueQueue() {
        this.fileAttente = new LinkedList<>();
    }

    public void ajouterClient(Client client) {
        fileAttente.offer(client);
        System.out.println(client.getNom() + " a rejoint la file d'attente avec le billet n°" + client.getNumeroBillet() + ".");
    }

    public Client servirClient() {
        Client servi = fileAttente.poll(); // poll() retire et renvoie le premier élément de la file
        if (servi != null) {
            System.out.println("Le client " + servi.getNom() + " a été servi.");
        } else {
            System.out.println("La file d'attente est vide, personne à servir.");
        }
        return servi;
    }

    public void afficherFileAttente() {
        if (fileAttente.isEmpty()) {
            System.out.println("La file d'attente est actuellement vide.");
        } else {
            System.out.println("--- État de la file d'attente ---");
            for (Client c : fileAttente) {
                System.out.println(c);
            }
        }
    }
}
