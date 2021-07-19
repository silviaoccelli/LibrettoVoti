package it.polito.tdp.librettovoti.model;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


public class libretto {
	
	private List<Voto> voti;
	private Map<String, Voto> votiMap; //identity map_ mappa:nome esame ->oggetto voto
	
	public libretto() {
		this.voti = new ArrayList<>(); 
		this.votiMap=new HashMap<>();
		
	}
	public void add(Voto v) { //aggiunge il voto delega una classe interna a fare l'aggiunta
		this.voti.add(v);
		this.votiMap.put(v.getNome(), v);
		
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
		/*Voto risultato=null;
		for(Voto v: this.voti) {
			if(v.getNome().equals(nomeCorso)) {
				risultato =v;
				break;
			}
		}
		return risultato;*/
		return this.votiMap.get(nomeCorso);
	}
	/**
	 * verifica se nel libretto c'è già un voto con lo stesso esame
	 * e la stessa votazione
	 * @param v
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
		/*boolean trovato=false;
		for(Voto voto:this.voti) {
			if(voto.getNome().equals(v.getNome())&&voto.getVoto()==v.getVoto());
			trovato=true;
			break;
		}
		}
		return trovato; */
		
		Voto trovato= this.votiMap.get(v.getNome());
		if(trovato==null)
			return false;
		if(trovato.getVoto()==v.getVoto())
			return true;
		else 
			return false;
	}
	/**
	 * verifica se nel libretto c'è già un voto con lo stesso esame
	 * ma con votazione diversa
	 * @param v
	 * @return
	 */
   public boolean esisteConflitto(Voto v) {
	/*	boolean trovato=false;
		for(Voto voto:this.voti) {
			if(voto.getNome().equals(v.getNome())&&voto.getVoto()!=v.getVoto());{
			trovato=true;
			break;
		}
		
	}
   
   return trovato;*/
	   
	   Voto trovato = this.votiMap.get(v.getNome());
	   if(trovato==null)
		   return false;
	   else
		   return true;
   }
	
	
		public String toString() {
			String s ="";
			for(Voto v: this.voti) {
				s = v.toString() + "\n" ;
			}
			return s;
			
		}
	}

