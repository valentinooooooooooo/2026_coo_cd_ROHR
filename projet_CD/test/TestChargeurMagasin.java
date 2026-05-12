import XML.ChargeurMagasin;
import donnees.Magasin;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;

public class TestChargeurMagasin {

    private static final String REPERTOIRE_VALIDE = "projet_CD/musicbrainzSimple/";
    private static final String REPERTOIRE_INVALIDE = "";

    public void testRepertoireValide() throws Exception {
        ChargeurMagasin chargeur = new ChargeurMagasin(REPERTOIRE_VALIDE);
        Magasin magasin = chargeur.chargerMagasin();
        assertNotNull(magasin);
        assertTrue(magasin.getNombreCds() > 0);
    }

    public void testRepertoireInvalide() {
        ChargeurMagasin chargeur = new ChargeurMagasin(REPERTOIRE_INVALIDE);
        assertThrows(FileNotFoundException.class, chargeur::chargerMagasin);
    }
}


