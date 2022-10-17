/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Polaznik;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author dell
 */
public class ObradaPolaznik extends ObradaOsoba<Polaznik>{

    @Override
    public List<Polaznik> read() {
        return session.createQuery("from Polaznik", Polaznik.class).list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        super.kontrolaCreate(); 
        
        kontrolaBrojUgovora();
    }

    @Override
    protected String getNazivEntiteta() {
        return "Polaznik";
    }
    
    

    private void kontrolaBrojUgovora()throws EdunovaException {
        kontrolaBrojUgovoraMoraImatiZnakPodjeljeno();
    }

    private void kontrolaBrojUgovoraMoraImatiZnakPodjeljeno()throws EdunovaException  {
        // Implementirajte da ako je unesen broj ugovora
        // da u sebi mora imati znak /
        if(entitet.getBrojUgovora()!=null && 
                !entitet.getBrojUgovora().trim().isEmpty()){
            if(!entitet.getBrojUgovora().contains("/")){
                throw new EdunovaException("Broj ugovora obavezno mora imati znak /");
            }
        }
    }
    
    
    
}
