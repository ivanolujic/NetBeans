package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Clan extends Entitet {

    @ManyToOne
    private Grupa grupa;
    
    @ManyToOne
    private Polaznik polaznik;

    public Clan() {
        super();
    }

    public Clan(Integer sifra, Grupa grupa, Polaznik polaznik) {
        super(sifra);
        this.grupa = grupa;
        this.polaznik = polaznik;
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

}
