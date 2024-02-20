package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.Bruit2D;
import fr.ecole3il.rodez2023.perlin.math.SuperBruitPerlin2D;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

public class GenerateurPerlin extends GenerateurCarte{

    Bruit2D bruitPerlinHydrometrie;
    Bruit2D bruitPerlinTemperature;
    Bruit2D bruitPerlinAltitude;

    /**
     * Constructeur du générateur de carte.
     *
     * @param graine La graine utilisée pour la génération de la carte.
     * @param resolution La résolution de la carte.
     */
    public GenerateurPerlin(long graine, double resolution) {
        super(graine);
        bruitPerlinHydrometrie = new SuperBruitPerlin2D(graine,resolution);
        bruitPerlinTemperature = new SuperBruitPerlin2D(graine*2,resolution);
        bruitPerlinAltitude = new SuperBruitPerlin2D(graine*4,resolution);
    }

    /**
     * Constructeur du générateur de carte.
     *
     * @param graine La graine utilisée pour la génération de la carte.
     */
    public GenerateurPerlin(long graine) {
        super(graine);
        bruitPerlinHydrometrie = new SuperBruitPerlin2D(graine,1);
        bruitPerlinTemperature = new SuperBruitPerlin2D(graine*2,1);
        bruitPerlinAltitude = new SuperBruitPerlin2D(graine*4,1);
    }

    /**
     * Méthode permettant de générer un terrain pour les coordonnées fournies.
     * @param i La coordonnée x pour laquelle générer le terrain.
     * @param j La coordonnée y pour laquelle générer le terrain.
     * @param largeur La largeur de la carte.
     * @param hauteur La hauteur de la carte.
     * @return Le terrain généré pour les coordonnées fournies.
     */
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        double x = (double) i / largeur;
        double y = (double) j / hauteur;
        double hydrometrie = bruitPerlinHydrometrie.bruit2D(x, y);
        double temperature = bruitPerlinTemperature.bruit2D(x, y);
        //récupération des valeurs absolues pour éviter les valeurs négatives.
        hydrometrie = Math.abs(hydrometrie);
        temperature = Math.abs(temperature);

        double altitude = bruitPerlinAltitude.bruit2D(x, y);
        return new Terrain(hydrometrie,temperature,altitude);
    }
}
