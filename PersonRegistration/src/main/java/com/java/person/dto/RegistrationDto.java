package com.java.person.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**
 * @author Ashwini.Gite
 *
 */
@Entity
@Table(name = "personInformation")
public class RegistrationDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int personalId;
	int userId;
	int roleId;
	String firstName;
	String middleName;
	String lastName;
	String gender;
	Timestamp dob;
	int age;
	String address;
	String city;
	String state;
	int pinCode;
	Long mobileNo;
	String physicalDisability;
	String maritalStatus;
	String educationalStatus;
	String birthSign;
	boolean approved;
	String email;
	
	public RegistrationDto() {
		
	}
	

	public RegistrationDto(int personalId, int userId, int roleId, String firstName, String middleName, String lastName,
			String gender, Timestamp dob, int age, String address, String city, String state, int pinCode,
			Long mobileNo, String physicalDisability, String maritalStatus, String educationalStatus, String birthSign,
			boolean approved, String email) {
		super();
		this.personalId = personalId;
		this.userId = userId;
		this.roleId = roleId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.age = age;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.mobileNo = mobileNo;
		this.physicalDisability = physicalDisability;
		this.maritalStatus = maritalStatus;
		this.educationalStatus = educationalStatus;
		this.birthSign = birthSign;
		this.approved = approved;
		this.email = email;
	}

	public int getPersonalId() {
		return personalId;
	}


	public void setPersonalId(int personalId) {
		this.personalId = personalId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Timestamp getDob() {
		return dob;
	}


	public void setDob(Timestamp dob) {
		this.dob = dob;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getPinCode() {
		return pinCode;
	}


	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}


	public Long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getPhysicalDisability() {
		return physicalDisability;
	}


	public void setPhysicalDisability(String physicalDisability) {
		this.physicalDisability = physicalDisability;
	}


	public String getMaritalStatus() {
		return maritalStatus;
	}


	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}


	public String getEducationalStatus() {
		return educationalStatus;
	}


	public void setEducationalStatus(String educationalStatus) {
		this.educationalStatus = educationalStatus;
	}


	public String getBirthSign() {
		return birthSign;
	}


	public void setBirthSign(String birthSign) {
		this.birthSign = birthSign;
	}


	public boolean isApproved() {
		return approved;
	}


	public void setApproved(boolean approved) {
		this.approved = approved;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "RegistrationDto [personalId=" + personalId + ", userId=" + userId + ", roleId=" + roleId
				+ ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", gender="
				+ gender + ", dob=" + dob + ", age=" + age + ", address=" + address + ", city=" + city + ", state="
				+ state + ", pinCode=" + pinCode + ", mobileNo=" + mobileNo + ", physicalDisability="
				+ physicalDisability + ", maritalStatus=" + maritalStatus + ", educationalStatus=" + educationalStatus
				+ ", birthSign=" + birthSign + ", approved=" + approved + "]";
	}



	
	
	
}
