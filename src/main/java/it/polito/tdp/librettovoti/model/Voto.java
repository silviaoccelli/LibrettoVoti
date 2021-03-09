package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
//POJO _ Plain Old Java Object
//Java Bean
//Semplice contenitore di dati -- non ha "logica"

/**
 * Memorizza il risultato di un esame singolo
 * @author occel
 *
 */
public class Voto {
	private String nome;
	private int voto; // 30L come lo rappresento?
	private LocalDate data; //data superamento esame
	
	/**
	 * Costruttore della classe Voto
	 * @param nome del corso superato
	 * @param voto
	 * @param data di Superamento
	 */
	public Voto(String nome, int voto, LocalDate data) { //costruttore creato in automatico
		super();
		this.nome = nome;
		this.voto = voto;
		this.data = data;
	}

// source - 
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getVoto() {
		return voto;
	}


	public void setVoto(int voto) {
		this.voto = voto;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Esame " + nome + "superato con" + voto + "in data" + data;
	}
	
	
	
	

}
