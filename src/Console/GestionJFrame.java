package Console;

import java.awt.Component;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class GestionJFrame extends JFrame {
   private static final long serialVersionUID = 1L; // Add this line

   protected JButton btnLoad;
   protected JButton btnAffichage;
   protected JButton btnMag;
   protected JButton btnPret;
   protected JButton btnRetour;
   protected JButton btnModifPersonnel;
   protected JButton btnSupprimerPersonnel;
   protected JButton btnAjoutPersonnel;
   protected JButton btnSauvegarde;
   protected JButton btnClose;
   private ArrayList<Personnel> Person = new ArrayList<>();
   private Magasin mag = new Magasin();
   private ArrayList<Emprunt> pret = new ArrayList<>();
   private Sauvegarde save = new Sauvegarde();
   private AffichagePers affichePers = new AffichagePers();
   private GestionPersonnel gestpers = new GestionPersonnel();
   private GestionEmprunt gestemprunt = new GestionEmprunt();

   public GestionJFrame() {
      super("Gestion Personnel & prêt matériel. ");
      this.setDefaultCloseOperation(2);
      JPanel contentPane = (JPanel)this.getContentPane();
      String texteBtnAfficher = new String("<html><Div Align=Center> Affichage <BR> données personnel </Div></html>");
      String texteBtnModifPersonnel = new String("<html><Div Align=Center> Modification <BR> données personnel </Div></html>");
      String texteBtnLoad = new String("<html><Div Align=Center> Charger <BR> données personnel </Div></html>");
      this.btnLoad = new JButton(texteBtnLoad);
      this.btnAffichage = new JButton(texteBtnAfficher);
      this.btnMag = new JButton("Création du magasin");
      this.btnPret = new JButton("Prêt de matériel");
      this.btnRetour = new JButton("Retour de matériel");
      this.btnModifPersonnel = new JButton(texteBtnModifPersonnel);
      this.btnSupprimerPersonnel = new JButton("Supprimer une personne");
      this.btnAjoutPersonnel = new JButton("Ajouter une personne");
      this.btnSauvegarde = new JButton("Sauvegarde ");
      this.btnClose = new JButton("Fermer");
      contentPane.setLayout(new GridLayout(3, 1));
      contentPane.add(this.btnLoad);
      contentPane.add(this.btnAffichage);
      contentPane.add(this.btnMag);
      contentPane.add(this.btnPret);
      contentPane.add(this.btnRetour);
      contentPane.add(this.btnModifPersonnel);
      contentPane.add(this.btnSupprimerPersonnel);
      contentPane.add(this.btnAjoutPersonnel);
      contentPane.add(this.btnSauvegarde);
      contentPane.add(this.btnClose);
      this.btnLoad.addActionListener((e) -> {
         try {
            this.gestpers.LoadPersonnel(this.Person);
         } catch (SAXException var3) {
            throw new RuntimeException(var3);
         } catch (IOException var4) {
            throw new RuntimeException(var4);
         } catch (ParserConfigurationException var5) {
            throw new RuntimeException(var5);
         }
      });
      this.btnAffichage.addActionListener((e) -> {
         this.affichePers.AffichageListe(this.Person);
      });
      this.btnMag.addActionListener((e) -> {
         GestionEmprunt.Magasin(this.mag);
      });
      this.btnPret.addActionListener((e) -> {
         this.gestemprunt.Emprunt(this.mag, this.Person, this.pret);
      });
      this.btnRetour.addActionListener((e) -> {
         this.gestemprunt.RetourEmprunt(this.pret);
      });
      this.btnModifPersonnel.addActionListener((e) -> {
         this.gestpers.ModifPersonnel(this.Person);
      });
      this.btnSupprimerPersonnel.addActionListener((e) -> {
         this.gestpers.SuppressionPersonnel(this.Person);
      });
      this.btnSauvegarde.addActionListener((e) -> {
         this.save.Sauvegarde(this.Person, this.pret);
      });
      this.btnAjoutPersonnel.addActionListener((e) -> {
         this.gestpers.AjoutPersonnel(this.Person);
      });
      this.btnClose.addActionListener((e) -> {
         this.dispose();
      });
      this.setSize(800, 600);
      this.setLocationRelativeTo((Component)null);
   }
}
