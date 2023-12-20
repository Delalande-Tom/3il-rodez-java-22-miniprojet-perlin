package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

public class Terrain {

    private double altitude;
    private double hydrometrie;
    private double temperature;

    /**
     * Constructeur de la classe Terrain.
     *
     * @param altitude    L'altitude du terrain.
     * @param hydrometrie L'hydrométrie du terrain.
     * @param temperature La température du terrain.
     */
    public Terrain(double altitude, double hydrometrie, double temperature) throws MauvaiseValeurException {
        if (hydrometrie > 1 || hydrometrie < 0 || temperature > 1 || temperature < 0 ||altitude < -1 || altitude >1 ) {
            throw new MauvaiseValeurException();
        }
        this.altitude = altitude;
        this.hydrometrie = hydrometrie;
        this.temperature = temperature;
    }

    /**
     * Récupère l'altitude du terrain.
     *
     * @return L'altitude du terrain.
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * Récupère l'hydrométrie du terrain.
     *
     * @return L'hydrométrie du terrain.
     */
    public double getHydrometrie() {
        return hydrometrie;
    }

    /**
     * Récupère la température du terrain.
     *
     * @return La température du terrain.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Récupère le type de terrain.
     *
     * @return Le type de terrain.
     */
    public TypeTerrain getTypeTerrain(DetermineurTerrain dt) {
        return dt.determinerTerrain(this.altitude,this.hydrometrie,this.temperature);
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public void setHydrometrie(double hydrometrie) {
        this.hydrometrie = hydrometrie;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}

