package com.pe.nhtk.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VW_DEPARTMENTS", schema = "HR")
public class Departments  implements Serializable {

	 
	private static final long serialVersionUID = 1L;
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	@Column(name = "DEPARTMENT_ID ")
	private Long idDepartamento;

	
	@Id
	@Column(name = "DEPARTMENT_NAME")
	private String nombreDepartamento;
	
	
	@Column(name = "LOCATION_ID")
	private Integer idLocacion;

	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public Integer getIdLocacion() {
		return idLocacion;
	}

	public void setIdLocacion(Integer idLocacion) {	
		this.idLocacion = idLocacion;
	}

	
	
	
}


