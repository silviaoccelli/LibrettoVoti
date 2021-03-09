package it.polito.tdp.librettovoti.model;
import java.util.List;
import java.util.ArrayList;


public class libretto {
	
	private List<Voto> voti;
	
	public libretto() {
		this.voti = new ArrayList<>(); 
		
	}
	public void add(Voto v) { //aggiunge il voto delega una classe interna a fare l'aggiunta
		this.voti.add(v);
	}
	/*
	public void stampaVotiUguali(int punteggio) {
		//il libtetto stampa solo i voti
		System.out.printIn();
	}
	
	public String votiUguali(int punteggio) {
		//calcola una stringa che contiene i voti
				//sarà poi il chiamante a stamparli
		//devo stampare solo il nome??
		
	}
	*/
	public List<Voto> listaVotiUguali(int punteggio){
		//restituisce i voti uguali al criterio
		List<Voto> risultato = new ArrayList<>();
		for(Voto v:this.voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v); //stesso oggetto contenuto in due liste diverse
			}
		}
		return risultato;
		
	}
	
	public libretto votiUguali(int punteggio) {
		//restituisce un libretto con i voti uguali al punteggio
		libretto risultato = new libretto();
		for(Voto v: this.voti) {
		   if(v.getVoto()==punteggio) {
			risultato.add(v);
			//risultato.voti.add(v);
		}
	}
		return risultato;
	}
	 
	/**
	 *  Ricerca un voto del coreso di cui è specificato il nome
	 *  Se il corso no esiste, restituisce null
	 * @param nomeCorso
	 * @return
	 */
	
	public Voto ricercaCorso(String nomeCorso) {
		Voto risultato=null;
		for(Voto v: this.voti) {
			if(v.getNome().equals(nomeCorso)) {
				risultato =v;
				break;
			}
		}
		return risultato;
	}
	
	
		public String toString() {
			String s ="";
			for(Voto v: this.voti) {
				s = v.toString() + "\n" ;
			}
			return s;
			
		}
	}

