/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author dell
 */
@Entity
public class Mjesto {
    
    @Id
    private Long id;
    
    private String naziv;
    private BigDecimal cijena;
    private Boolean glavniGrad;
    private Date datumGodisnjice;
    
     private String naziv1;
    private BigDecimal cijena1;
    private Boolean glavniGrad1;
    private Date datumGodisnjice1;
    
    
     private String naziv2;
    private BigDecimal cijena2;
    private Boolean glavniGrad2;
    private Date datumGodisnjice2;
    
    
     private String naziv3;
    private BigDecimal cijena3;
    private Boolean glavniGrad3;
    private Date datumGodisnjice3;
    
     private String naziv4;
    private BigDecimal cijena4;
    private Boolean glavniGrad4;
    private Date datumGodisnjice4;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getGlavniGrad() {
        return glavniGrad;
    }

    public void setGlavniGrad(Boolean glavniGrad) {
        this.glavniGrad = glavniGrad;
    }

    public Date getDatumGodisnjice() {
        return datumGodisnjice;
    }

    public void setDatumGodisnjice(Date datumGodisnjice) {
        this.datumGodisnjice = datumGodisnjice;
    }

    public String getNaziv1() {
        return naziv1;
    }

    public void setNaziv1(String naziv1) {
        this.naziv1 = naziv1;
    }

    public BigDecimal getCijena1() {
        return cijena1;
    }

    public void setCijena1(BigDecimal cijena1) {
        this.cijena1 = cijena1;
    }

    public Boolean getGlavniGrad1() {
        return glavniGrad1;
    }

    public void setGlavniGrad1(Boolean glavniGrad1) {
        this.glavniGrad1 = glavniGrad1;
    }

    public Date getDatumGodisnjice1() {
        return datumGodisnjice1;
    }

    public void setDatumGodisnjice1(Date datumGodisnjice1) {
        this.datumGodisnjice1 = datumGodisnjice1;
    }

    public String getNaziv2() {
        return naziv2;
    }

    public void setNaziv2(String naziv2) {
        this.naziv2 = naziv2;
    }

    public BigDecimal getCijena2() {
        return cijena2;
    }

    public void setCijena2(BigDecimal cijena2) {
        this.cijena2 = cijena2;
    }

    public Boolean getGlavniGrad2() {
        return glavniGrad2;
    }

    public void setGlavniGrad2(Boolean glavniGrad2) {
        this.glavniGrad2 = glavniGrad2;
    }

    public Date getDatumGodisnjice2() {
        return datumGodisnjice2;
    }

    public void setDatumGodisnjice2(Date datumGodisnjice2) {
        this.datumGodisnjice2 = datumGodisnjice2;
    }

    public String getNaziv3() {
        return naziv3;
    }

    public void setNaziv3(String naziv3) {
        this.naziv3 = naziv3;
    }

    public BigDecimal getCijena3() {
        return cijena3;
    }

    public void setCijena3(BigDecimal cijena3) {
        this.cijena3 = cijena3;
    }

    public Boolean getGlavniGrad3() {
        return glavniGrad3;
    }

    public void setGlavniGrad3(Boolean glavniGrad3) {
        this.glavniGrad3 = glavniGrad3;
    }

    public Date getDatumGodisnjice3() {
        return datumGodisnjice3;
    }

    public void setDatumGodisnjice3(Date datumGodisnjice3) {
        this.datumGodisnjice3 = datumGodisnjice3;
    }

    public String getNaziv4() {
        return naziv4;
    }

    public void setNaziv4(String naziv4) {
        this.naziv4 = naziv4;
    }

    public BigDecimal getCijena4() {
        return cijena4;
    }

    public void setCijena4(BigDecimal cijena4) {
        this.cijena4 = cijena4;
    }

    public Boolean getGlavniGrad4() {
        return glavniGrad4;
    }

    public void setGlavniGrad4(Boolean glavniGrad4) {
        this.glavniGrad4 = glavniGrad4;
    }

    public Date getDatumGodisnjice4() {
        return datumGodisnjice4;
    }

    public void setDatumGodisnjice4(Date datumGodisnjice4) {
        this.datumGodisnjice4 = datumGodisnjice4;
    }
    
    
    
}
