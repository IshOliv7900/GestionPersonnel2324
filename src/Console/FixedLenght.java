package Console;

public class FixedLenght {
   // Ajuste la longueur de la chaîne de caractères à une longueur fixe
   protected static String setFixedLength(String source, int longueur) {
      while(source.length() < longueur) {
         char espace = ' ';
         source = source + espace;
      }

      return source;
   }
}
