package com.snkit.impreativetoreactive;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="microservice",name="user_add_state")
public class PinCodeEntity implements Serializable {
	
	public PinCodeEntity() {
		
		
	}
	
	@Id
	@Column(name="uasid")
	private Long uasid;
	
	@Column(name="pincode")
	private String pincode;
	
	
	@ManyToOne
	@JoinColumn(name="addid",referencedColumnName="addid")
	UserAddressEntity addressEntity;


	public Long getUasid() {
		return uasid;
	}


	public void setUasid(Long uasid) {
		this.uasid = uasid;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public UserAddressEntity getAddressEntity() {
		return addressEntity;
	}


	public void setAddressEntity(UserAddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}


	@Override
	public String toString() {
		return "PinCodeEntity [uasid=" + uasid + ", pincode=" + pincode + "]";
	}



	
	
	
	
	
}
