import fr.ecole3il.rodez2023.perlin.math.SuperBruitPerlin2D;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class SuperBruitPerlin2DTest {

    @Test
    public void valeurCompriseEntreMoinsUnEtUn() {
        SuperBruitPerlin2D bruit = new SuperBruitPerlin2D(151452121,1);
        for (int i = 0; i < 1000; i++) {
            assertTrue(bruit.bruit2D(i, i) >= -1 && bruit.bruit2D(i, i) <= 1);

        }
    }

}
