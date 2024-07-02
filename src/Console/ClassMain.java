package Console;

import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class ClassMain {
    // Méthode principale pour lancer l'application
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Créer et afficher la fenêtre principale
        GestionJFrame fenetre = new GestionJFrame();
        fenetre.setVisible(true);
    }
}

