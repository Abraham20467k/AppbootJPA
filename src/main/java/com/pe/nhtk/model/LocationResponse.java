package com.pe.nhtk.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
public class LocationResponse {
	
	private List<LocationDTO> respuesta;

}
