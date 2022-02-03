package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

public class Tekstgrensesnitt {

	private Film film;
	
	// lese opplysningene om en FILM fra tastatur  
	 public Film lesFilm(){ 
		 film = null;
		 Scanner tast = new Scanner(System.in);
		 
		 System.out.println("Filmnr: ");
		 int filmnr = tast.nextInt();
		 tast.nextLine();
		 
		 System.out.println("Produsent: ");
		 String produsent = tast.nextLine();
		 
		 System.out.println("Tittel: ");
		 String tittel = tast.nextLine();
		 
		 System.out.println("Lansering: ");
		 int lansering = tast.nextInt();
		 tast.nextLine();

		 System.out.println("Selskap: ");
		 String selskap = tast.nextLine();
		 
		 System.out.println("Sjanger: ");
		 Sjanger sjanger = Sjanger.finnSjanger(tast.nextLine());
		 
		 tast.close();
		 
		 film = new Film(filmnr, produsent, tittel, lansering, selskap, sjanger);
		 return film;
	 } 
	 
	 // vise en film med alle opplysninger på skjerm (husk tekst for sjanger) 
	 public void visFilm(Film film) { 
			System.out.println("Filmnr: " + film.getFilmnr() + ", Produsent: " + film.getProdusent() + ", Tittel: " + film.getTittel() + ", Lansering: " + film.getLansering() + ", Selskap: " + film.getSelskap() + ", Sjanger: " + film.getSjanger());
	 } 
	 
	 // Skrive ut alle Filmer med en spesiell delstreng i tittelen 
	 public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) { 
		 
		 Film[] nyFilmTab = filma.soekTittel(delstreng);
		 for (Film f : nyFilmTab) {
			 if(f != null) {
				 visFilm(f);
			 }
		 }
	 } 
	 
	 // Skriver ut alle Filmer av en produsent / en gruppe 
	 public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) { 
			Film[] aktuellFilm = new Film[filma.antall()+1];

			for(int i = 1; i<aktuellFilm.length; i++) {
				if(filma.finnFilm(i).getProdusent().toUpperCase().contains(delstreng.toUpperCase())) {
						aktuellFilm[i] = filma.finnFilm(i);
				}
			}
			for (Film f : aktuellFilm) {
				if(f != null) {
					visFilm(f);
				}
			}
	 } 
	 
	 // Skrive ut en enkel statistikk som inneholder antall Filmer totalt 
	 // og hvor mange det er i hver sjanger 
	 public void skrivUtStatistikk(FilmarkivADT filma) { 
	  System.out.println("Action filmer totalt: " + filma.antall(Sjanger.ACTION));
	  System.out.println("Drama filmer totalt: " + filma.antall(Sjanger.DRAMA));
	  System.out.println("Historie filmer totalt: " + filma.antall(Sjanger.HISTORY));
	  System.out.println("Scifi filmer totalt: " + filma.antall(Sjanger.SCIFI));
	 } 
}
