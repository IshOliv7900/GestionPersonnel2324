package Console;

public enum Sexe {
   HOMME("Garçon"), 
   FEMME("Fille"); 

   private final String label; 

   private Sexe(String label) {
      this.label = label;
   }

   public String getLabel() {
      return this.label;
   }

   private static Sexe[] $values() {
      return new Sexe[]{HOMME, FEMME};
   }
}
