/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Entitet;
import edunova.util.EdunovaException;
import edunova.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author dell
 */
public abstract class Obrada<T extends Entitet> {
    
    protected T entitet;
    protected Session session;
    
    public abstract List<T> read();
    protected abstract void kontrolaCreate() throws EdunovaException;
    protected abstract void kontrolaUpdate() throws EdunovaException;
    protected abstract void kontrolaDelete() throws EdunovaException;
    protected abstract String getNazivEntiteta();

    public Obrada() {
        this.session = HibernateUtil.getSession();
    }
    
    public void create() throws EdunovaException{
        if (entitet == null) {
            throw new EdunovaException(getNazivEntiteta() + " nije konstruiran");
        }
        kontrolaCreate();
        persist();
    }
    
    public void update() throws EdunovaException{
        kontrolaUpdate();
        persist();
    }
    
    public void delete() throws EdunovaException{
        kontrolaDelete();
        session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();
    }
    
    private void persist(){
        session.beginTransaction();
        session.persist(this.entitet);
        session.getTransaction().commit();
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    
    
    
    
}
