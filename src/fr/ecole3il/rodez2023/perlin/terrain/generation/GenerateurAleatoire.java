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
        Random randomHydrometrie = new Random(graine);
        Random randomTemperature = new Random(graine*2);
        Random randomAltitude = new Random(graine*4);
    }

    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        return new Terrain(randomHydrometrie.nextDouble(),randomTemperature.nextDouble(),randomAltitude.nextDouble());
    }
}
