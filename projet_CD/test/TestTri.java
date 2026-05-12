import donnees.CD;
import donnees.ComparateurCd;
import donnees.Magasin;
import static org.junit.jupiter.api.Assertions.*;
public class TestTri {

    private Magasin magasin;

    public void setUp() {
        magasin = new Magasin();
        magasin.ajouteCd(new CD("Radiohead","The Bends"));
        magasin.ajouteCd(new CD("Amon Tobin","Bricolage"));
        magasin.ajouteCd(new CD("Daft Punk","Alive 2007"));
    }

    public void testTriAlbumPremierElement() {
        magasin.trier();
        assertEquals("Alive 2007", magasin.getCd(0).getNomCD(),
                "premier CD trie par album est Alive 2007");
    }

    public void testTriAlbumDernierElement() {
        magasin.trier();
        assertEquals("The Bends",
                magasin.getCd(magasin.getNombreCds() - 1).getNomCD(),
                "dernier CD trie par album est The Bends");
    }

    public void testTriAlbumTaille() {
        magasin.trier();
        assertEquals(3, magasin.getNombreCds(),
                "le tri ne doit pas modifier le nombre de CD normalement");
    }

    public void testTriArtistePremierElement() {
        magasin.trier();
        assertEquals("Amon Tobin", magasin.getCd(0).getNomArtiste(),
                "premier CD trie par artiste est Amon Tobin");
    }

    public void testTriArtisteDernierElement() {
        magasin.trier();
        assertEquals("Radiohead",
                magasin.getCd(magasin.getNombreCds() - 1).getNomArtiste(),
                "dernier CD trie par artiste est Radiohead");
    }

    public void testTriArtisteTaille() {
        magasin.trier(new ComparateurCd() {
            @Override
            public boolean etreAvant(CD cd1, CD cd2) {
                return false;
            }
        });
        assertEquals(magasin.getNombreCds());
    }
}