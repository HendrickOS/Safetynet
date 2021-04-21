package com.safety.safetynet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety.safetynet.model.MedicalRecord;
import com.safety.safetynet.model.Person;
import com.safety.safetynet.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {

	@Autowired
	private MedicalRecordRepository medicalRecordRepository;

	public void saveMedicalRecord(MedicalRecord medicalRecord) {
		if (medicalRecord != null && medicalRecord.getFirstName() != null && medicalRecord.getLastName() != null) {
			medicalRecordRepository.addMedicalRecord(medicalRecord);
		}
	}

	public List<MedicalRecord> list() {
		return medicalRecordRepository.list();
	}

	public void updateMedicalRecord(MedicalRecord medicalRecord) {
		if (medicalRecord != null && medicalRecord.getFirstName() != null && medicalRecord.getLastName() != null) {
			medicalRecordRepository.updateMedicalRecord(medicalRecord);
		}
	}

	public void deleteMedicalRecord(MedicalRecord medicalRecord) {
		if (medicalRecord != null && medicalRecord.getFirstName() != null && medicalRecord.getLastName() != null) {
			medicalRecordRepository.deleteMedicalRecord(medicalRecord);
		}
	}

	public int getPersonAge(Person person) {
		return medicalRecordRepository.getPersonAge(person);
	}

}
