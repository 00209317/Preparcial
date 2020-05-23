package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="importancia")
public class Importancia {
	
	
	@Id
	@Column(name="c_importancia")
	private int c_importancia;
	
	
	@Column(name="s_importancia")
	private String s_importancia;
	
	@OneToMany(mappedBy = "importancia", fetch = FetchType.EAGER)
	private List<Contribuyente> contribuyente;

	
	

	public List<Contribuyente> getContribuyente() {
		return contribuyente;
	}


	public void setContribuyente(List<Contribuyente> contribuyente) {
		this.contribuyente = contribuyente;
	}


	public int getC_importancia() {
		return c_importancia;
	}


	public void setC_importancia(int c_importancia) {
		this.c_importancia = c_importancia;
	}


	public String getS_importancia() {
		return s_importancia;
	}


	public void setS_importancia(String s_importancia) {
		this.s_importancia = s_importancia;
	}


	public Importancia() {
		
	}
	
	


	
	
}