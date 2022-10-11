package edunova.model;

import jakarta.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Smjer extends Entitet {

	private String naziv;
	private Integer trajanje;
	private BigDecimal cijena;
	private BigDecimal upisnina;
	private Boolean certificiran;
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Integer getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(Integer trajanje) {
		this.trajanje = trajanje;
	}
	public BigDecimal getCijena() {
		return cijena;
	}
	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}
	public BigDecimal getUpisnina() {
		return upisnina;
	}
	public void setUpisnina(BigDecimal upisnina) {
		this.upisnina = upisnina;
	}
	public Boolean isCertificiran() {
		return certificiran;
	}
	public void setCertificiran(Boolean certificiran) {
		this.certificiran = certificiran;
	}
	
	
}
