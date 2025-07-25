package entity;

public class RendezVous {
    private static int cpt = 1; // compteur partagé par tous les objets
    private String id;
    private String date;
    private String heure;
    private Medecin medecin;
    private Patient patient;
    private StatutRendezVous statut;

    public RendezVous(String date, String heure, Medecin medecin, Patient patient, StatutRendezVous statut) {
        this.id = String.valueOf(cpt++);
        this.date = date;
        this.heure = heure;
        this.medecin = medecin;
        this.patient = patient;
        this.statut = statut;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public StatutRendezVous getStatut() {
        return statut;
    }

    public void setStatut(StatutRendezVous statut) {
        this.statut = statut;
    }
}