package com.jakob.demo.Doktor;

import com.jakob.demo.NotFoundExeption;
import com.jakob.demo.Pacient.Patient;
import com.jakob.demo.Pacient.PatientRepository;
import com.jakob.demo.document_report.Document_reportRepository;
import com.jakob.demo.document_report.document_report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DoktorController {
    @Autowired
    private DoktorRepository doktorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private Document_reportRepository document_reportRepository;


    @GetMapping("/doktors/{id}")
    public Doktor getDoktorByID(@PathVariable Long id) {
        Optional<Doktor> optionalDoktor = doktorRepository.findById(id);
        if (optionalDoktor.isPresent()) {
            return optionalDoktor.get();
        } else {
            throw new NotFoundExeption("ne dela");
        }
    }

    @PostMapping("/doktors")
    public Doktor addDoktor(@Validated @RequestBody Doktor doktor) throws Throwable {

        Long id = doktor.getId();
        Date date = new Date();
        try {


            doktorRepository.save(doktor);
            ListIterator<Patient> litr = null;
            List<Patient> pacienti = doktor.getPatients();
            litr = pacienti.listIterator();

            while (litr.hasNext()) {
                Patient pacient = litr.next();
                System.out.println(pacient);
                pacient.setDiseaseCSV();
                patientRepository.save(pacient);
            }
            document_reportRepository.save(new document_report(id, date, null));
        } catch (Exception e) {
            document_reportRepository.save(new document_report(id, date, e.getMessage()));
        }
        return doktor;
    }


    @PutMapping("/doktors/{id}")
    public Doktor updateDoktor(@PathVariable Long id,
                               @Validated @RequestBody Doktor doktorUpdated) {
        return doktorRepository.findById(id).
                map(doktor -> {
                    doktor.setDepartment(doktorUpdated.getDepartment());
                    // tale bo moogče error ker je nekej novga
                    doktor.setPatients(doktorUpdated.getPatients());
                    return doktorRepository.save(doktor);
                }).orElseThrow(() -> new NotFoundExeption("doktor ni najden"));


    }

}
