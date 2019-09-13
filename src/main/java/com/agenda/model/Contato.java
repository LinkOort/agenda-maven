package com.agenda.model;

public class Contato {

	
	private long idContato;
	private String tel;
	private String email;
	public long getId() {
		return idContato;
	}
	public void setId(long id) {
		this.idContato = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
