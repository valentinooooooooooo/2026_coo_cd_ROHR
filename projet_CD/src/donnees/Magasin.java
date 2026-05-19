package donnees;

import java.util.ArrayList;

/**
 * La classe Magasin represente un magasin qui vend des CDs.</p>
 * 
 * cette classe est caracterisee par un ensemble de CDs correspondant aux CDS
 * vendus dans ce magasin.
 * 
 */
public class Magasin {

	/**
	 * la liste des CDs disponibles en magasin
	 */
	private ArrayList<CD> listeCds;

	/**
	 * construit un magasin par defaut qui ne contient pas de CD
	 */
	public Magasin() {
		listeCds = new ArrayList<CD>();
	}

	/**
	 * ajoute un cd au magasin
	 * 
	 * @param cdAAjouter
	 *            le cd a ajouter
	 */
	public void ajouteCd(CD cdAAjouter) {
		listeCds.add(cdAAjouter);
	}

	@Override
	/**
	 * affiche le contenu du magasin
	 */
	public String toString() {
		String chaineResultat = "";
		//parcours des Cds
		for (int i = 0; i < listeCds.size(); i++) {
			chaineResultat += listeCds.get(i);
		}
		chaineResultat += "nb Cds: " + listeCds.size();
		return (chaineResultat);

	}

	/**
	 * @return le nombre de Cds du magasin
	 */
	public int getNombreCds() {
		return listeCds.size();
	}
	
	/**
	 * permet d'acceder � un CD
	 * 
	 * @return le cd a l'indice i ou null si indice est non valide
	 */
	public CD getCd(int i)
	{
		CD res=null;
		if ((i>=0)&&(i<this.listeCds.size()))
			res=this.listeCds.get(i);
		return(res);
	}

	private int  indiceMin(int debut, ComparateurCd comp){
		int indiceMin = debut;
		for(int i = debut + 1; i < listeCds.size(); i++){
			if(comp.etreAvant(listeCds.get(i), listeCds.get(indiceMin))) {
				indiceMin = i;
			}
		}
		return indiceMin;
	}

	private void echanger(int i, int j){
		CD temp = listeCds.get(i);
		listeCds.set(i, listeCds.get(j));
		listeCds.set(j,temp);
	}

	public void trier(ComparateurCd comp){
		for(int i = 0; i < listeCds.size() -1; i++){
			int min = indiceMin(i, comp);
			echanger(i, min);
		}
	}

	public void trier(){
		trier(new ComparateurAlbum());
	}

	public ArrayList<CD> chhercherArtiste(String nomArtiste){
		ArrayList<CD> resultat = new ArrayList<CD>();
		for (CD cd : listeCds){
			if(cd.getNomArtiste().equalsIgnoreCase(nomArtiste)){
				resultat.add(cd);
			}
		}
		return resultat;
	}

	public ArrayList<CD> rechercher(Selecteur selecteur){
		ArrayList<CD> resultat = new ArrayList<CD>();
		for (CD cd : listeCds){
			if(selecteur.garderCd(cd)){
				resultat.add(cd);
			}
		}
		return resultat;
	}



}
