package med.grand.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.grand.api.people.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;
    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DoctorRegistrationData data) {
        doctorRepository.save(new Doctor(data));
    }
    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DoctorUpdateData data) {
        var doctor = doctorRepository.getReferenceById(data.id());
        doctor.updateData(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void disable(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.disable();
    }
    @GetMapping
    public Page<DoctorListData> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return doctorRepository.findAllByActiveTrue(pageable).map(DoctorListData::new);
    }
}