package edunova.model;

import jakarta.persistence.Entity;

@Entity
public class Predavac extends Osoba {

	private String iban;
	
	

	public Predavac() {
		super();
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}
	
	
}
