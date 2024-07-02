package Console;

public class Individu {
    private String nom;
    private String prenom;
    private Sexe sexe;
    private MyDate dateNaissance;

    // Constructeur pour initialiser les attributs de l'individu
    public Individu(String nom, String prenom, Sexe sexe, MyDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
    }

    // Méthodes getters et setters pour les attributs de l'individu
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return this.sexe.getLabel();
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public MyDate getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(MyDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    // Méthode pour obtenir la date de naissance au format dd-MM-yyyy
    public String getDateddMMyyyy() {
        return String.format("%d-%d-%d", this.dateNaissance.getJour(), this.dateNaissance.getMois(), this.dateNaissance.getAnnee());
    }

    // Méthode toString pour afficher les informations de l'individu
    @Override
    public String toString() {
        return String.format("%s %s sexe : %s date de naissance : %d-%d-%d.", this.nom, this.prenom, this.getSexe(), this.dateNaissance.getJour(), this.dateNaissance.getMois(), this.dateNaissance.getAnnee());
    }
}

