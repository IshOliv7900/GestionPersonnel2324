package Console;

public enum Departement {
   Compta("Comptabilité"),
   HR("Ressources Humaines"), 
   Prod("Production"), 
   SEC("Sécurité"); 

   private String deptNom;

   private Departement(String deptNom) {
      this.deptNom = deptNom;
   }

   public String getDeptNom() {
      return this.deptNom;
   }

   private static Departement[] $values() {
      return new Departement[]{Compta, HR, Prod, SEC};
   }
}
