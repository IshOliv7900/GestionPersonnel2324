package Console;

public enum Departement {
    Compta("Comptabilité"),
    HR("Ressources Humaines"), 
    Prod("Production"), 
    SEC("Sécurité"); 

    private String deptNom;

    // Constructeur pour initialiser le nom du département
    private Departement(String deptNom) {
        this.deptNom = deptNom;
    }

    // Méthode pour obtenir le nom du département
    public String getDeptNom() {
        return this.deptNom;
    }

    private static Departement[] $values() {
        return new Departement[]{Compta, HR, Prod, SEC};
    }
}

