package br.senac.tads.dsw.exemplosspring;

public class Item {
	
	private String texto;
	
	private boolean multi10;
	
	public Item() {
		
	}
	
	public Item(String texto, int numero) {
		this.texto = texto;
		multi10 = (numero % 10 == 0);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isMulti10() {
		return multi10;
	}

	public void setMulti10(boolean multi10) {
		this.multi10 = multi10;
	}

}
