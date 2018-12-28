package hello;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote4 {
	
	
	private List<Quote3>consolidated_weather;

	public List<Quote3> getConsolidated_weather() {
		return consolidated_weather;
	}

	public void setConsolidated_weather(List<Quote3> consolidated_weather) {
		this.consolidated_weather = consolidated_weather;
	}
	
	
	
	
	
	
	
	
}
