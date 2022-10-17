/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Grupa;
import edunova.util.EdunovaException;
import edunova.util.Pomocno;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author dell
 */
public class ObradaGrupa extends Obrada<Grupa> {

    @Override
    public List<Grupa> read() {
        // from Grupa označava sve entitete klase Grupa. Ne ide se na ime tablice već se ide na ime klase
        return session.createQuery("from Grupa", Grupa.class).list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaDatumPocetka();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {

    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {

    }

    @Override
    protected String getNazivEntiteta() {
        return "Grupa";
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
        if(entitet.getDatumPocetka().before(k.getTime())){
            throw new EdunovaException("Datum početka ne može biti prije danas " + 
                    Pomocno.getPrimjerDatuma());
        }
    }

    private void kontrolaDatumPocetkaMoraBitiRadniDan()throws EdunovaException {
        GregorianCalendar k = (GregorianCalendar) Calendar.getInstance();
        k.setTime(entitet.getDatumPocetka());
        if (k.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY ||
                k.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
            SimpleDateFormat df = new SimpleDateFormat("EEEE");
             throw new EdunovaException("Datum početka mora biti radni dan. "
                     + "Postavljeni datum je " +
                     df.format(entitet.getDatumPocetka()));
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


}
