/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "smjerovi")
public class Smjer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sifra;
    @Column(name = "nazivsmjera", columnDefinition = "varchar(50)")
    private String naziv;
    private BigDecimal cijena;
    private BigDecimal upisnina;
    private Boolean certificiran;

    public Integer getSifra() {
        return sifra;
    }

    public void setSifra(Integer sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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

    public Boolean getCertificiran() {
        return certificiran;
    }

    public void setCertificiran(Boolean certificiran) {
        this.certificiran = certificiran;
    }



}