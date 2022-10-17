package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Clan extends Entitet {

    @ManyToOne
    private Grupa grupa;
    
    @ManyToOne
    private Polaznik polaznik;
    
    private String napomena;

    public Clan() {
        super();
    }

    public Clan(Grupa grupa, Polaznik polaznik, String napomena, Integer sifra) {
        super(sifra);
        this.grupa = grupa;
        this.polaznik = polaznik;
        this.napomena = napomena;
    }



    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Override
    public String toString() {
        return polaznik.toString();
    }
    
    

}
