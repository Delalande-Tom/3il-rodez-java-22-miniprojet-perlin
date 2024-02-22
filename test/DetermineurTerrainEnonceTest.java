import fr.ecole3il.rodez2023.perlin.terrain.concrets.DetermineurTerrainEnonce;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DetermineurTerrainEnonceTest {

    @Test
    public void creeOceanTest(){
        DetermineurTerrainEnonce d = new DetermineurTerrainEnonce();
        assertEquals(d.determinerTerrain(-1, 0.3, 0.6), TypeTerrain.OCEAN);
    }

    @Test
    public void creePlaineTest(){
        DetermineurTerrainEnonce d = new DetermineurTerrainEnonce();
        assertEquals(d.determinerTerrain(0.5, 0.2, 0.2), TypeTerrain.PLAINE);
    }

    @Test
    public void creeForetFeuillusTest(){
        DetermineurTerrainEnonce d = new DetermineurTerrainEnonce();
        assertEquals(d.determinerTerrain(0.5, 0.2, 0.5), TypeTerrain.FORET_FEUILLUS);
    }

    @Test
    public void creeToundraTest(){
        DetermineurTerrainEnonce d = new DetermineurTerrainEnonce();
        assertEquals(d.determinerTerrain(0.5, 0.2, 0.8), TypeTerrain.TOUNDRA);
    }

    @Test
    public void creeForetConiferesTest(){
        DetermineurTerrainEnonce d = new DetermineurTerrainEnonce();
        assertEquals(d.determinerTerrain(0.5, 0.3, 0.5), TypeTerrain.FORET_CONIFÈRES);
    }

    @Test
    public void creeMontagneTest(){
        DetermineurTerrainEnonce d = new DetermineurTerrainEnonce();
        assertEquals(d.determinerTerrain(0.5, 0.3, 0.8), TypeTerrain.MONTAGNE);
    }

    @Test
    public void creeDesertTest(){
        DetermineurTerrainEnonce d = new DetermineurTerrainEnonce();
        assertEquals(d.determinerTerrain(0.5, 0.4, 0.2), TypeTerrain.DESERT);
    }

    @Test
    public void creeCollinesTest(){
        DetermineurTerrainEnonce d = new DetermineurTerrainEnonce();
        assertEquals(d.determinerTerrain(0.5, 0.4, 0.5), TypeTerrain.COLLINES);
    }

    @Test
    public void creeMaraisTest(){
        DetermineurTerrainEnonce d = new DetermineurTerrainEnonce();
        assertEquals(d.determinerTerrain(0.5, 0.6, 0.2), TypeTerrain.MARAIS);
    }

}
