package donnees;

public class SelecteurArtiste implements Selecteur {

    private String nomArtiste;

    public SelecteurArtiste(String nA){
        this.nomArtiste = nA;
    }

    @Override
    public boolean garderCd(CD cd) {
        return cd.getNomArtiste().equalsIgnoreCase(this.nomArtiste);
    }
}
