package ensitpfa.backendhl.Controllers;

import ensitpfa.backendhl.Services.PatientService;
import ensitpfa.backendhl.Models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
   private PatientService patientService;



    @GetMapping
    public ResponseEntity<List<Patient>> viewAllPatientList() {
        List<Patient> Patients = patientService.viewAllPatientList();
        return new ResponseEntity<>(Patients, HttpStatus.OK);
    }





}
