package fr.ecole3il.rodez2023.perlin.terrain.concrets;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.VisualiseurTerrain;

public class VisualiseurTerrainEnonce extends VisualiseurTerrain {
	/**
	 * Constructeur de la classe VisualiseurTerrainEnonce.
	 *
	 * @param c La carte à visualiser.
	 */
	public VisualiseurTerrainEnonce(Carte c) {

		super(new DetermineurTerrainEnonce(), c);

	}

}
