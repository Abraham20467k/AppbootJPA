package com.pe.nhtk.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentsResponse {

	private String idDepartamento;
	private String nomDepartmento;
	private String ubicacion;
}
