package com.snkit.impreativetoreactive;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="microservice",name="user_address")
public class UserAddressEntity implements Serializable {
	
	public UserAddressEntity() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="addid")
	private Long id;
	
	
	@Column(name="street")
	private String street;
	
	
	@Column(name="country")
	private String country;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="userid",referencedColumnName="id")
	private UserEntity userEntity;
	
	
	
	@OneToMany(mappedBy="addressEntity",cascade=CascadeType.ALL)	
	private List<PinCodeEntity> addressStateEntityList = new ArrayList<PinCodeEntity>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "UserAddressEntity [id=" + id + ", street=" + street + ", country=" + country + ", status=" + status
				+ ", userEntity=" + userEntity + ", getId()=" + getId() + ", getStreet()=" + getStreet()
				+ ", getCountry()=" + getCountry() + ", getStatus()=" + getStatus() + ", getUserEntity()="
				+ getUserEntity() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public List<PinCodeEntity> getAddressStateEntityList() {
		return addressStateEntityList;
	}

	public void setAddressStateEntityList(List<PinCodeEntity> addressStateEntityList) {
		this.addressStateEntityList = addressStateEntityList;
	}
	
	
	
	
}
