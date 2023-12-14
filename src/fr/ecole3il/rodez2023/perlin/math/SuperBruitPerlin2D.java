package fr.ecole3il.rodez2023.perlin.math;

public class SuperBruitPerlin2D extends Bruit2D{
    // Vecteurs de gradient pour le bruit de Perlin
    private static final double[][] GRADIENT_2D = { { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 }, { 1, 0 }, { -1, 0 },
        { 0, 1 }, { 0, -1 } };

    // Tableau de PERMUTATIONs pour le bruit de Perlin
    private static final int[] PERMUTATION = { 151, 160, 137, 91, 90, 15, 131, 13, 201, 95, 96, 53, 194, 233, 7, 225,
        140, 36, 103, 30, 69, 142, 8, 99, 37, 240, 21, 10, 23, 190, 6, 148, 247, 120, 234, 75, 0, 26, 197, 62, 94,
        252, 219, 203, 117, 35, 11, 32, 57, 177, 33, 88, 237, 149, 56, 87, 174, 20, 125, 136, 171, 168, 68, 175, 74,
        165, 71, 134, 139, 48, 27, 166, 77, 146, 158, 231, 83, 111, 229, 122, 60, 211, 133, 230, 220, 105, 92, 41,
        55, 46, 245, 40, 244, 102, 143, 54, 65, 25, 63, 161, 1, 216, 80, 73, 209, 76, 132, 187, 208, 89, 18, 169,
        200, 196, 135, 130, 116, 188, 159, 86, 164, 100, 109, 198, 173, 186, 3, 64, 52, 217, 226, 250, 124, 123, 5,
        202, 38, 147, 118, 126, 255, 82, 85, 212, 207, 206, 59, 227, 47, 16, 58, 17, 182, 189, 28, 42, 223, 183,
        170, 213, 119, 248, 152, 2, 44, 154, 163, 70, 221, 153, 101, 155, 167, 43, 172, 9, 129, 22, 39, 253, 19, 98,
        108, 110, 79, 113, 224, 232, 178, 185, 112, 104, 218, 246, 97, 228, 251, 34, 242, 193, 238, 210, 144, 12,
        191, 179, 162, 241, 81, 51, 145, 235, 249, 14, 239, 107, 49, 192, 214, 31, 181, 199, 106, 157, 184, 84, 204,
        176, 115, 121, 50, 45, 127, 4, 150, 254, 138, 236, 205, 93, 222, 114, 67, 29, 24, 72, 243, 141, 128, 195,
        78, 66, 215, 61, 156, 180 };

    public SuperBruitPerlin2D(long graine, double resolution) {
        super(graine, resolution);
    }

    /**
     * Méthode permettant d'obtenir la valeur de bruit en 2D pour les coordonnées fournies.
     * @param x Coordonnée x pour laquelle obtenir le bruit.
     * @param y Coordonnée y pour laquelle obtenir le bruit.
     * @return La valeur de bruit en 2D pour les coordonnées fournies.
     */
    @Override
    public double bruit2D(double x, double y) {
        int x0, y0, indexX, indexY, gradientIndex0, gradientIndex1, gradientIndex2, gradientIndex3;
        double deltaX,deltaY, s, t, u, v, Cx, Cy, Li1, Li2;

        // Récupère les coordonnées entières du point
        x0 = getCoordinate(x);
        y0 = getCoordinate(y);

        // Masquage pour récupérer les indices de PERMUTATION
        indexX = x0 & 255;
        indexY = y0 & 255;

        // Récupérer les indices de gradient associés aux coins du quadrilatère
        gradientIndex0 = PERMUTATION[indexX + PERMUTATION[indexY]] % 8;
        gradientIndex1 = PERMUTATION[indexX + 1 + PERMUTATION[indexY]] % 8;
        gradientIndex2 = PERMUTATION[indexX + PERMUTATION[indexY + 1]] % 8;
        gradientIndex3 = PERMUTATION[indexX + 1 + PERMUTATION[indexY + 1]] % 8;

        // Récupérer les vecteurs de gradient et effectuer des interpolations pondérées
        s = produitScalaire(GRADIENT_2D[gradientIndex0],x - x0,y - y0);

        t = produitScalaire(GRADIENT_2D[gradientIndex1],x - (x0 + 1),y - y0);

        u = produitScalaire(GRADIENT_2D[gradientIndex2],x - x0,y - (y0 + 1));

        v = produitScalaire(GRADIENT_2D[gradientIndex3],x - (x0 + 1),y - (y0 + 1));

        // Interpolations pour lisser les valeurs obtenues
        deltaX = x - x0;
        Cx = 3 * deltaX * deltaX - 2 * deltaX * deltaX * deltaX;

        deltaY = y - y0;
        Cy = 3 * deltaY * deltaY - 2 * deltaY * deltaY * deltaY;

        return interpolation(Cy,interpolation(Cx,s,t),interpolation(Cx,u,v));
    }

    /**
     * Méthode interne utilisée pour obtenir la coordonnée adapter à la résolution entière d'une variable.
     * @param variable La variable pour laquelle obtenir la coordonnée.
     * @return La coordonnée entière de la variable.
     */
    private int getCoordinate( double variable ) {
        return (int) (variable/this.getResolution());
    }

    /**
     * * Méthode interne utilisée pour obtenir le produit scalaire entre un vecteur et des coordonnées.
     * @param vecteur Le vecteur de gradient.
     * @param x coordonnée x pour laquelle obtenir le bruit.
     * @param y coordonnée y pour laquelle obtenir le bruit.
     * @return La valeur de bruit en 2D pour les coordonnées fournies.
     */
    private double produitScalaire(double[] vecteur, double x, double y){
        return vecteur[0]*x + vecteur[1]*y;
    }

    /**
     * Méthode interne utilisée pour lisser les valeurs obtenues.
     * @param t La valeur à lisser.
     * @return La valeur lissée.
     */
    private double lissage(double t){
        return 6*t*t*t*t*t - 5*t*t*t*t;
    }

    /**
     * Méthode interne utilisée pour interpoler les valeurs obtenues.
     * @param t La valeur à interpoler.
     * @param a le paramètre a de l'interpolation.
     * @param b le paramètre b de l'interpolation.
     * @return La valeur interpolée.
     */
    private double interpolation(double t, double a, double b){
        return a + t*(b-a);
    }


}

