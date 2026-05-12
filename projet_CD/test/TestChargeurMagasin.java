import XML.ChargeurMagasin;
import donnees.Magasin;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;

public class TestChargeurMagasin {

    private static final String REPERTOIRE_VALIDE = "projet_CD/musicbrainzSimple/";

    private static final String REPERTOIRE_INVALIDE = "";

    public void testChargerMagasinRepertoireValide() throws Exception {
        ChargeurMagasin chargeur = new ChargeurMagasin(REPERTOIRE_VALIDE);
        Magasin magasin = assertDoesNotThrow(
                chargeur::chargerMagasin);
        assertNotNull(magasin);
        assertTrue(magasin.getNombreCds() > 0,
                "le magasin doit contenir un CD");
    }

    public void testChargerMagasinRepertoireInvalide() {
        ChargeurMagasin chargeur = new ChargeurMagasin(REPERTOIRE_INVALIDE);
        assertThrows(
                FileNotFoundException.class,
                chargeur::chargerMagasin,
                "chargerMagasin doit lever une exception pour un repertoire inexistant");
    }
}


