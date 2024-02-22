
import adaptateur.GenerateurAleatoireAdaptateur;
import org.junit.Test;
public class GenerateurAleatoireTest {

    @Test
    public void testGenererTerrain() {
        GenerateurAleatoireAdaptateur generateur = new GenerateurAleatoireAdaptateur(System.currentTimeMillis());
        generateur.genererTerrain(0, 0, 0, 0);

    }
}
