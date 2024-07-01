package Console;

public class FixedLenght {
   protected static String setFixedLength(String source, int longueur) {
      while(source.length() < longueur) {
         char espace = ' ';
         source = source + espace;
      }

      return source;
   }
}
