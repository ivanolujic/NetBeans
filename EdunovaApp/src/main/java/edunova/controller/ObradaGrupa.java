/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Clan;
import edunova.model.Grupa;
import edunova.util.EdunovaException;
import edunova.util.Pomocno;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author dell
 */
public class ObradaGrupa extends Obrada<Grupa> {

    private List<Clan> noviClanovi;

    @Override
    public void create() throws EdunovaException {
        kontrolaCreate();
        session.beginTransaction();
        session.persist(entitet);
        for (Clan c : noviClanovi) {
            c.setGrupa(entitet);
            session.persist(c);
        }
        entitet.setClanovi(noviClanovi);
        
        session.getTransaction().commit();
    }

    @Override
    public void delete() throws EdunovaException {
        kontrolaDelete();
        session.beginTransaction();
        for (Clan c : entitet.getClanovi()) {
            session.remove(c);
        }
        session.remove(entitet);
        session.getTransaction().commit();
    }
    
    

    @Override
    public void update() throws EdunovaException {
        kontrolaUpdate();
        session.beginTransaction();
        for (Clan c : entitet.getClanovi()) {
            session.remove(c);
        }
        for (Clan c : noviClanovi) {
            session.persist(c);
        }
        entitet.setClanovi(noviClanovi);
        session.persist(entitet);
        session.getTransaction().commit();
    }

    @Override
    public List<Grupa> read() {
        // from Grupa označava sve entitete klase Grupa. Ne ide se na ime tablice već se ide na ime klase
        return session.createQuery("from Grupa", Grupa.class).list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaNaziv();
        kontrolaSmjer();
        kontrolaBrojPolaznika();
        kontrolaDatumPocetka();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {

        kontrolaCreate();
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        if(!noviClanovi.isEmpty()){
            throw new EdunovaException("Ne može se obrisati grupa koja ima članove");
        }
    }

    @Override
    protected String getNazivEntiteta() {
        return "Grupa";
    }

    private void kontrolaNaziv() throws EdunovaException {
        if (entitet.getNaziv() == null || entitet.getNaziv().isEmpty()) {
            throw new EdunovaException("Naziv obavezno");
        }
    }

    private void kontrolaBrojPolaznika() throws EdunovaException {
        if (entitet.getMaksimalnoPolaznika() != null
                && entitet.getMaksimalnoPolaznika() > 0) {
            if (entitet.getMaksimalnoPolaznika() < noviClanovi.size()) {
                throw new EdunovaException("Grupa ima više članova od maksimalnog broja članova");
            }

        }
    }

    private void kontrolaDatumPocetka() throws EdunovaException {
        kontrolaDatumPocetkaObavezno();
        kontrolaDatumPocetkaVeciOdDanas();
        kontrolaDatumPocetkaMoraBitiRadniDan();
        kontrolaDatumPocetkaNemaGrupeKojaPocinjeNaTajDan();
    }

    private void kontrolaDatumPocetkaObavezno() throws EdunovaException {
        if (entitet.getDatumPocetka() == null) {
            throw new EdunovaException("Datum početka obavezno. npr "
                    + Pomocno.getPrimjerDatuma());
        }
    }

    private void kontrolaDatumPocetkaVeciOdDanas() throws EdunovaException {
        GregorianCalendar k = (GregorianCalendar) Calendar.getInstance();
        k.setTime(new Date());
        k.set(Calendar.HOUR, 0);
        k.set(Calendar.MINUTE, 0);
        k.set(Calendar.SECOND, 0);
        k.set(Calendar.MILLISECOND, 0);
        if (entitet.getDatumPocetka().before(k.getTime())) {
            throw new EdunovaException("Datum početka ne može biti prije danas "
                    + Pomocno.getPrimjerDatuma());
        }
    }

    private void kontrolaDatumPocetkaMoraBitiRadniDan() throws EdunovaException {
        GregorianCalendar k = (GregorianCalendar) Calendar.getInstance();
        k.setTime(entitet.getDatumPocetka());
        if (k.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
                || k.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            SimpleDateFormat df = new SimpleDateFormat("EEEE");
            throw new EdunovaException("Datum početka mora biti radni dan. "
                    + "Postavljeni datum je "
                    + df.format(entitet.getDatumPocetka()));
        }
    }

    private void kontrolaDatumPocetkaNemaGrupeKojaPocinjeNaTajDan() throws EdunovaException {
        Grupa g = null;
        try {
            g = session.createQuery("from Grupa g "
                    + " where g.datumPocetka=:dp ", Grupa.class)
                    .setParameter("dp", entitet.getDatumPocetka())
                    .getSingleResult();
        } catch (Exception e) {
        }
        if (g != null) {
            throw new EdunovaException("Grupa " + g.getNaziv()
                    + " počinje na uneseni datum");
        }
    }

    public List<Clan> getNoviClanovi() {
        return noviClanovi;
    }

    public void setNoviClanovi(List<Clan> noviClanovi) {
        this.noviClanovi = noviClanovi;
    }

    private void kontrolaSmjer() throws EdunovaException {
        if (entitet.getSmjer()== null ) {
            throw new EdunovaException("Smjer obavezno");
        }
        
    }

}
