package ma.shopexpress.paiement;

public class ServicePaiement {
    /**
     * Effectue un paiement en vérifiant les règles métier.
     * Utilise un bloc try/catch/finally pour gérer les erreurs et assurer la clôture.
     */
    public void effectuerPaiement(double montant, double solde) {
        try {
            // Déclenchement manuel d'exceptions métier
            if (montant < 0) {
                // Erreur métier : Règle de gestion non respectée
                throw new IllegalArgumentException("Le montant du paiement ne peut pas être négatif.");
            }
            if (montant > solde) {
                // Erreur métier : Règle de gestion non respectée (Solde insuffisant)
                throw new IllegalStateException("Solde insuffisant pour effectuer le paiement de " + montant + " DH.");
            }
            System.out.println("Paiement de " + montant + " DH effectué avec succès. Nouveau solde : " + (solde - montant) + " DH.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            // Interception des erreurs métier
            System.err.println("Erreur de paiement : " + e.getMessage());
        } finally {
            // Ce bloc s'exécute toujours, qu'il y ait eu une exception ou non
            System.out.println("Fin de la transaction");
        }
    }
}
