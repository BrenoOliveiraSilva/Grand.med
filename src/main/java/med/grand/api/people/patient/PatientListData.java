package med.grand.api.people.patient;

public record PatientListData(Long id,String name, String email, String phoneNumber) {
    public PatientListData(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhoneNumber());
    }
}
