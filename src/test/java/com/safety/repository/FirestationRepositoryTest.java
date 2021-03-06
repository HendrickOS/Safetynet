package com.safety.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.safety.safetynet.SafetynetApplication;
import com.safety.safetynet.model.Firestation;
import com.safety.safetynet.repository.FirestationRepository;

@SpringBootTest(classes = SafetynetApplication.class)
@ExtendWith(SpringExtension.class)
class FirestationRepositoryTest {

	@Autowired
	FirestationRepository firestationRepository;

	@Test
	void getFirestationsAddressesTest() {
		int stationNumber = 1;
		List<String> result = new ArrayList<String>();
		List<String> addresses = new ArrayList<String>();
		String address1 = "644 Gershwin Cir";
		String address2 = "908 73rd St";
		String address3 = "947 E. Rose Dr";
		addresses.add(address1);
		addresses.add(address2);
		addresses.add(address3);

		result = firestationRepository.getFirestationsAddresses(String.valueOf(stationNumber));

		assertEquals(addresses.size(), result.size());
		assertEquals(addresses.get(0).length(), result.get(0).length());
		addresses.get(1).equals(result.get(1));

	}

	@Test
	void updateFirestationTest() {
		Firestation firestation = new Firestation();
		String addressBase = "Addresse base";
		String stationBase = "Station base";
		firestation.setAddress(addressBase);
		firestation.setStation(stationBase);
		Firestation firestationUpdate = new Firestation();

		firestationUpdate.update(firestation);
		firestationRepository.updateFirestation(firestation);

		assertEquals(firestation.getAddress(), firestationUpdate.getAddress());
		assertEquals(firestation.getStation(), firestationUpdate.getStation());
	}
}
