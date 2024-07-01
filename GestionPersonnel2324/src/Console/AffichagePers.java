package Console;

import java.util.ArrayList;
import java.util.Iterator;

public class AffichagePers {
   
   protected void AffichageListe(ArrayList<Personnel> Person) {
      if (Person.isEmpty()) {
         System.out.println("Affichage impossible, pas de personnel !");
      } else {
         System.out.println("+-----------------------+-------------------+--------------------+--------+--------------+-------------------------+");
         System.out.println("| Département           | Prénom            | Nom                | Sexe   | Naissance    | Email                   |");
         System.out.println("+-----------------------+-------------------+--------------------+--------+--------------+-------------------------+");
         
         StringBuilder sb = new StringBuilder();
         Iterator<Personnel> iterator = Person.iterator();

         while (iterator.hasNext()) {
            Personnel Pers = iterator.next();
            if (Pers.isActif()) {
               sb.append(" ");
               sb.append(FixedLenght.setFixedLength(Pers.getDepartement(), 25));
               sb.append(FixedLenght.setFixedLength(Pers.getPrenom(), 20));
               sb.append(FixedLenght.setFixedLength(Pers.getNom(), 20));
               sb.append(FixedLenght.setFixedLength(Pers.getSexe(), 10));
               sb.append(FixedLenght.setFixedLength(Pers.getDateddMMyyyy(), 15));
               sb.append(FixedLenght.setFixedLength(Pers.getEmail(), 25));
               sb.append("\n");
            }
         }
         System.out.println(sb.toString());
      }
   }

   protected void AffichageUnePersonne(Personnel pers) {
      if (pers == null) {
         System.out.println("Affichage impossible, pas de personnel !");
      } else {
         System.out.println("+-----------------------+-------------------+--------------------+--------+--------------+-------------------------+");
         System.out.println("| Département           | Prénom            | Nom                | Sexe   | Naissance    | Email                   |");
         System.out.println("+-----------------------+-------------------+--------------------+--------+--------------+-------------------------+");
         
         StringBuilder sb = new StringBuilder();
         sb.append(" ");
         sb.append(FixedLenght.setFixedLength(pers.getDepartement(), 25));
         sb.append(FixedLenght.setFixedLength(pers.getPrenom(), 20));
         sb.append(FixedLenght.setFixedLength(pers.getNom(), 20));
         sb.append(FixedLenght.setFixedLength(pers.getSexe(), 10));
         sb.append(FixedLenght.setFixedLength(pers.getDateddMMyyyy(), 15));
         sb.append(FixedLenght.setFixedLength(pers.getEmail(), 25));
         sb.append("\n");
         
         System.out.println(sb.toString());
      }
   }
}
