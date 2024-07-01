package Console;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Magasin {
   static Map<String, Produit> produits;

   public Magasin() {
      produits = new HashMap<>();
   }

   public void AjouterProduit() {
      produits.put("Id_1", new Produit("HP", "Elitebook 850 G7"));
      produits.put("Id_2", new Produit("HP", "Elitebook 830 G7 X360"));
      produits.put("Id_3", new Produit("Dell", "Inspiron 15 3000"));
      produits.put("Id_4", new Produit("Dell", "XPS 13"));
      produits.put("Id_5", new Produit("Dell", "XPS 15"));
      produits.put("Id_6", new Produit("Lenovo", "Thinkpad E15 G2"));
      produits.put("Id_7", new Produit("Lenovo", "IdeaPad 3 14IIL05 81WD00B2MH"));
   }

   public void listeMap() {
      System.out.println("Le magasin est composé de " + produits.size() + " articles");
      Iterator<Entry<String, Produit>> var1 = produits.entrySet().iterator();

      while (var1.hasNext()) {
         Entry<String, Produit> iterable = var1.next();
         PrintStream Myval1 = System.out;
         String Myval2 = String.valueOf(iterable.getKey());
         Myval1.println(Myval2 + " --- " + String.valueOf(iterable.getValue()));
      }
   }

   public Produit getProduit(String nom) {
      return produits.containsKey(nom) ? produits.get(nom) : null;
   }

   public boolean isEmpty() {
      return produits.isEmpty();
   }
}
