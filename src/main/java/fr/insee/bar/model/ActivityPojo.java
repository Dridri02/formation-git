package fr.insee.bar.model;

import java.io.Serializable;


@SuppressWarnings("serial")
public class ActivityPojo implements Serializable {
	private String categoryCode;

	
	public String getCategoryCode() {
		return categoryCode;
	}

	
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
}
