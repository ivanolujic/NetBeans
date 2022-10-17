/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Smjer;
import edunova.util.EdunovaException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author dell
 */
public class ObradaSmjer extends Obrada<Smjer> {

    @Override
    public List<Smjer> read() {
        // https://docs.jboss.org/hibernate/orm/3.3/reference/en/html/queryhql.html
        return session.createQuery("from Smjer", Smjer.class).list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {

        kontrolaNaziv();
        kontrolaCijena();

    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {

    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        if(entitet.getGrupe()!=null && 
                !entitet.getGrupe().isEmpty()){
            throw  new EdunovaException("Smjer ima grupe i ne može se "
                    + "obrisati dok se ne obrišu grupe na ovom smjeru");
        }
    }

    @Override
    protected String getNazivEntiteta() {
        return "Smjer";
    }

    private void kontrolaNaziv() throws EdunovaException {

        kontrolaNazivObavezno();
        kontrolaNazivIstiUBazi();
        kontrolaNazivBrojZnakova(50);

    }

    private void kontrolaCijena() throws EdunovaException {
        if (entitet.getCijena() == null
                || entitet.getCijena().equals(BigDecimal.ZERO)) {
            throw new EdunovaException("Cijena nije postavljena ili je nula (0)");
        }

        if (entitet.getCijena().compareTo(BigDecimal.ZERO) < 0) {
            throw new EdunovaException("Cijena smjera ne smije biti manja od nula (0)");
        }
    }

    private void kontrolaNazivObavezno() throws EdunovaException {
        if (entitet.getNaziv() == null || entitet.getNaziv().isEmpty()) {
            throw new EdunovaException("Naziv smjera obavezno");
        }
    }

    private void kontrolaNazivBrojZnakova(int brojZnakova) throws EdunovaException {
        if (entitet.getNaziv().length() > brojZnakova) {
            throw new EdunovaException("Naziv smjera ne smije imati više od " + brojZnakova + " znakova");
        }

    }

    private void kontrolaNazivIstiUBazi() throws EdunovaException {
        Smjer s = null;
        try {
            s = session.createQuery("from Smjer s "
                    + " where s.naziv=:naziv ", Smjer.class)
                    .setParameter("naziv", entitet.getNaziv())
                    .getSingleResult();
        } catch (Exception e) {
        }
        if (s != null) {
            throw new EdunovaException("Isti naziv smjera već postoji");
        }
    }

}
