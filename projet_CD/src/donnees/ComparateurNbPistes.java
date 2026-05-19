package donnees;

public class ComparateurNbPistes implements ComparateurCd {

    public boolean etreAvant(CD cd1, CD cd2) {
        return cd1.getNbPistes() < cd2.getNbPistes();
    }

}
