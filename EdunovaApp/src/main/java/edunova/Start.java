/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package edunova;

import edunova.util.HibernateUtil;
import edunova.util.PocetniInsert;
import java.math.BigDecimal;

/**
 *
 * @author dell
 */
public class Start {

    public Start() {
       
        PocetniInsert.izvedi();
      
    }
    
    

    public static void main(String[] args) {
       new Start();
    }
}
