package med.grand.api.controller;

import jakarta.validation.Valid;
import med.grand.api.people.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patients")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid PatientRegistrationData data)  {
        patientRepository.save(new Patient(data));}
    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid PatientUpdateData data) {
        var patient = patientRepository.getReferenceById(data.id());
        patient.updateData(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void disable(@PathVariable Long id) {
        var patient = patientRepository.getReferenceById(id);
        patient.disable();
    }
    @GetMapping
    public Page<PatientListData> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return patientRepository.findAllByActiveTrue(pageable).map(PatientListData::new);
    }
}