package com.pe.nhtk.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "VW_EMPLOYEES", schema = "HR")
@Getter
@Setter
public class Empleado  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="EMPLOYEE_ID")
	private Long idEmpleado;

	@Column(name ="FIRST_NAME")
	private String nomEmple;
	
	
	@Column(name ="HIRE_DATE")
	private Date fechaIngreso;
	
	@Column(name ="SALARY")
	private double salario;
	
	@Column(name = "DEPARTMENT_ID ")
	private Long idDepartamento;
	
	

}
