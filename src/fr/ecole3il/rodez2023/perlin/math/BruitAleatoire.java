package fr.ecole3il.rodez2023.perlin.math;

import java.util.Random;

/**
 * La classe BruitAleatoire étend la classe Bruit2D et génère du bruit aléatoire en deux dimensions.
 * Elle utilise la classe Random de Java pour générer des valeurs aléatoires.
 */
public class BruitAleatoire extends Bruit2D {

    Random random;

    /**
     * Constructeur de la classe Bruit Aléatoire.
     * @param graine La graine utilisée pour initialiser le générateur de bruit.
     * @param resolution La résolution utilisée pour la génération du bruit.
     */
    public BruitAleatoire(long graine, double resolution) {
        super(graine,resolution);
        random = new Random(graine);

    }

    /**
     * Génère une valeur de bruit aléatoire en deux dimensions.
     * @param x La coordonnée x.
     * @param y La coordonnée y.
     * @return La valeur de bruit aléatoire en deux dimensions.
     */
    @Override
    public double bruit2D(double x, double y) {
        return random.nextDouble();
    }

}
