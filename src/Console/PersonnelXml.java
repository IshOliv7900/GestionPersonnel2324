package Console;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersonnelXml {
    public static Document document;
    public static Element racine;

    // Méthode pour lire les données du fichier XML
    static NodeList Lecture() throws SAXException, IOException, ParserConfigurationException {
    	
        // Utiliser un chemin relatif
    	
        File inputFile = new File("Fichier/Personnel.xml");
        
        if (!inputFile.exists()) {
            throw new IOException("The file 'Personnel.xml' was not found at the specified path: " + inputFile.getAbsolutePath());
        }

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        racine = doc.getDocumentElement();
        NodeList listPers = racine.getElementsByTagName("Personnel");
        return listPers;
    }
}

