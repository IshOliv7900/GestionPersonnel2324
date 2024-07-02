package Console;

public class InputData {
   private static Lire saisie = new Lire();

   // Saisit et valide le nom ou prénom
   protected static String inputNomPrenom(String libelle, int tailleNom) {
      boolean arret = false;
      String result;

      for(result = null; !arret; arret = false) {
         if (libelle.equals("nom")) {
            result = saisie.SaiseTexte("Veuillez introduire le nom : ");
         } else {
            result = saisie.SaiseTexte("Veuillez introduire le prénom : ");
         }

         if (ControleSaisie.valideNom(result, tailleNom)) {
            return result;
         }

         System.out.print("Erreur de saisie !  ");
      }

      return result;
   }

   // Saisit et valide l'email
   protected static String inputEmail() {
      boolean arret = false;
      String email;

      for(email = null; !arret; arret = false) {
         email = saisie.SaiseTexte("Veuillez introduire l'adresse mail : ");

         if (ControleSaisie.valideEmail(email)) {
            return email;
         }

         System.out.print("Saisie non valide !  ");
      }

      return email;
   }

   // Saisit et valide le nom de fichier
   protected static String inputNomFichier() {
      boolean arret = false;
      String result;

      for(result = null; !arret; arret = false) {
         result = saisie.SaiseTexte("Veuillez introduire le nom du fichier (par exemple, Personnel.xml) : ");

         String cheminRelatif = "./Fichier/" + result;
         if (ControleSaisie.valideNomFichier(cheminRelatif)) {
            return cheminRelatif;
         }

         System.out.print("Saisie non valide !  ");
      }

      return "./Fichier/" + result;
   }

   // Demande la confirmation pour suppression
   protected static boolean suppression() {
      boolean arret = false;
      boolean result = false;

      while(!arret) {
         String texte = saisie.SaiseTexte("Voulez-vous valider la suppression ? o/n ");

         if (ControleSaisie.oui_non(texte)) {
            result = true;
            arret = true;
         } else {
            System.out.print("Erreur de saisie !  ");
         }
      }

      return result;
   }

   // Saisit et valide le sexe
   protected static String inputSexe() {
      boolean arret = false;
      boolean result = false;
      String texte = "";

      while(!arret) {
         texte = saisie.SaiseTexte("Veuillez introduire 1. pour une FEMME ou 2. pour un HOMME : ");

         if (ControleSaisie.un_deux(texte)) {
            result = true;
            arret = true;
         } else {
            System.out.print("Erreur de saisie !  ");
         }
      }

      return texte;
   }

   // Saisit et valide le département
   protected static String InputDepartement() {
      boolean arret = false;
      boolean result = false;
      String texte = "";

      while(!arret) {
         System.out.println("Département : ");
         System.out.println("Pour la comptabilité, \t\t\ttapez 1 ");
         System.out.println("Pour les ressources humaines, \ttapez 2 ");
         System.out.println("Pour la production, \t\t\ttapez 3");
         System.out.println("Pour la sécurité, \t\t\t\ttapez 4");
         texte = saisie.SaiseTexte("Veuillez introduire votre choix : ");

         if (ControleSaisie.valideDept(texte)) {
            result = true;
            arret = true;
         } else {
            System.out.print("Erreur de saisie !  ");
         }
      }

      return texte;
   }

   // Saisit et valide la date de naissance
   public static String inputDateNaissance() {
      boolean arret = false;
      String date;

      for(date = null; !arret; arret = false) {
         date = saisie.SaiseTexte("Veuillez introduire la date de naissance : (xx/xx/xxxx)");

         if (ControleSaisie.valideDate(date)) {
            return date;
         }

         System.out.print("Saisie non valide !  ");
      }

      return date;
   }
}
