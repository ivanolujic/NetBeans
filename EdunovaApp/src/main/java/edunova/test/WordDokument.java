/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.test;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.Section;
import com.spire.doc.documents.HorizontalAlignment;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.ParagraphStyle;
import edunova.controller.ObradaGrupa;
import edunova.model.Clan;
import edunova.model.Grupa;
import edunova.model.Polaznik;

import java.awt.Color;

/**
 *
 * @author dell
 */
public class WordDokument {

    public WordDokument() {
      
        Document document = new Document();


        Section section = document.addSection();

Paragraph p;
        for(Grupa g : new ObradaGrupa().read() ){
            p  = section.addParagraph();
             p.appendText(g.getNaziv());
             for(Clan c : g.getClanovi()){
            p  = section.addParagraph();
             p.appendText("-" + c.getPolaznik());
                 
             }
        }
         
       

  
//Save the document  
        document.saveToFile("Output.docx", FileFormat.Docx);
    }

    public static void main(String[] args) {
        new WordDokument();
    }
}
