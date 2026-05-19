package donnees;

public class SelecteurBieber implements Selecteur {
    @Override
    public boolean garderCd(CD cd) {
        return cd.getNomArtiste().equalsIgnoreCase("Justin Bieber");
    }
}
