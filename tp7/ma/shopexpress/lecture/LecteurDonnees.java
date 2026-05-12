package ma.shopexpress.lecture;

public class LecteurDonnees {
    /**
     * Lit un montant à partir d'une chaîne de caractères et le convertit en double.
     * Illustre la propagation de l'erreur technique (NumberFormatException) avec le mot-clé throws.
     */
    public double lireMontant(String montantStr) throws NumberFormatException {
        // Erreur technique potentielle : la chaîne pourrait ne pas être un format numérique valide
        double montant = Double.parseDouble(montantStr);
        
        if (montant < 0) {
            // Erreur métier : On déclenche manuellement une exception si le montant est négatif
            throw new IllegalArgumentException("Le montant lu ne peut pas être négatif.");
        }
        
        return montant;
    }
}
