package ma.plateforme.entities.interfaces;

public interface Reducible {
    /**
     * Applique une réduction sur le prix.
     * @param pourcentage Le pourcentage de réduction (ex: 20 pour 20%)
     * @return true si la réduction a été appliquée, false sinon.
     */
    boolean appliquerReduction(double pourcentage);
}
