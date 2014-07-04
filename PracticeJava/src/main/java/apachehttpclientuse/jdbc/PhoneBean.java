package apachehttpclientuse.jdbc;

public class PhoneBean {
	 private String phoneNumber;
	 private Integer numberValue;
	 private Integer lastTwoNumberValue;
	 private Integer lastFourNumberValue;
	 
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getNumberValue() {
		return numberValue;
	}
	public void setNumberValue(Integer numberValue) {
		this.numberValue = numberValue;
	}
	public Integer getLastTwoNumberValue() {
		return lastTwoNumberValue;
	}
	public void setLastTwoNumberValue(Integer lastTwoNumberValue) {
		this.lastTwoNumberValue = lastTwoNumberValue;
	}
	public Integer getLastFourNumberValue() {
		return lastFourNumberValue;
	}
	public void setLastFourNumberValue(Integer lastFourNumberValue) {
		this.lastFourNumberValue = lastFourNumberValue;
	}
	
	@Override
	public String toString() {
		return "PhoneBean {phoneNumber=" + phoneNumber + ", numberValue="
				+ numberValue + ", lastTwoNumberValue=" + lastTwoNumberValue
				+ ", lastFourNumberValue=" + lastFourNumberValue + "}";
	}

}
