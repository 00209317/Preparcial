package com.uca.capas.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public",name="contribuyente")
public class Contribuyente {

	
	@Id
	@Column(name="c_contribuyente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int c_contribuyente;
	
	@Column(name="s_nombre")
	@Size(message = "El campo nombre no debe tener más de 30 caracteres", max=30)
	@NotEmpty(message = "El campo nombre no puede ser vacío")
	private String s_nombre;
	
	@Column(name="s_apellido")
	@Size(message = "El campo apellido no debe tener más de 30 caracteres", max=30)
	@NotEmpty(message = "El campo apellido no puede ser vacío")
	private String s_apellido;
	
	@Column(name="s_nit")
	@Size(message = "El campo nit no debe tener más de 14 caracteres", max=14)
	@NotEmpty(message = "El campo nit no puede ser vacío")
	private String s_nit;
	
	@Column(name="f_fecha_ingreso")
	@CreationTimestamp
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate f_fecha_ingreso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_importancia")
	private Importancia importancia;
	
	
	
	public Importancia getImportancia() {
		return importancia;
	}
	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}
	public int getC_contribuyente() {
		return c_contribuyente;
	}
	public void setC_contribuyente(int c_contribuyente) {
		this.c_contribuyente = c_contribuyente;
	}

	public String getS_nombre() {
		return s_nombre;
	}
	public void setS_nombre(String s_nombre) {
		this.s_nombre = s_nombre;
	}
	public String getS_apellido() {
		return s_apellido;
	}
	public void setS_apellido(String s_apellido) {
		this.s_apellido = s_apellido;
	}
	public String getS_nit() {
		return s_nit;
	}
	public void setS_nit(String s_nit) {
		this.s_nit = s_nit;
	}
	public LocalDate getF_fecha_ingreso() {
		return f_fecha_ingreso;
	}
	public void setF_fecha_ingreso(LocalDate f_fecha_ingreso) {
		this.f_fecha_ingreso = f_fecha_ingreso;
	}
	public Contribuyente() {
		
	}
	
	
	
}