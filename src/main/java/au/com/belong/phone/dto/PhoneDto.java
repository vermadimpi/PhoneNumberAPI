package au.com.belong.phone.dto;

import java.io.Serializable;

public class PhoneDto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String phoneNumber;

    private Boolean active;

	public String getPhonenumber() {
		return this.phoneNumber;
	}

	public void setPhonenumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
