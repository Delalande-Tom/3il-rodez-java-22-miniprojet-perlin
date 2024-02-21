import fr.ecole3il.rodez2023.perlin.terrain.elements.MauvaiseValeurException;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class TerrainTest {

    /**
     * Teste la création d'un terrain avec des valeurs altitude invalides.
     */
    @Test
    public void creeTerrainInvalideAltitudeTest() {
        assertThrows(MauvaiseValeurException.class, () -> {
            Terrain t = new Terrain(10, 0.3, 0.6);
        });
    }

    /**
     * Teste la création d'un terrain avec des valeurs hydrométrie invalides.
     */
    @Test
    public void creeTerrainInvalideHydrometrieTest() {
        assertThrows(MauvaiseValeurException.class, () -> {
            Terrain t = new Terrain(10, 0.5, 0.5);
        });
    }

    /**
     * Teste la création d'un terrain avec des valeurs température invalides.
     */
    @Test
    public void creeTerrainInvalideTemperatureTest() {
        assertThrows(MauvaiseValeurException.class, () -> {
            Terrain t = new Terrain(0.5, 0.5,5 );
        });
    }

    /**
     * Teste la création d'un terrain avec des valeurs valides.
     */
    @Test
    public void creeTerrainValideTest() {
       Terrain t = new Terrain(0.5, 0.5, 0.5);
    }

}
