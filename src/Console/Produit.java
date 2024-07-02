package Console;

public class Produit {
    private String nom; 
    private String description; 

    // Constructeur pour initialiser les attributs du produit
    public Produit(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    // Méthodes getters et setters pour les attributs du produit
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Méthode toString pour afficher les informations du produit
    public String toString() {
        return "Produit [nom = " + this.nom + ", description = " + this.description + " ]\n\t";
    }
}

