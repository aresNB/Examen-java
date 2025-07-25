import entity.*;
import services.PatientService;
import views.PatientView;

public class App {
    public static void main(String[] args) {
        PatientService patientService = new PatientService();
        Patient patient = new Patient("1", "Diop", "Awa", "awa@gmail.com");
        PatientView patientView = new PatientView(patientService);
        patientView.menu(patient);
    }
}