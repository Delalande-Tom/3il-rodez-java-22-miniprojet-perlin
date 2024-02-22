package adaptateur;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurAleatoire;

public class GenerateurAleatoireAdaptateur extends GenerateurAleatoire {
    /**
     * Constructeur du générateur de carte.
     *
     * @param graine La graine utilisée pour la génération de la carte.
     */
    public GenerateurAleatoireAdaptateur(long graine) {
        super(graine);
    }

    public Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        return super.genererTerrain(i, j, largeur, hauteur);
    }
}
