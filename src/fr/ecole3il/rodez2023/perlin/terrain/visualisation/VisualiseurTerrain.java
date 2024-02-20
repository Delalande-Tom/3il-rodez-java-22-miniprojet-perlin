package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;

public class VisualiseurTerrain {

    private final Carte carte;
    private DetermineurTerrain determineurTerrain;

    public VisualiseurTerrain(DetermineurTerrain determineurTerrain,Carte carte) {
        this.carte = carte;
        this.determineurTerrain = determineurTerrain;
    }

    public HydrometrieAffichee getHydrometrieAffichee(int x, int y) {
        double hydrometrie = carte.getTerrain(x, y).getHydrometrie();
        if (hydrometrie < 0.33) {
            return HydrometrieAffichee.SEC;
        } else if (hydrometrie < 0.66) {
            return HydrometrieAffichee.MOYEN;
        } else {
            return HydrometrieAffichee.HUMIDE;
        }
    }

    public AltitudeAffichee getAltitudeAffichee(int x, int y) {
        double altitude = carte.getTerrain(x, y).getAltitude();
        if (altitude < 0){
            return AltitudeAffichee.FondMarin;
        }
        else if (altitude < 0.33) {
            return AltitudeAffichee.BASSE;
        } else if (altitude < 0.66) {
            return AltitudeAffichee.MOYENNE;
        } else {
            return AltitudeAffichee.ELVEE;
        }
    }

    public TemperatureAffichee getTemperatureAffichee(int x, int y) {
        double temperature = carte.getTerrain(x, y).getTemperature();
        if (temperature < 0.33) {
            return TemperatureAffichee.FROID;
        } else if (temperature < 0.66) {
            return TemperatureAffichee.TEMPERE;
        } else {
            return TemperatureAffichee.CHAUD;
        }
    }

    public TypeTerrain getTypeTerrain(int x, int y) {
        return carte.getTerrain(x, y).getTypeTerrain(determineurTerrain);
    }
}
