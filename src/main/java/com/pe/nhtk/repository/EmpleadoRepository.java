package com.pe.nhtk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.nhtk.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
	
	
	
	List<Empleado> findByIdDepartamento(Long idDepartamento);

}
