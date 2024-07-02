package Console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class GestionPersonnel {
   private AffichagePers affichePers = new AffichagePers();
   private String nom;
   private int tailleNom = 30;
   private ControleSaisie ctlSaisie = new ControleSaisie();
   private InputData inputData = new InputData();
   private WordUtils wordutils = new WordUtils();

   // Charge les données du personnel à partir d'un fichier XML
   protected void LoadPersonnel(ArrayList<Personnel> Person) throws SAXException, IOException, ParserConfigurationException {
      if (!Person.isEmpty()) {
         System.out.println(" Le personnel est déjà chargé !");
      } else {
         for (int temp = 0; temp < PersonnelXml.Lecture().getLength(); ++temp) {
            Node nNode = PersonnelXml.Lecture().item(temp);
            if (nNode.getNodeType() == 1) {
               Element courant = (Element) nNode;
               String nom = courant.getElementsByTagName("nom").item(0).getTextContent();
               String prenom = courant.getElementsByTagName("prenom").item(0).getTextContent();
               String sex = courant.getElementsByTagName("sexe").item(0).getTextContent().trim();
               Sexe tempSex;
               if (sex.equals("HOMME")) {
                  tempSex = Sexe.HOMME;
               } else {
                  tempSex = Sexe.FEMME;
               }

               String dateNais = courant.getElementsByTagName("dateNaissance").item(0).getTextContent();
               int jour = Integer.parseInt(dateNais.substring(0, dateNais.indexOf("/")));
               int mois = Integer.parseInt(dateNais.substring(dateNais.indexOf("/", 0) + 1, dateNais.indexOf("/", 3)));
               int annee = Integer.parseInt(dateNais.substring(dateNais.length() - 4, dateNais.length()));
               String mail = courant.getElementsByTagName("mail").item(0).getTextContent();
               String Depart = courant.getElementsByTagName("departement").item(0).getTextContent().trim();
               Departement tempdep;
               if (Depart.equals("Compta")) {
                  tempdep = Departement.Compta;
               } else if (Depart.equals("HR")) {
                  tempdep = Departement.HR;
               } else if (Depart.equals("Prod")) {
                  tempdep = Departement.Prod;
               } else {
                  tempdep = Departement.SEC;
               }

               Person.add(new Personnel(nom, prenom, tempSex, new MyDate(jour, mois, annee), mail, tempdep));
            }
         }
      }
   }

   // Modifie les informations d'une personne du personnel
   protected void ModifPersonnel(ArrayList<Personnel> Person) {
      this.affichePers.AffichageListe(Person);
      boolean egal = false;
      System.out.println("Introduire le nom de la personne à modifier :");
      this.nom = InputData.inputNomPrenom("nom", this.tailleNom).trim();

      for (int count = 0; Person.size() > count; ++count) {
         if (this.nom.equalsIgnoreCase(((Personnel) Person.get(count)).getNom().trim())) {
            this.affichePers.AffichageUnePersonne((Personnel) Person.get(count));
            System.out.println("Introduire les nouvelles valeurs : ");
            Personnel Myval1 = (Personnel) Person.get(count);
            WordUtils Myval2 = this.wordutils;
            Myval1.setNom(WordUtils.mettreEnMajscule(InputData.inputNomPrenom("nom", this.tailleNom)));
            Myval1 = (Personnel) Person.get(count);
            Myval2 = this.wordutils;
            Myval1.setPrenom(WordUtils.mettreEnMajscule(InputData.inputNomPrenom("prenom", this.tailleNom)));
            Myval1 = (Personnel) Person.get(count);
            Myval2 = this.wordutils;
            Myval1.setEmail(WordUtils.mettreEnMinusculeMail(InputData.inputEmail()));
            egal = true;
         }
      }

      if (!egal) {
         System.out.println("Pas de correspondance !");
      }
   }

   // Supprime une personne du personnel
   protected void SuppressionPersonnel(ArrayList<Personnel> Person) {
      this.affichePers.AffichageListe(Person);
      boolean egal = false;
      System.out.println("Introduire le nom de la personne à supprimer :");
      this.nom = InputData.inputNomPrenom("nom", this.tailleNom).trim();
      Iterator<Personnel> var3 = Person.iterator();

      while (var3.hasNext()) {
         Personnel personnel = (Personnel) var3.next();
         if (personnel.getNom().contains(this.nom)) {
            this.affichePers.AffichageUnePersonne(personnel);
            InputData Myval1 = this.inputData;
            if (InputData.suppression()) {
               personnel.setActif(false);
               System.out.println("La suppression a eu lieu !");
               egal = true;
               break;
            }
         }
      }

      if (!egal) {
         System.out.println("La suppression n'a pas eu lieu !");
      }
   }

   // Ajoute une nouvelle personne au personnel
   public void AjoutPersonnel(ArrayList<Personnel> person) {
      System.out.println("Introduire les données du nouveau membre du personnel. ");
      WordUtils Myval1 = this.wordutils;
      String nom = WordUtils.mettreEnMajscule(InputData.inputNomPrenom("nom", this.tailleNom));
      Myval1 = this.wordutils;
      String prenom = WordUtils.mettreEnMajscule(InputData.inputNomPrenom("prenom", this.tailleNom));
      String sex = InputData.inputSexe();
      Sexe tempSex;
      if (sex.equals("2")) {
         tempSex = Sexe.HOMME;
      } else {
         tempSex = Sexe.FEMME;
      }

      Myval1 = this.wordutils;
      String email = WordUtils.mettreEnMinusculeMail(InputData.inputEmail());
      String dateNaissance = InputData.inputDateNaissance();
      int jour = Integer.parseInt(dateNaissance.substring(0, dateNaissance.indexOf("/")));
      int mois = Integer.parseInt(dateNaissance.substring(dateNaissance.indexOf("/", 0) + 1, dateNaissance.indexOf("/", 3)));
      int annee = Integer.parseInt(dateNaissance.substring(dateNaissance.length() - 4, dateNaissance.length()));
      String depart = InputData.InputDepartement();
      Departement tempdep;
      if (depart.equals("1")) {
         tempdep = Departement.Compta;
      } else if (depart.equals("2")) {
         tempdep = Departement.HR;
      } else if (depart.equals("3")) {
         tempdep = Departement.Prod;
      } else {
         tempdep = Departement.SEC;
      }

      Personnel pers = new Personnel(nom, prenom, tempSex, new MyDate(jour, mois, annee), email, tempdep);
      person.add(pers);
   }
}
