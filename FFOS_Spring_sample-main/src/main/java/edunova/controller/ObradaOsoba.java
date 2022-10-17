/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Osoba;
import edunova.util.EdunovaException;
import edunova.util.Pomocno;
import java.util.List;

/**
 *
 * @author dell
 */
public abstract class ObradaOsoba<T extends Osoba> extends Obrada<T>{

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        //implementirajte kontrolu ime obavezno
        kontrolaIme();
        kontrolaOib();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }

    private void kontrolaIme() throws EdunovaException{
       kontrolaImeMoraBitiUneseno();
    }

    private void kontrolaImeMoraBitiUneseno() throws EdunovaException {
        if(entitet.getIme()==null || entitet.getIme().trim().isEmpty()){
            throw new EdunovaException("Ime obavezno");
        }
                
    }

    private void kontrolaOib() throws EdunovaException{
        if(!Pomocno.kontrolaOib(entitet.getOib())){
            throw new EdunovaException("OIB nije ispravan");
        }
    }
    
}
