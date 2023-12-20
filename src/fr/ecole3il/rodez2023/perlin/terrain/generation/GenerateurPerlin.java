package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.Bruit2D;
import fr.ecole3il.rodez2023.perlin.math.SuperBruitPerlin2D;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

public class GenerateurPerlin extends GenerateurCarte{

    SuperBruitPerlin2D bruitPerlinHydrometrie;
    SuperBruitPerlin2D bruitPerlinTemperature;
    SuperBruitPerlin2D bruitPerlinAltitude;

    /**
     * Constructeur du générateur de carte.
     *
     * @param graine La graine utilisée pour la génération de la carte.
     */
    public GenerateurPerlin(long graine, double resolution) {
        super(graine);
        bruitPerlinHydrometrie = new SuperBruitPerlin2D(graine,resolution);
        bruitPerlinTemperature = new SuperBruitPerlin2D(graine*2,resolution);
        bruitPerlinAltitude = new SuperBruitPerlin2D(graine*4,resolution);
    }

    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        double x = (double) i / largeur;
        double y = (double) j / hauteur;
        double hydrometrie = bruitPerlinHydrometrie.bruit2D(x, y);
        double temperature = bruitPerlinTemperature.bruit2D(x, y);
        double altitude = bruitPerlinAltitude.bruit2D(x, y);
        return new Terrain(hydrometrie,temperature,altitude);
    }
}
