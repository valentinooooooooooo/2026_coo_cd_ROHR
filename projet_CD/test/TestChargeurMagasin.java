import XML.ChargeurMagasin;
import donnees.Magasin;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;

public class TestChargeurMagasin {

    private static final String REPERTOIRE_VALIDE = "../magasinCD_donnees/musicbrainzSimple/";

    private static final String REPERTOIRE_INVALIDE = "repertoire_qui_nexiste_pas_xyz/";

    public void testChargerMagasinRepertoireValide() throws Exception {
        ChargeurMagasin chargeur = new ChargeurMagasin(REPERTOIRE_VALIDE);
        Magasin magasin = assertDoesNotThrow(
                chargeur::chargerMagasin,
                "chargerMagasin ne doit pas lever d'exception avec un repertoire valide");
        assertNotNull(magasin,
                "le magasin retourne ne doit pas etre null");
        assertTrue(magasin.getNombreCds() > 0,
                "le magasin doit contenir au moins un CD");
    }

    public void testChargerMagasinRepertoireInvalide() {
        ChargeurMagasin chargeur = new ChargeurMagasin(REPERTOIRE_INVALIDE);
        assertThrows(
                FileNotFoundException.class,
                chargeur::chargerMagasin,
                "chargerMagasin doit lever FileNotFoundException pour un repertoire inexistant");
    }
}


