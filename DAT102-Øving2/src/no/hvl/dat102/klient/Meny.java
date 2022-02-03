package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;  
	private FilmarkivADT filmarkiv;  
	  
	 public Meny(FilmarkivADT filmarkiv){ 
	  tekstgr = new Tekstgrensesnitt();  
	  this.filmarkiv = filmarkiv; 
	 } 
	  
	 public void start(){ 
	 
		 Film film = new Film(1, "Nick Hower", "Central Intelligence", 2000, "Sony", Sjanger.ACTION);
		 Film film1 = new Film(2, "Johan Nils", "Fairytale", 2012, "Warner Bros", Sjanger.DRAMA);
		 Film film2 = new Film(3, "Chris Wood", "CO-OP Central", 1998, "Sony", Sjanger.ACTION);
		 Film film3 = new Film(4, "Chris Wedge", "Is-tid", 2002, "Blue Age Studios", Sjanger.HISTORY);
		 Film film4 = new Film(5, "Johan Jo", "Drømmeland", 2010, "Warner Bros", Sjanger.HISTORY);
		 filmarkiv.leggTilFilm(film);
		 filmarkiv.leggTilFilm(film1);
		 filmarkiv.leggTilFilm(film2);
		 filmarkiv.leggTilFilm(film3);
		 filmarkiv.leggTilFilm(film4);
		 
		 tekstgr.visFilm(film);
		 tekstgr.visFilm(film1);
		 tekstgr.visFilm(film2);
		 tekstgr.visFilm(film3);
		 tekstgr.visFilm(film4);
		 
		 System.out.println();
		 
		 System.out.println("Søket gav: " + "\n" + "------------------------------------");
		 tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "Central Intelligence");
		 
		 System.out.println();
		 
		 System.out.println("Søket gav: " + "\n" + "------------------------------------");
		 tekstgr.skrivUtFilmProdusent(filmarkiv, "Johan");
		 
		 System.out.println();
		 
		 System.out.println("Antall filmer pr sjanger:" + "\n" + "------------------------------------");
		 tekstgr.skrivUtStatistikk(filmarkiv);
	 } 
}
