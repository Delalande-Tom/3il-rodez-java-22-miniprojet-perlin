import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import org.junit.Assert;
import org.junit.Test;

public class TypeTerrainTest {

    /**
     * Teste la méthode getPngName pour ocean de la classe TypeTerrain.
     */
    @Test
    public void typeTerrainGetPNGOceanTest() {
        TypeTerrain t = TypeTerrain.OCEAN;
        Assert.assertEquals(t.getPngName(),"ocean.png");
    }

    /**
     * Teste la méthode getPngName pour collines de la classe TypeTerrain.
     */
    @Test
    public void typeTerrainGetPNGCollinesTest() {
        TypeTerrain t = TypeTerrain.COLLINES;
        Assert.assertEquals(t.getPngName(),"hills.png");
    }

    /**
     * Teste la méthode getPngName pour desert de la classe TypeTerrain.
     */
    @Test
    public void typeTerrainGetPNGDesertTest() {
        TypeTerrain t = TypeTerrain.DESERT;
        Assert.assertEquals(t.getPngName(),"desert.png");
    }

    /**
     * Teste la méthode getPngName pour plaine de la classe TypeTerrain.
     */
    @Test
    public void typeTerrainGetPNGPlaineTest() {
        TypeTerrain t = TypeTerrain.PLAINE;
        Assert.assertEquals(t.getPngName(),"plain.png");
    }

    /**
     * Teste la méthode getPngName pour foret_feuillus de la classe TypeTerrain.
     */
    @Test
    public void typeTerrainGetPNGForetFeuillusTest() {
        TypeTerrain t = TypeTerrain.FORET_FEUILLUS;
        Assert.assertEquals(t.getPngName(),"deciduous_forest.png");
    }
}
