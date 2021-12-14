package com.pe.nhtk.controller;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.nhtk.exception.ResourceNotFoundException;
import com.pe.nhtk.model.Empleado;
import com.pe.nhtk.repository.EmpleadoRepository;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {
	
	
	EmpleadoRepository empRepository;
	
	
	public EmpleadoController(EmpleadoRepository empRepository) {
		this.empRepository = empRepository;
	}

	
	
	@GetMapping("/getDepartments/{idDepartment}")
	public ResponseEntity<List<Empleado>> employeetwithFilterField( @PathVariable(value = "idDepartment")Long idDepartamento) throws ResourceNotFoundException{
		List<Empleado> empleado = empRepository.findByIdDepartamento(idDepartamento);
		Consumer<List<Empleado>> consumer1 = i -> System.out.println("consumidor 2"+ i);
		
//		empleado.stream().forEach(c -> { Empleado objEmpleado = new Empleado();
//		objEmpleado.setIdDepartamento(c.getClass().get);
//		});
		
		
		return ResponseEntity.ok(empleado);
	}

}
