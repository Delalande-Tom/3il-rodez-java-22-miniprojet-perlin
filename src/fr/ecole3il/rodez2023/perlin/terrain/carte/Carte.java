package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.terrain.carte.TerrainInexistant;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;

import java.util.Scanner;

public class Carte {

    private String nom;
    private int largeur;
    private int hauteur;
    private Terrain[][] terrains;


    /**
     * Constructeur de la classe Carte.
     * @param nom Le nom de la carte.
     * @param largeur La largeur de la carte.
     * @param hauteur La hauteur de la carte.
     * @param generateurCarte Le générateur de carte utilisé pour générer la carte.
     */
    public Carte(String nom, int largeur, int hauteur, GenerateurCarte generateurCarte) {
        this.nom = nom;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.terrains = generateurCarte.genererCarte(largeur, hauteur);
    }

    /**
     * Constructeur de la classe Carte pour carte existante.
     * @param donneesCarte Les données de la carte.
     */
    public Carte (String donneesCarte){
        Scanner scanner = new Scanner(donneesCarte);
        this.nom = scanner.nextLine();
        this.largeur = scanner.nextInt();
        this.hauteur = scanner.nextInt();
        this.terrains = new Terrain[largeur][hauteur];
        // Écriture des éléments de terrain
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                String[] tabAltHydTemp = scanner.nextLine().split(" ");
                terrains[x][y] = new Terrain(Double.parseDouble(tabAltHydTemp[0]),Double.parseDouble(tabAltHydTemp[1]),Double.parseDouble(tabAltHydTemp[2]));
            }
        }
        scanner.close();
    }

    /**
     * Récupère le nom de la carte.
     * @return  Le nom de la carte.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Récupère la largeur de la carte.
     * @return La largeur de la carte.
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Récupère la hauteur de la carte.
     * @return La hauteur de la carte.
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Récupère le terrain aux coordonnées spécifiées.
     * @param x La coordonnée x du terrain.
     * @param y La coordonnée y du terrain.
     * @return Le terrain aux coordonnées spécifiées.
     */
    public Terrain getTerrain(int x, int y) {
        if (x < 0 || x >= largeur || y < 0 || y >= hauteur) {
            throw new TerrainInexistant();
        }
        return terrains[x][y];
    }
}
