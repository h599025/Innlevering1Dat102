package no.hvl.dat102;

import java.lang.Object;

public class Film {

	private int filmnr;
	private String produsent;
	private String tittel;
	private int lansering;
	private String selskap;
	private Sjanger sjanger;
	
	public Film() {
		
	}
	
	public Film(int filmnr, String produsent, String tittel, int lansering, String selskap, Sjanger sjanger) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lansering = lansering;
		this.selskap = selskap;
		this.sjanger = sjanger;
	}
	
	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}
	
	public int getFilmnr() {
		return filmnr;
	}
	
	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}
	
	public String getProdusent() {
		return produsent;
	}
	
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	
	public String getTittel() {
		return tittel;
	}
	
	public void setLansering(int lansering) {
		this.lansering = lansering;
	}
	
	public int getLansering() {
		return lansering;
	}
	
	public void setSelskap(String selskap) {
		this.selskap = selskap;
	}
	
	public String getSelskap() {
		return selskap;
	}
	
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	
	public Sjanger getSjanger() {
		return sjanger;
	}
	
	@Override
	public boolean equals(Object film) {
		return ((Film)film).getFilmnr() == filmnr;
	}
	
	@Override 
	public int hashCode() { 
	    Integer temp = filmnr; 
	    return temp.hashCode(); 
	}
}
