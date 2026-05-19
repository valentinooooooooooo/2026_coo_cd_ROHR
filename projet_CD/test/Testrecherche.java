import donnees.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testrecherche {

    private Magasin magasin;

    public void setUp() {
        magasin = new Magasin();
        magasin.ajouteCd(new CD("Radiohead","The Bends"));
        magasin.ajouteCd(new CD("Amon Tobin","Bricolage"));
        magasin.ajouteCd(new CD("Daft Punk","Alive 2007"));
    }

    public void testRechercheArtisteTrouve() {
        ArrayList<CD> resultat = magasin.rechercher(new SelecteurArtiste("Radiohead"));
        assertEquals(2, resultat.size(),"Radiohead a 2 CD dans le magasin");
    }

    public void testRechercheArtisteNomCd() {
        ArrayList<CD> resultat = magasin.rechercher(new SelecteurArtiste("Daft Punk"));
        assertEquals(1, resultat.size());
        assertEquals("Alive 2007", resultat.get(0).getNomCD(),"Les Daft Punk ont un seul CD qui est Alive 2007");
    }

    public void testRechercheArtisteInsensibleCasse() {
        ArrayList<CD> resultat = magasin.rechercher(new SelecteurArtiste("radiohead"));
        assertEquals(2, resultat.size());
    }
    public void testRechercheArtisteInconnu() {
        ArrayList<CD> resultat = magasin.rechercher(new SelecteurArtiste("Amon Tobin"));
        assertEquals(0, resultat.size(),"Aucun CD si l'artiste n'existe pas dans le magasin");
    }

    public void testSelecteurBieber() {
        ArrayList<CD> resultat = magasin.rechercher(new SelecteurBieber());
        assertEquals(1, resultat.size(),"Justin Bieber a 1 CD dans le magasin");
        assertEquals("My World", resultat.get(0).getNomCD());
    }

    public void testRechercheAvecSelecteurAnonyme() {
        Selecteur selecteur = cd -> cd.getNomCD().startsWith("O");
        ArrayList<CD> resultat = magasin.rechercher(selecteur);
        assertEquals(1, resultat.size());
        assertEquals("OK Computer",resultat.get(0).getNomCD());
    }

}
