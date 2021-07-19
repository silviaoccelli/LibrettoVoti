package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import javafx.scene.control.DatePicker;

import it.polito.tdp.librettovoti.model.Voto;
import it.polito.tdp.librettovoti.model.libretto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
   private libretto model;
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private DatePicker pickerEsame;

    @FXML
    private URL location;

    @FXML
    private TextField txtEsame;

    @FXML
    private TextField txtVoto;

  //  @FXML
  //  private TextField txtData;

    @FXML
    private TextArea txtRisposta;
    
    public void SetModel(libretto model) {
    	this.model=model;
    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	//leggi e controlla i dati
    	String nomeEsame =txtEsame.getText();
    	
    	//metodo per controllare se una stringa messa da input è vuota
    	if(nomeEsame.length()==0) {
    		txtRisposta.setText("Errore: nome esame vuoto");
    		return;
    	}
    	
    	String votoEsame = txtVoto.getText();
    	int votoInt =0;
    	try {
    	votoInt = Integer.parseInt(votoEsame);
    	} catch(NumberFormatException ex) { //catturo l'eccezione, errore relativo al parseInt
    		txtRisposta.setText("Errore:il voto deve essere numerico");
    		return;
    	}
    	if(votoInt<18 || votoInt>30) {
    		txtRisposta.setText("Errore: il voto deve essere compreso tra 18 e 30");
    		return;
    	}
    	
    	/*String dataEsame = txtData.getText();
    	LocalDate data = LocalDate.parse(dataEsame);
    	try {
    		data=LocalDate.parse(dataEsame);
    	} catch(DateTimeParseException ex) {
    		txtRisposta.setText("Errore: la data non è nel formato corretto");
    		return;
    	}
    	*/
    	LocalDate data = pickerEsame.getValue();
    	if(data==null) {
    		txtRisposta.setText("Errore: la data è errata o mancante");
    		return;
    	}
    	
    	//esegui l'azione
    	Voto voto = new Voto(nomeEsame, votoInt, data);
    	model.add(voto);
    	
    	//aggiorna i risultati nella View
    	txtRisposta.setText(model.toString());
    	txtEsame.clear();
    	txtVoto.clear();
    	pickerEsame.setValue(null);

    }
    
  

    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        //assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisposta != null : "fx:id=\"txtRisposta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert pickerEsame != null : "fx:id=\"pickerEsame\" was not injected: check your FXML file 'Scene.fxml'.";
    }
}

