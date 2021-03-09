package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {
	public static void main(String[] arg) {
		
		System.out.println("Test metodi di Libretto");
	libretto librettoo = new libretto ();
	
	Voto voto1 =new Voto("Analisi 1",30,LocalDate.of(2019, 2, 15));
	
	librettoo.add(voto1);
	librettoo.add(new Voto("Fisica 1",28,LocalDate.of(2019, 7, 15 )));
	librettoo.add(new Voto("Informatica",24,LocalDate.of(2019, 9, 15 )));
	librettoo.add(new Voto("Chimica", 25, LocalDate.of(2019, 7, 15)));
	
	System.out.println(librettoo);
	
	List<Voto> venticinque = librettoo.listaVotiUguali(25);
    System.out.println(venticinque);
    
    libretto librettoventicinque = librettoo.votiUguali(25);
    System.out.println(librettoventicinque);
    
    Voto analisi =librettoo.ricercaCorso("Analisi 1");
    System.out.println(analisi);
	}
	
}
