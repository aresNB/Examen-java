package entity;

public class Secretaire extends Personne {
    private String bureau;

    public Secretaire(String id, String nom, String prenom, String email, String bureau) {
        super(id, nom, prenom, email);
        this.bureau = bureau;
    }

    public String getBureau() {
        return bureau;
    }
    
}
