package Console;

public class MyDate {
    private int jour;
    private int mois;
    private int annee;

    // Constructeur pour initialiser les attributs de la date
    public MyDate(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    // Méthodes getters pour les attributs de la date
    public int getJour() {
        return this.jour;
    }

    public int getMois() {
        return this.mois;
    }

    public int getAnnee() {
        return this.annee;
    }
}

