package entity;

public class Medecin extends Personne {
    private String specialite;

    public Medecin(String id, String nom, String prenom, String email, String specialite) {
        super(id, nom, prenom, email);
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }
}