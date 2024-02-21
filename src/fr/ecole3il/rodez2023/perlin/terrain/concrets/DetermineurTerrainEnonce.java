package fr.ecole3il.rodez2023.perlin.terrain.concrets;

import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

public class DetermineurTerrainEnonce implements DetermineurTerrain {

	/**
	 * Méthode permettant de déterminer le type de terrain en fonction de l'altitude,
	 * de l'hydrométrie et de la température.
	 *
	 * @param altitude     L'altitude du terrain.
	 * @param hydrometrie  L'hydrométrie du terrain.
	 * @param temperature  La température du terrain.
	 * @return Le type de terrain correspondant.
	 */
	@Override
	public TypeTerrain determinerTerrain(double altitude, double hydrometrie, double temperature) {
		if (altitude < 0) {
			return TypeTerrain.OCEAN;
		} else if (hydrometrie <= 0.25) {
			if (altitude <= 0.7) {
				if (temperature <= 0.25) {
					return TypeTerrain.PLAINE;
				} else if (temperature <= 0.7) {
					return TypeTerrain.FORET_FEUILLUS;
				} else {
					return TypeTerrain.TOUNDRA;
				}
			} else {
				if (temperature <= 0.25) {
					return TypeTerrain.PLAINE;
				} else if (temperature <= 0.7) {
					return TypeTerrain.FORET_CONIFÈRES;
				} else {
					return TypeTerrain.MONTAGNE;
				}
			}
		} else {
			if (altitude <= 0.7) {
				if (temperature <= 0.25) {
					return TypeTerrain.DESERT;
				} else if (temperature <= 0.7) {
					return TypeTerrain.COLLINES;
				} else {
					return TypeTerrain.MONTAGNE;
				}
			} else {
				if (temperature <= 0.25) {
					return TypeTerrain.MARAIS;
				} else if (temperature <= 0.7) {
					return TypeTerrain.FORET_CONIFÈRES;
				} else {
					return TypeTerrain.MONTAGNE;
				}
			}
		}
	}

}
