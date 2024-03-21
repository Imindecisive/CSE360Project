package application.healthSoftware;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import application.healthSoftware.data.*;

public class DataController {
	private static DataController instance;

	private Map<String, Visit> allVisits = new LinkedHashMap<>();
	
	private DataController() {
		
	}
	
	public static DataController getInstance() {
		if(instance == null) {
			instance = new DataController();
		}
		
		return instance;
	}
	
	// Get all visits associated with a single patient
	public List<Visit> getAllVisitsForPatient(String patientID) {
		List<Visit> visits = new ArrayList<Visit>();
		
		for(Map.Entry<String, Visit> entry : allVisits.entrySet()) {
			Visit visit = entry.getValue();
			if(visit.patientID.equals(patientID)) {
				visits.add(visit);
			}
			else {
			}
		}
		
		return visits;
	}
	
	// Save a visit
	public void saveVisit(Visit v) {
		allVisits.put(v.visitID, v);
	}
}