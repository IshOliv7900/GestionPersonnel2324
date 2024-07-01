package Console;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Sauvegarde {
   protected void Sauvegarde(ArrayList<Personnel> Person, ArrayList<Emprunt> pret) {
      System.out.println("Introduire le nom du fichier extension .txt ! ");
      String fichier = InputData.inputNomFichier();

      try {
         BufferedWriter bufWriter = new BufferedWriter(new FileWriter(new File(fichier), true));

         try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
            String formattedDate = sdf.format(date);
            bufWriter.newLine();
            bufWriter.write("DTG de la sauvegarde : " + formattedDate);
            bufWriter.newLine();
            bufWriter.write("+---------------------------+-------------------+--------------------+----------+--------------+--------------------------+");
            bufWriter.newLine();
            bufWriter.write("| Département               | Prénom            | Nom                |   Sexe   | Naissance    |  Email                   |");
            bufWriter.newLine();
            bufWriter.write("+---------------------------+-------------------+--------------------+----------+--------------+--------------------------+");
            bufWriter.newLine();
            StringBuilder sb = new StringBuilder();
            Iterator<Personnel> var9 = Person.iterator();

            while(var9.hasNext()) {
               Personnel Pers = (Personnel)var9.next();
               sb.append(" ");
               sb.append(FixedLenght.setFixedLength(Pers.getDepartement(), 25));
               sb.append(FixedLenght.setFixedLength(Pers.getPrenom(), 20));
               sb.append(FixedLenght.setFixedLength(Pers.getNom(), 20));
               sb.append(FixedLenght.setFixedLength(Pers.getSexe(), 10));
               sb.append(FixedLenght.setFixedLength(Pers.getDateddMMyyyy(), 15));
               sb.append(FixedLenght.setFixedLength(Pers.getEmail(), 25));
               sb.append("\n");
            }

            bufWriter.write(sb.toString());
            bufWriter.newLine();
            bufWriter.newLine();
            bufWriter.write("+------+-------------------------+----------------------------------------+");
            bufWriter.newLine();
            bufWriter.write("| N°   | Nom - Prénom            | Matèriel                               |");
            bufWriter.newLine();
            bufWriter.write("+------+-------------------------+----------------------------------------+");
            bufWriter.newLine();
            StringBuilder sb1 = new StringBuilder();
            int i = 1;
            Iterator<Emprunt> var11 = pret.iterator();

            while(true) {
               if (!var11.hasNext()) {
                  bufWriter.write(sb1.toString());
                  break;
               }

               Emprunt emprunt = (Emprunt)var11.next();
               sb1.append(" ");
               sb1.append(FixedLenght.setFixedLength(String.valueOf(i), 8));
               sb1.append(FixedLenght.setFixedLength(emprunt.getEmprunteur().getNom() + " " + emprunt.getEmprunteur().getPrenom(), 26));
               sb1.append(FixedLenght.setFixedLength(emprunt.getArticle(), 30));
               sb1.append("\n");
               ++i;
            }
         } catch (Throwable var14) {
            try {
               bufWriter.close();
            } catch (Throwable var13) {
               var14.addSuppressed(var13);
            }

            throw var14;
         }

         bufWriter.close();
      } catch (IOException var15) {
         System.err.println("Une erreur est survenue : " + var15.getMessage());
      }
   }
}
