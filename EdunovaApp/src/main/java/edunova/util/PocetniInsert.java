/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import com.github.javafaker.Faker;
import edunova.model.Polaznik;
import edunova.model.Smjer;
import edunovaeclipse.util.Pomocno;
import org.hibernate.Session;

/**
 *
 * @author dell
 */
public class PocetniInsert {
    
    public static void izvedi(){
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        
        Faker f = new Faker();
        Smjer smjer;
        for(int i=0;i<10;i++){
            smjer = new Smjer();
            smjer.setNaziv(f.beer().name());
            s.persist(smjer);
        }
        
        Polaznik p;
        for(int i=0;i<Pomocno.slucajniBroj(400,800);i++){
            p = new Polaznik();
            p.setIme(f.address().firstName());
            p.setPrezime(f.address().lastName());
            s.persist(p);
        }
        
        
        s.getTransaction().commit();
    }
    
}
