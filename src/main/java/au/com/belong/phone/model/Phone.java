package au.com.belong.phone.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Attributes of Phone Object
 */
@Entity
@Table(name = "PhoneDetails")
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String phoneId;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "isActive")
    private Boolean isActive;

    @Column(name = "customerId")
    private String customerId;
    
    public Phone(String phoneId, String phoneNumber, Boolean isActive, String customerId)
    {
    	this.phoneId = phoneId;
    	this.phoneNumber = phoneNumber;
    	this.isActive = isActive;
    	this.customerId = customerId;
    }

	public String getPhoneId() {
		return phoneId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getCustomerId() {
		return customerId;
	}
}
