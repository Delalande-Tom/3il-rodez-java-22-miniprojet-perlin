package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.Utils;

import java.awt.image.BufferedImage;

public enum TypeTerrain {

    COLLINES("Hills"), DESERT("Desert"),OCEAN("Ocean"), PLAINE("Plain"), FORET_FEUILLUS("Deciduous Forest"), TOUNDRA("Tundra"), FORET_CONIFÈRES("Coniferous Forest"), MONTAGNE("Mountain"), MARAIS("Marsh");

    private String nom;

    /**
     * Constructeur de la classe TypeTerrain.
     * @param nom Le nom du type de terrain.
     */
    TypeTerrain(String nom) {
        this.nom = nom;
    }

    /**
     * Récupère le nom du type de terrain.
     * @return Le nom du type de terrain.
     */
    public String toString() {
        return nom;
    }

    /**
     * Récupère une image représentant le type de terrain.
     *
     * @return Une image représentant le type de terrain.
     */
    public BufferedImage getImage() {
        return Utils.chargerTuile(nom.toLowerCase().replace(" ","_") + ".png");
    }





}
