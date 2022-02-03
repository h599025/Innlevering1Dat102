package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

	Film[] tabell;
	private int antall;
	
	public Filmarkiv(int antall) {
		tabell = new Film[antall];
		int antall1 = 0;
		this.antall = antall1;
	}
	
	private boolean erFull() {
		boolean full = false;
		if (tabell.length == antall) {
			full = true;
		}
		return full;
	}
	
	private void utvid() {
		Film[] tabell1 = new Film[antall*2];
		for(int i = 0; i<tabell.length; i++) {
			tabell1[i] = tabell[i];
			tabell = tabell1;
		}
	}
	
	public Film finnFilm(int nr) {
		for(int i = 0; i<tabell.length; i++) {
			if(tabell[i].getFilmnr() == nr) {
				return tabell[i];
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if(!(erFull())) {
			tabell[antall] = nyFilm;
			antall++;
		} else {
			utvid();
			tabell[antall] = nyFilm;
			antall++;
		}
		
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false;
		for(int i = 0; i < antall && !slettet; i++) {
			if(tabell[i].getFilmnr() == filmnr) {
				tabell[i] = tabell[antall-1];
				tabell[antall-1] = null;
				antall--;
				slettet = true;
			}
		}
		return slettet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] FilmUtvalg = new Film[antall];
		
		for(int i = 0; i<antall; i++) {
			if(tabell[i].getTittel().toUpperCase().contains(delstreng.toUpperCase())) {
				FilmUtvalg[i] = tabell[i];
			}
		}
		return FilmUtvalg;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antallSjanger = 0;
		for(int i = 0; i<antall; i++) {
			if(tabell[i].getSjanger().equals(sjanger)) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}

	@Override
	public int antall() {
		return antall;
	}
	
	
}
