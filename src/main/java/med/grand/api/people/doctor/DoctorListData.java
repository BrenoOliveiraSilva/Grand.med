package med.grand.api.people.doctor;

public record DoctorListData(Long id, String name, String email, String licenseNumber, Specialty specialty) {
    public DoctorListData(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getLicenseNumber(), doctor.getSpecialty());
    }
}