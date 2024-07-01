package Console;

public class WordUtils {

   private static String capitalize(String value) {
      String firstChar = value.substring(0, 1).toUpperCase();
      String outvalue = firstChar + value.substring(1).toLowerCase();
      return outvalue;
   }

   private static String minimize(String value) {
      String outvalue = value.toLowerCase();
      return outvalue;
   }

   protected static String mettreEnMajscule(String inputString) {
      String outString;
      String[] partString;
      String[] parts;
      int partsLength;
      int i;
      String part;

      if (inputString.indexOf("'") > 0) {
         outString = "";
         partString = inputString.split("'");
         parts = partString;
         partsLength = partString.length;

         for(i = 0; i < partsLength; ++i) {
            part = parts[i];
            System.out.println("avec ' " + part);
            outString = outString + "'" + capitalize(part);
         }

         return outString.substring(1);
      } else if (inputString.indexOf("-") > 0) {
         outString = "";
         partString = inputString.split("-");
         parts = partString;
         partsLength = partString.length;

         for(i = 0; i < partsLength; ++i) {
            part = parts[i];
            System.out.println("avec - " + part);
            outString = outString + "-" + capitalize(part);
         }

         return outString.substring(1);
      } else if (inputString.indexOf(" ") <= 0) {
         return capitalize(inputString);
      } else {
         outString = "";
         partString = inputString.split(" ");
         parts = partString;
         partsLength = partString.length;

         for(i = 0; i < partsLength; ++i) {
            part = parts[i];
            System.out.println("avec ' ' " + part);
            outString = outString + " " + capitalize(part);
         }

         return outString.substring(1);
      }
   }

   protected static String mettreEnMinusculeMail(String inputString) {
      String outString = "";
      String[] partString = inputString.split("@");
      String[] parts = partString;
      int partsLength = partString.length;

      for(int i = 0; i < partsLength; ++i) {
         String part = parts[i];
         outString = outString + "@" + minimize(part);
      }

      return outString.substring(1);
   }
}
