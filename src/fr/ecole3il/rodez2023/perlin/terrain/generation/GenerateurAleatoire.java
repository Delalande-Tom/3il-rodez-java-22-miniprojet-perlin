package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

import java.util.Random;

public class GenerateurAleatoire extends  GenerateurCarte{
    Random randomHydrometrie;
    Random randomTemperature;
    Random randomAltitude;
        /**
     * Constructeur du générateur de carte.
     *
     * @param graine La graine utilisée pour la génération de la carte.
     */
    public GenerateurAleatoire(long graine) {
        super(graine);
        this.randomHydrometrie = new Random(graine);
        this.randomTemperature = new Random(graine*2);
        this.randomAltitude = new Random(graine*4);
    }

    /**
     * Génère un terrain aléatoire.
     * @param i        La position verticale dans la carte.
     * @param j        La position horizontale dans la carte.
     * @param largeur  La largeur totale de la carte.
     * @param hauteur  La hauteur totale de la carte.
     * Tout c'est paramètre ne sont pas utilisé dans cette méthode.
     * @return La valeur de retour est un terrain généré aléatoirement.
     */
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        return new Terrain(randomHydrometrie.nextDouble(),randomTemperature.nextDouble(),randomAltitude.nextDouble());
    }
}
