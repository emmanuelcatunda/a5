package com.example.a5.model;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "people")
public class Person implements Serializable {

	private static final long serialVersionUID = 5245359609623005818L;
	@Id
	private String id;
	private byte[] qrCode;
	private byte[] photo3x4;
	private String name;
	private String email;
	private String primaryPhoneNumber;
	private Map otherContacts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getQrCode() {
		return qrCode;
	}

	public void setQrCode(byte[] qrCode) {
		this.qrCode = qrCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimaryPhoneNumber() {
		return primaryPhoneNumber;
	}

	public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
		this.primaryPhoneNumber = primaryPhoneNumber;
	}

	public byte[] getPhoto3x4() {
		return photo3x4;
	}

	public void setPhoto3x4(byte[] photo3x4) {
		this.photo3x4 = photo3x4;
	}

	public Map getOtherContacts() {
		return otherContacts;
	}

	public void setOtherContacts(Map otherContacts) {
		this.otherContacts = otherContacts;
	}

}
