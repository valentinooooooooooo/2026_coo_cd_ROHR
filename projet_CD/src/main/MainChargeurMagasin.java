package main;

import java.io.IOException;
import java.util.Scanner;

import donnees.CD;
import donnees.ComparateurAlbum;
import donnees.ComparateurCd;
import donnees.Magasin;
import XML.ChargeurMagasin;

/**
 * permet de charger un magasin de test
 */
public class MainChargeurMagasin {

	/**
	 * methode principale
	 * 
	 * @param args
	 *            inutilise
	 * @throws IOException
	 *             en cas de probleme de lecture entree/sortie
	 */
	public static void main(String args[]) throws IOException {
		
		String repertoire = "../magasinCD_donnees/musicbrainzSimple/";
		ChargeurMagasin charge = new ChargeurMagasin(repertoire);
		Magasin resultat = charge.chargerMagasin();
		System.out.println(resultat);

		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		sc.close();

		resultat.trier();
		System.out.println(resultat);

		resultat.trier(){
			System.out.println(resultat);
		}

	}

}
