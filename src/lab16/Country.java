package lab16;
//THIS FILE SHOULD BE COMPARABLE TO TOAST (I THINK)
public class Country {
	
//	String countryNum = "1.";
	String countryName = "Canada";
	
	public Country(String countryName) {
		super();
		this.countryName = countryName;
	}
	
//	public String getCountryNum() {
//		return countryNum;
//	}
//	public void setCountryNum(String countryNum) {
//		this.countryNum = countryNum;
//	}
	public String getCountryName() {                //NOTE: CHANGED FROM auto-generated "CountryName" to "getCountryName"
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@Override
	public String toString() {
		return countryName;
	}
}
	
	
	
	
	
	
	
