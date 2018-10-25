package fr.insee.bar.model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class TestPojo implements Serializable {

	private String code;
	private String display;
	private List<ActivityPojo> activities;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public List<ActivityPojo> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityPojo> activities) {
		this.activities = activities;
	}

}
