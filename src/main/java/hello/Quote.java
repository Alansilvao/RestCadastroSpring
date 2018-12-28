package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {


    private String title;
    private String woeid;
    
    

    public Quote() {
    }



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getWoeid() {
		return woeid;
	}



	public void setWoeid(String woeid) {
		this.woeid = woeid;
	}
	
	

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public Value getValue() {
//        return value;
//    }
//
//    public void setValue(Value value) {
//        this.value = value;
//    }
//    
    

    

//	@Override
//    public String toString() {
//        return "Quote{" +
//               
//                 ", woeid=" + woeid +
//                '}';
//    }
    
}
