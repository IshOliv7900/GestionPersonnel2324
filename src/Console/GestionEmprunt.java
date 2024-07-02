package Console;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class GestionEmprunt {
    private static Lire saisie = new Lire();

    // Méthode pour gérer le magasin et ajouter des produits
    static void Magasin(Magasin mag) {
        mag.AjouterProduit();
        mag.listeMap();
    }

    // Méthode pour gérer les emprunts
    protected void Emprunt(Magasin mag, ArrayList<Personnel> Person, ArrayList<Emprunt> pret) {
        if (Person.isEmpty()) {
            System.out.println("Emprunt impossible, pas de personnel !");
        } else if (mag.isEmpty()) {
            System.out.println("Emprunt impossible, magasin est vide !");
        } else {
            pret.add(new Emprunt((Personnel)Person.get(0), mag.getProduit("Id_1"), 1));
            pret.add(new Emprunt((Personnel)Person.get(1), mag.getProduit("Id_3"), 1));
            pret.add(new Emprunt((Personnel)Person.get(2), mag.getProduit("Id_4"), 1));
            pret.add(new Emprunt((Personnel)Person.get(3), mag.getProduit("Id_6"), 1));
            pret.add(new Emprunt((Personnel)Person.get(6), mag.getProduit("Id_7"), 1));
            Iterator<Emprunt> var4 = pret.iterator();

            // Afficher les emprunts
            while(var4.hasNext()) {
                Emprunt emprunt = (Emprunt)var4.next();
                PrintStream Myval3 = System.out;
                String Myval4 = String.valueOf(emprunt.getEmprunteur());
                Myval3.println(Myval4 + "\t" + String.valueOf(emprunt.getMateriel()));
            }
        }
    }

    // Méthode pour gérer les retours d'emprunts
    protected void RetourEmprunt(ArrayList<Emprunt> pret) {
        if (pret.isEmpty()) {
            System.out.println("Aucun emprunt disponible !");
        } else {
            System.out.println("liste des emprunts");
            int i = 1;

            // Afficher la liste des emprunts
            for(Iterator<Emprunt> var3 = pret.iterator(); var3.hasNext(); ++i) {
                Emprunt emprunt = (Emprunt)var3.next();
                System.out.println("N° " + i + " " + emprunt.getEmprunteur().getNom() + "\t" + emprunt.getArticle());
            }

            System.out.println("Introduire le numéro d'emprunt à annuler : ");
            int nuEmprunt = saisie.saisieInt();
            if (nuEmprunt > 0 && nuEmprunt <= i - 1) {
                pret.remove(nuEmprunt - 1);
            } else {
                System.out.println("Le numéro d'emprunt indiqué n'existe pas !");
            }

            int y = 1;

            // Afficher la liste mise à jour des emprunts
            for(Iterator<Emprunt> var5 = pret.iterator(); var5.hasNext(); ++y) {
                Emprunt emprunt = (Emprunt)var5.next();
                System.out.println("N° " + y + " " + emprunt.getEmprunteur().getNom() + "\t" + emprunt.getArticle());
            }
        }
    }
}

