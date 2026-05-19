import donnees.*;

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
        magasin.trier(new ComparateurAlbum());
        assertEquals("Alive 2007", magasin.getCd(0).getNomCD(), "premier CD trie par album est Alive 2007");
    }

    public void testTriAlbumDernierElement() {
        magasin.trier(new ComparateurAlbum());
        assertEquals("The Bends",
                magasin.getCd(magasin.getNombreCds()-1).getNomCD(),"dernier CD trie par album est The Bends");
    }

    public void testTriAlbumTaille() {
        magasin.trier(new ComparateurAlbum());
        assertEquals(3, magasin.getNombreCds(),"le tri ne doit pas modifier le nombre de CD normalement");
    }

    public void testTriArtistePremierElement() {
        magasin.trier(new ComparateurArtiste());
        assertEquals("Amon Tobin", magasin.getCd(0).getNomArtiste(),"premier CD trie par artiste est Amon Tobin");
    }

    public void testTriArtisteDernierElement() {
        magasin.trier(new ComparateurArtiste());
        assertEquals("Radiohead",
                magasin.getCd(magasin.getNombreCds() -1).getNomArtiste(),"dernier CD trie par artiste est Radiohead");
    }

    public void testTriArtisteTaille() {
        magasin.trier(new ComparateurArtiste());
        assertEquals(3,magasin.getNombreCds());
    }

    public void testTriAvecClassAnonyme(){
        magasin.trier((cd1,cd2)-> cd1.getNomArtiste().compareToIgnoreCase(cd2.getNomArtiste())>0);
        assertEquals("Radiohead",magasin.getCd(0).getNomArtiste(),"maintenant l'ordre est inverse");
    }
}