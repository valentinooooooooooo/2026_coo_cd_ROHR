import donnees.CD;
import donnees.Magasin;
import static org.junit.jupiter.api.Assertions.*;
public class TestTri {

    private Magasin magasin;

    public void setUp() {
        magasin = new Magasin();
        // insertion dans un ordre non alphabetique
        magasin.ajouteCd(new CD("Radiohead",  "The Bends"));
        magasin.ajouteCd(new CD("Amon Tobin", "Bricolage"));
        magasin.ajouteCd(new CD("Daft Punk",  "Alive 2007"));
    }

    public void testTriAlbumPremierElement() {
        magasin.trierAlbum();
        assertEquals("Alive 2007", magasin.getCd(0).getNomCD(),
                "premier CD trie par album : 'Alive 2007'");
    }

    public void testTriAlbumDernierElement() {
        magasin.trierAlbum();
        assertEquals("The Bends",
                magasin.getCd(magasin.getNombreCds() - 1).getNomCD(),
                "dernier CD trie par album : 'The Bends'");
    }

    public void testTriAlbumTaille() {
        magasin.trierAlbum();
        assertEquals(3, magasin.getNombreCds(),
                "le tri ne doit pas modifier le nombre de CDs");
    }

    public void testTriArtistePremierElement() {
        magasin.trierArtiste();
        assertEquals("Amon Tobin", magasin.getCd(0).getNomArtiste(),
                "premier CD trie par artiste : 'Amon Tobin'");
    }

    public void testTriArtisteDernierElement() {
        magasin.trierArtiste();
        assertEquals("Radiohead",
                magasin.getCd(magasin.getNombreCds() - 1).getNomArtiste(),
                "dernier CD trie par artiste : 'Radiohead'");
    }

    public void testTriArtisteTaille() {
        magasin.trierArtiste();
        assertEquals(3, magasin.getNombreCds(),
                "le tri ne doit pas modifier le nombre de CDs");
    }
}