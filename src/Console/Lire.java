package Console;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lire {
   private Scanner clavier;

   public Lire() {
      this.clavier = new Scanner(System.in);
   }

   protected String SaiseTexte(String libelle) {
      String texte = null;
      System.out.print(libelle);
      boolean loop = false;

      while (!loop) {
         try {
            texte = this.clavier.nextLine();
            if (texte != null && !texte.isBlank()) {
               loop = true;
            } else {
               System.out.println("Aucune valeur introduite !");
            }
         } catch (NoSuchElementException e) {
            System.out.println("Erreur, Aucune ligne n'a été trouvée");
         } catch (IllegalStateException e) {
            System.out.println("Erreur, le Scanner est fermé");
         }
      }

      return texte;
   }

   protected int saisieInt() {
      boolean valid = false;
      int intValue = 0;

      while (!valid) {
         try {
            String strtValue = this.clavier.nextLine();
            intValue = Integer.parseInt(strtValue);
            valid = true;
         } catch (NumberFormatException e) {
            System.out.println("Erreur, veuillez saisir un nombre entier !");
         } catch (NoSuchElementException e) {
            System.out.println("Saisir un entier, aucune donnée trouvée !");
         } catch (IllegalStateException e) {
            System.out.println("Saisir un entier, aucune saisie possible !");
         }
      }

      return intValue;
   }

   private void vider() {
      try {
         this.clavier.nextLine();
      } catch (NoSuchElementException e) {
         this.vider();
         System.out.println("Aucune ligne n'a été trouvée");
      } catch (IllegalStateException e) {
         this.vider();
         System.out.println("Le Scanner est fermé");
      }
   }
}
