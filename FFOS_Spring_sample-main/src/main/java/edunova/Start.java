/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package edunova;

import edunova.controller.ObradaGrupa;
import edunova.controller.ObradaPolaznik;
import edunova.controller.ObradaSmjer;
import edunova.model.Grupa;
import edunova.model.Polaznik;
import edunova.model.Smjer;
import edunova.util.EdunovaException;
import edunova.util.HibernateUtil;
import edunova.util.Pomocno;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class Start {

    public Start() {

//        PocetniInsert.izvedi();
//        for(Smjer s : new ObradaSmjer().read()){
//            System.out.println(s.getNaziv());         
//        }
//        ObradaSmjer os = new ObradaSmjer();
//        Smjer s = new Smjer();
//        s.setNaziv("Prvi pomoću kontrolera");
//        s.setCijena(BigDecimal.ONE);
//        os.setEntitet(s);
//        try {
//            os.create();
//        } catch (EdunovaException ex) {
//            System.out.println(ex.getPoruka());
//        }
//        s = new Smjer();
//        s.setNaziv("Prvi pomoću kontrolera");
//        os.setEntitet(s);
//        try {
//            os.create();
//        } catch (EdunovaException ex) {
//            System.out.println(ex.getPoruka());
//        }
        //new PocetniInsert();
//        ObradaPolaznik op = new ObradaPolaznik();
//        Polaznik p = new Polaznik();
//        p.setIme("Pero");
//        p.setOib("52696585232");
//        op.setEntitet(p);
//        try {
//            op.create();
//        } catch (EdunovaException ex) {
//            System.out.println(ex.getPoruka());
//        }
        ObradaGrupa og = new ObradaGrupa();
        Grupa g = new Grupa();
        g.setNaziv("JP26");
        SimpleDateFormat df = new SimpleDateFormat(Pomocno.FORMAT_DATUMA);

        try {
            g.setDatumPocetka(df.parse("27.09.2022"));
        } catch (ParseException ex) {
            g.setDatumPocetka(null);
        }
        og.setEntitet(g);
        try {
            og.create();
            System.out.println("Uspješno spremljenja grupa");
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        // nova grupa
        g = new Grupa();
        try {
            g.setDatumPocetka(df.parse("27.09.2022"));
        } catch (ParseException ex) {
            g.setDatumPocetka(null);
        }
        og.setEntitet(g);
        try {
            og.create();
            System.out.println("Uspješno spremljenja grupa");
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }

    }

    public static void main(String[] args) {
        new Start();
    }
}
