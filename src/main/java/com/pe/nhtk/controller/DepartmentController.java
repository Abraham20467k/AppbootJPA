package com.pe.nhtk.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.nhtk.exception.ResourceNotFoundException;
import com.pe.nhtk.expose.request.Departamento;
import com.pe.nhtk.model.Departments;
import com.pe.nhtk.model.DepartmentsResponse;
import com.pe.nhtk.model.LocationDTO;
import com.pe.nhtk.model.LocationResponse;
import com.pe.nhtk.repository.DepartmentsRepository;

import oracle.jdbc.proxy.annotation.Post;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

	DepartmentsRepository departmentRepository;

	public DepartmentController(DepartmentsRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@GetMapping("/getseqdept")
	public BigDecimal getDeparmentSeq() {
		return departmentRepository.getNextValMySequence();

	}

	@GetMapping("/employees")
	public List<Departments> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@GetMapping("/getDepartment/{id}")
	public ResponseEntity<DepartmentsResponse> departament(@PathVariable(value = "id") Long departmentid)
			throws ResourceNotFoundException {
		Optional<String> department = Optional.ofNullable(departmentRepository.getDepartamente(departmentid));
		DepartmentsResponse response = new DepartmentsResponse();
		if (department.isPresent()) {
			response.setNomDepartmento(department.get());
		}

		return ResponseEntity.ok(response);
	}

	@GetMapping("/getDepartment/{idDepartment}/{idLocation}")
	public ResponseEntity<DepartmentsResponse> departamentwithFilter(
			@PathVariable(value = "idDepartment") Long departmentid,
			@PathVariable(value = "idLocation") Integer locationid) throws ResourceNotFoundException {
		Optional<String> department = Optional
				.ofNullable(departmentRepository.getDepartamentwithFilter(departmentid, locationid));
		DepartmentsResponse response = new DepartmentsResponse();
		if (department.isPresent()) {
			response.setNomDepartmento(department.get());
		}

		return ResponseEntity.ok(response);

	}

	@GetMapping("/getDepartments/{idLocation1}/{idDepartment}")
	public ResponseEntity<List<DepartmentsResponse>> departamentwithFilterField(
			@PathVariable(value = "idLocation1") Long idLocation,
			@PathVariable(value = "idDepartment") Integer nombreDepartamento) throws ResourceNotFoundException {
//		public ResponseEntity<List<DepartmentsResponse>> departamentwithFilterField(@PathVariable(value = "idLocation1")Long idLocation, @PathVariable(value = "idDepartment")Integer nombreDepartamento) throws ResourceNotFoundException{

		List<Departments> department = departmentRepository.findByIdDepartamentoAndIdLocacion(idLocation,
				nombreDepartamento);
//		Optional<List<Departments>> department = Optional.ofNullable(departmentRepository.findByIdDepartamnetoAndIdLocacion(idLocation, nombreDepartamento));
//		Optional<List<Departments>> department = Optional.ofNullable(departmentRepository.findByIdDepartamnetoAndIdLocacion(idLocation, nombreDepartamento));
//		Optional<List<Departments>> department = Optional.ofNullable(departmentRepository.findByCodDepart(idLocation, nombreDepartamento));
//		Optional<List<Departments>> department = Optional.ofNullable(departmentRepository.findByIdLocacionAndIdDepartamento(idLocation, nombreDepartamento));

//		departmentRepository.findByIdDepartamentoAndIdLocacion(idLocation, nombreDepartamento).stream().forEach(e -> System.out.print(e.getNombreDepartamento()));;
//		List<Departments> objLista = new ArrayList<>();
		List<DepartmentsResponse> objListResponse = new ArrayList<DepartmentsResponse>();
		objListResponse = department.stream().map(p -> new DepartmentsResponse(String.valueOf(p.getIdDepartamento()),
				p.getNombreDepartamento(), String.valueOf(p.getIdLocacion()))).collect(Collectors.toList());
		return ResponseEntity.ok(objListResponse);
	}

	@GetMapping("/getDepartmentDinamic/{idDepartment}/{nombreDepartamento}")
	public ResponseEntity<DepartmentsResponse> departamentDinamic(
			@PathVariable(value = "idDepartment") Long departmentid,
			@PathVariable(value = "nombreDepartamento") String nombreDepartamento) throws ResourceNotFoundException {
		Optional<String> department = Optional
				.ofNullable(departmentRepository.getidLocation(departmentid, nombreDepartamento));
		DepartmentsResponse response = new DepartmentsResponse();
		if (department.isPresent()) {
			response.setNomDepartmento(department.get());
		}

		return ResponseEntity.ok(response);

	}

//	public ResponseEntity<LocationResponse> 

	@GetMapping("/getLocations/{idLocation}")
	public ResponseEntity<LocationResponse> location(@PathVariable(value = "idLocation") Integer idLocation)
			throws ResourceNotFoundException {
		Optional<List<Departments>> listDeparmants = Optional
				.ofNullable(departmentRepository.findByIdLocacion(idLocation));
		LocationResponse listaResponse = new LocationResponse();
		if (listDeparmants.isPresent()) {
			List<LocationDTO> respuesta= listDeparmants.get().stream().map(e -> new LocationDTO(String.valueOf(e.getIdDepartamento()),
					e.getNombreDepartamento(), String.valueOf(e.getIdLocacion()))).collect(Collectors.toList());
			listaResponse.setRespuesta(respuesta);
			
		}
		return ResponseEntity.ok(listaResponse);
	}
	
	
	@PostMapping("/postLocations")
	public ResponseEntity<LocationResponse> postLocation(@RequestBody Departamento departamento) throws Exception{
		return null;
		
	}
}
