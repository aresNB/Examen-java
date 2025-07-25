package views;

import entity.*;
import services.PatientService;
import java.util.Scanner;
import java.util.UUID;

public class PatientView {
    private PatientService patientService;
    private Scanner scanner = new Scanner(System.in);

    public PatientView(PatientService patientService) {
        this.patientService = patientService;
    }

    public void menu(Patient patient) {
        int choix;
        do {
            System.out.println("\n===== MENU PATIENT =====");
            System.out.println("1. Demander un rendez-vous");
            System.out.println("2. Lister mes rendez-vous");
            System.out.println("3. Demander annulation d’un rendez-vous");
            System.out.println("0. Quitter");
            System.out.println("========================");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    demanderRendezVous(patient);
                    break;
                case 2:
                    listerRendezVous(patient);
                    break;
                case 3:
                    demanderAnnulation(patient);
                    break;
            }
        } while (choix != 0);
    }

    private void demanderRendezVous(Patient patient) {
        System.out.print("Date (ex: 2024-08-01) : ");
        String date = scanner.nextLine();
        System.out.print("Heure (ex: 14:00) : ");
        String heure = scanner.nextLine();
        System.out.print("Nom du médecin : ");
        String nomMedecin = scanner.nextLine();

        Medecin medecin = new Medecin(UUID.randomUUID().toString(), nomMedecin, "", "", "");
        RendezVous rv = new RendezVous(date, heure, medecin, patient, StatutRendezVous.EN_ATTENTE);
        patientService.demanderRendezVous(rv);
        System.out.println("Demande envoyée !");
    }

    private void listerRendezVous(Patient patient) {
        System.out.println("\n--- Vos rendez-vous ---");
        var liste = patientService.listerRendezVousPatient(patient);
        if (liste.isEmpty()) {
            System.out.println("Aucun rendez-vous trouvé.");
        } else {
            System.out.printf("%-5s %-12s %-8s %-15s %-12s\n", "ID", "Date", "Heure", "Médecin", "Statut");
            for (RendezVous rv : liste) {
                System.out.printf("%-5s %-12s %-8s %-15s %-12s\n",
                        rv.getId(), rv.getDate(), rv.getHeure(), rv.getMedecin().getNom(), rv.getStatut());
            }
        }
        System.out.println("-----------------------\n");
        System.out.println("Appuyez sur Entrée pour continuer...");
        scanner.nextLine();
    }

    private void demanderAnnulation(Patient patient) {
        System.out.print("ID du rendez-vous à annuler : ");
        String idRv = scanner.nextLine();
        boolean ok = patientService.demanderAnnulation(idRv, patient);
        if (ok) {
            System.out.println("Annulation demandée !");
        } else {
            System.out.println("Impossible d’annuler (RV introuvable).");
        }
    }
}