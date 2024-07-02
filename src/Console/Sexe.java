package Console;

public enum Sexe {
    HOMME("Garçon"), 
    FEMME("Fille"); 

    private final String label; 

    // Constructeur pour initialiser le label du sexe
    private Sexe(String label) {
        this.label = label;
    }

    // Méthode pour obtenir le label du sexe
    public String getLabel() {
        return this.label;
    }

    private static Sexe[] $values() {
        return new Sexe[]{HOMME, FEMME};
    }
}

