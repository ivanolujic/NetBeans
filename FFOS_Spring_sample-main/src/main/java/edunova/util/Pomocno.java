/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author dell
 */
public class Pomocno {
    
    public static final String FORMAT_DATUMA = "dd.MM.yyyy";
    
    public static boolean kontrolaOib(String oib){
        if(oib==null){
            return false;
        }
        if (oib.length() != 11) {
            return false;
        }
        
        char[] chars = oib.toCharArray();
        
        int a = 10;
        int asciiDigitsOffset = '0';
        for (int i = 0; i < 10; i++) {
        	char c = chars[i];
        	if (c < '0' || c > '9') {
        		return false;
        	}
            a = a + (c - asciiDigitsOffset);
            a = a % 10;
            if (a == 0) {
                a = 10;
            }
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        kontrolni = kontrolni % 10;

        return kontrolni == (chars[10] - asciiDigitsOffset);
    }
    
    public static String getPrimjerDatuma(){
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATUMA);
        return df.format(new Date());
    }
    
}
