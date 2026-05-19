package donnees;

public class SelecteurDion implements Selecteur{
    public boolean garderCd(CD cd) {
        return cd.getNomArtiste().equalsIgnoreCase("Celine Dion");
    }
}
