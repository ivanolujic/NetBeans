/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package edunova;

import edunova.util.HibernateUtil;
import java.math.BigDecimal;
import org.hibernate.Session;

/**
 *
 * @author dell
 */
public class Start {

    public Start() {
        Session session = HibernateUtil.getSession();
    }



    public static void main(String[] args) {
       new Start();
    }
}