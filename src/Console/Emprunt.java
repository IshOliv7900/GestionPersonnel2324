package Console;

public class Emprunt {
    protected Personnel emprunteur;
    protected Produit materiel;
    protected int nombre;

    // Constructeur pour initialiser un emprunt
    public Emprunt(Personnel emprunteur, Produit materiel, int nombre) {
        this.setEmprunteur(emprunteur);
        this.materiel = materiel;
        this.nombre = nombre;
    }

    // Méthode pour obtenir l'emprunteur
    public Personnel getEmprunteur() {
        return this.emprunteur;
    }

    // Méthode pour définir l'emprunteur
    public void setEmprunteur(Personnel emprunteur) {
        this.emprunteur = emprunteur;
    }

    // Méthode pour afficher les détails de l'emprunt
    @Override
    public String toString() {
        int Myval1 = this.nombre;
        return Myval1 + " " + this.materiel.toString() + " emprunté par " + String.valueOf(this.getEmprunteur());
    }

    // Méthode pour obtenir le matériel emprunté
    public Produit getMateriel() {
        return this.materiel;
    }

    // Méthode pour obtenir les détails de l'article emprunté
    public String getArticle() {
        String Myval2 = this.materiel.getNom();
        return Myval2 + "  " + this.materiel.getDescription();
    }

    // Méthode pour obtenir le nombre d'articles empruntés
    public int getNombre() {
        return this.nombre;
    }
}

