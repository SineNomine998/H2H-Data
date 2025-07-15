package com.sinenomine.patientservice;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    /**
     * Constructor for PatientService.
     * 
     * @param patientRepository the PatientRepository to use
     */
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Retrieves all patients from the repository and converts them to
     * PatientRecord objects.
     * 
     * @return a list of PatientRecord objects
     */
    public List<PatientRecord> getAllPatients() {
        List<PatientModel> patientModels = patientRepository.findAll();

        return patientModels.stream().map(PatientMapper::toRecord).toList();
    }
}
