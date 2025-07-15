package com.sinenomine.patientservice;

import java.time.LocalDate;
import java.util.UUID;

public class PatientMapper {

    /**
     * Converts a PatientModel to a PatientRecord for use in data exchange between
     * services.
     * 
     * @param patientModel the PatientModel to convert
     * @return a PatientRecord containing the patient's data
     */
    public static PatientRecord toRecord(PatientModel patientModel) {
        return new PatientRecord(
                patientModel.getUuid().toString(),
                patientModel.getFirstName(),
                patientModel.getLastName(),
                patientModel.getEmail(),
                patientModel.getAddress(),
                patientModel.getDateOfBirth().toString());
    }

    /**
     * Converts a PatientRecord to a PatientModel for persistence in the database.
     * 
     * @param patientRecord the PatientRecord to convert
     * @return a PatientModel containing the patient's data
     */
    public static PatientModel toModel(PatientRecord patientRecord) {
        return PatientModel.builder().uuid(UUID.fromString(patientRecord.uuid())).firstName(patientRecord.firstname())
                .lastName(patientRecord.lastname()).email(patientRecord.email()).address(patientRecord.address())
                .dateOfBirth(LocalDate.parse(patientRecord.dateOfBirth())).build();
    }
}
