package Console;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class GestionJFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    // Définition des boutons de l'interface graphique
    protected JButton btnLoad, btnAffichage, btnMag, btnPret, btnRetour,
                      btnModifPersonnel, btnSupprimerPersonnel, btnAjoutPersonnel,
                      btnSauvegarde, btnClose;
    private ArrayList<Personnel> Person = new ArrayList<>();
    private Magasin mag = new Magasin();
    private ArrayList<Emprunt> pret = new ArrayList<>();
    private Sauvegarde save = new Sauvegarde();
    private AffichagePers affichePers = new AffichagePers();
    private GestionPersonnel gestpers = new GestionPersonnel();
    private GestionEmprunt gestemprunt = new GestionEmprunt();

    // Constructeur pour initialiser la fenêtre de gestion
    public GestionJFrame() {
        super("Gestion Personnel & prêt matériel.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(3, 4, 10, 10)); // grille avec 3 lignes et 4 colonnes
        initializeButtons();
        addActionListeners();
        addButtonsToPanel(mainPanel);

        // Panel pour le texte de copyright en bas de la fenêtre
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JLabel copyrightLabel = new JLabel("Copyright IPEPS Tournai", JLabel.CENTER);
        bottomPanel.add(copyrightLabel, BorderLayout.SOUTH);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    }

    // Méthode pour initialiser les boutons
    private void initializeButtons() {
        btnLoad = new JButton("Charger données personnel");
        btnAffichage = new JButton("Afficher données personnel");
        btnMag = new JButton("Créer magasin");
        btnPret = new JButton("Prêter matériel");
        btnRetour = new JButton("Retourner matériel");
        btnModifPersonnel = new JButton("Modifier personnel");
        btnSupprimerPersonnel = new JButton("Supprimer personnel");
        btnAjoutPersonnel = new JButton("Ajouter personnel");
        btnSauvegarde = new JButton("Sauvegarder");
        btnClose = new JButton("Fermer");
    }

    // Méthode pour ajouter des listeners aux boutons
    private void addActionListeners() {
        btnLoad.addActionListener(e -> loadPersonnel());
        btnAffichage.addActionListener(e -> affichePers.AffichageListe(Person));
        btnMag.addActionListener(e -> GestionEmprunt.Magasin(mag));
        btnPret.addActionListener(e -> gestemprunt.Emprunt(mag, Person, pret));
        btnRetour.addActionListener(e -> gestemprunt.RetourEmprunt(pret));
        btnModifPersonnel.addActionListener(e -> gestpers.ModifPersonnel(Person));
        btnSupprimerPersonnel.addActionListener(e -> gestpers.SuppressionPersonnel(Person));
        btnAjoutPersonnel.addActionListener(e -> gestpers.AjoutPersonnel(Person));
        btnSauvegarde.addActionListener(e -> save.Sauvegarde(Person, pret));
        btnClose.addActionListener(e -> dispose());
    }

    // Méthode pour ajouter les boutons au panneau principal
    private void addButtonsToPanel(JPanel panel) {
        panel.add(btnLoad);
        panel.add(btnAffichage);
        panel.add(btnMag);
        panel.add(btnPret);
        panel.add(btnRetour);
        panel.add(btnModifPersonnel);
        panel.add(btnSupprimerPersonnel);
        panel.add(btnAjoutPersonnel);
        panel.add(btnSauvegarde);
        panel.add(btnClose);
    }

    // Méthode pour charger les données du personnel
    private void loadPersonnel() {
        try {
            gestpers.LoadPersonnel(Person);
            System.out.println("Personnel chargé avec succès : " + Person.size() + " personnes.");
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            System.err.println("Erreur lors du chargement des données personnel : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // Méthode principale pour lancer la fenêtre de gestion
    public static void main(String[] args) {
        new GestionJFrame().setVisible(true);
    }
}

