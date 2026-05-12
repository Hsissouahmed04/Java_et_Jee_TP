package ma.shopexpress.ressources;

public class GestionTransactions {
    private String[] transactions;

    public GestionTransactions(String[] transactions) {
        this.transactions = transactions;
    }

    /**
     * Lit une transaction à partir du tableau par son index.
     * Utilise un multi-catch pour gérer les exceptions techniques spécifiques.
     */
    public void lireTransaction(int index) {
        try {
            // Peut déclencher une NullPointerException si this.transactions est null
            // Peut déclencher une ArrayIndexOutOfBoundsException si l'index est invalide
            String transaction = transactions[index];
            
            // On vérifie en plus si l'élément lui-même est null pour générer l'exception
            if (transaction == null) {
                throw new NullPointerException("La transaction à l'index " + index + " est null.");
            }
            
            System.out.println("Transaction lue : " + transaction.length() + " caractères.");
            
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            // Erreurs techniques : accès en dehors des limites ou référence nulle
            System.err.println("Erreur technique rencontrée : " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
