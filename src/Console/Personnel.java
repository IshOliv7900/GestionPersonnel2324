package Console;

public class Personnel extends Individu {
    private Departement departement; 
    private int IdPersonnel; 
    private static int id = 1; 
    private String email; 
    private boolean actif = true; 

    // Constructeur pour initialiser les attributs du personnel
    public Personnel(String nom, String prenom, Sexe sexe, MyDate dateNaissance, String email, Departement dept) {
        super(nom, prenom, sexe, dateNaissance); 
        this.departement = dept; 
        this.IdPersonnel = id++; 
        this.email = email; 
    }

    // Méthode toString pour afficher les informations du personnel
    public String toString() {
        int Myval1 = this.getIdPersonnel();
        return " Id : " + Myval1 + " " + super.toString() + " Email : " + this.getEmail() + " Département : " + this.getDepartement();
    }

    // Méthodes getters et setters pour les attributs du personnel
    public int getIdPersonnel() {
        return this.IdPersonnel;
    }

    public String getDepartement() {
        return this.departement.getDeptNom();
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActif() {
        return this.actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
}

