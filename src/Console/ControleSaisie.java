package Console;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleSaisie {

   private static final String EMAIL_PATTERN = "^[\\w_+&*-]+(?:\\.[\\w_+&*-]+)*@(?:[\\w-]+\\.)+[\\w]{2,7}$";
   private static Pattern patternEmail = Pattern.compile(EMAIL_PATTERN);
   private static final String NAME_PATTERN = "^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$";
   private static Pattern patternNom = Pattern.compile(NAME_PATTERN);
   private static final String DATE_PATTERN = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((19|2[0-9])[0-9]{2})$";
   private static Pattern patternDate = Pattern.compile(DATE_PATTERN);
   private static final String DEPT_PATTERN = "^([1-4]{1})$";
   private static Pattern patternDept = Pattern.compile(DEPT_PATTERN);

   public static boolean valideNom(String text, int taille) {
      String nullString = null;
      String vide = "";
      boolean estNull = text.equals(nullString);
      boolean estVide = text.equals(vide);
      
      if (!estNull && !estVide) {
         Matcher matcher = patternNom.matcher(text);
         if (matcher.matches() && text.length() <= taille) {
            return true;
         } else {
            System.out.println("Valeur hors contraintes !");
            return false;
         }
      } else {
         System.out.println("Valeur null ou vide !");
         return false;
      }
   }

   public static boolean valideNomFichier(String file) {
      File fichier = new File(file);
      boolean isValid = true;

      try {
         if (fichier.createNewFile()) {
            fichier.delete();
         }
      } catch (IOException e) {
         isValid = false;
      }

      return isValid;
   }

   public static boolean valideEmail(String email) {
      Matcher matcher = patternEmail.matcher(email);
      return matcher.matches();
   }

   protected static boolean oui_non(String result) {
      return result.trim().equals("o") || result.trim().equals("n");
   }

   protected static boolean un_deux(String result) {
      return result.trim().equals("1") || result.trim().equals("2");
   }

   public static boolean valideDate(String date) {
      Matcher matcher = patternDate.matcher(date);
      return matcher.matches();
   }

   public static boolean valideDept(String dept) {
      Matcher matcher = patternDept.matcher(dept);
      return matcher.matches();
   }
}
