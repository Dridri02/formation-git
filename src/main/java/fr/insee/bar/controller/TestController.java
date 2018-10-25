package fr.insee.bar.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.insee.bar.model.ActivityPojo;
import fr.insee.bar.model.DrugPojo;
import fr.insee.bar.model.ObservationPojo;
import fr.insee.bar.model.TestClassPojo;

@Controller
public class TestController {
	
	@PostMapping("/test")
	public ResponseEntity<String> consumeJson(@RequestBody TestClassPojo json) {
		List<ActivityPojo> activities = json.getActivities();
		for (int i = 0; i < activities.size(); i++) {
			if (activities.get(i) instanceof DrugPojo) {
				System.out.println("DrugPojo");
			}
			else
				if (activities.get(i) instanceof ObservationPojo) {
					System.out.println("ObservationPojo");
					// do stuff
				}
		}
		return ResponseEntity.ok("OK");
	}
}
