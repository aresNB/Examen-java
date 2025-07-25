package services;

import entity.*;
import java.util.*;

public class PatientService {
    private List<RendezVous> rendezVousList = new ArrayList<>();

    public void demanderRendezVous(RendezVous rv) {
        rendezVousList.add(rv);
    }

    public List<RendezVous> listerRendezVousPatient(Patient patient) {
        List<RendezVous> result = new ArrayList<>();
        for (RendezVous rv : rendezVousList) {
            if (rv.getPatient().getId().equals(patient.getId())) {
                result.add(rv);
            }
        }
        return result;
    }

    public boolean demanderAnnulation(String idRv, Patient patient) {
        for (RendezVous rv : rendezVousList) {
            if (rv.getId().equals(idRv) && rv.getPatient().getId().equals(patient.getId())) {
                rv.setStatut(StatutRendezVous.ANNULE);
                return true;
            }
        }
        return false;
    }
}