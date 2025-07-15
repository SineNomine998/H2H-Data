package com.sinenomine.patientservice;

public record PatientRecord(
        String uuid,
        String firstname,
        String lastname,
        String email,
        String address,
        String dateOfBirth) {
}
