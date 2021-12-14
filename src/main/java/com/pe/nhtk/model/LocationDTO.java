package com.pe.nhtk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

	private String idDepartamento;
	private String nomDepartamento;
	private String ubicacion;
}
