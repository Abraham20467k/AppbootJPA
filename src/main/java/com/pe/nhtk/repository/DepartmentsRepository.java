package com.pe.nhtk.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pe.nhtk.model.Departments;


@Repository
public interface DepartmentsRepository  extends JpaRepository<Departments, Long>{

	
	
	@Query(value = "SELECT HR.DEPARTMENTS_SEQ.NEXTVAL FROM dual", nativeQuery = true)
    public BigDecimal getNextValMySequence();

//	@Query("select codDepart.nombreDepartamento from Departments where  codDepart.idDepartamento = ?1")
	@Query("select nombreDepartamento from Departments where  idDepartamento = ?1")
	String getDepartamente(Long idDepartamento);
	
	
	@Query("select nombreDepartamento from Departments where  idDepartamento = ?1 and idLocacion = ?2 ")
//	@Query("select codDepart.nombreDepartamento from Departments where  codDepart.idDepartamento = ?1 and idLocacion = ?2 ")
	String getDepartamentwithFilter(Long idDepartamento, Integer idLocation );

	
//	String getDepartamentwithFilterField(@Param("idDepartamento")Long idDepartamento, String idLocation );
	
//	List<Departments>  findByIdDepartamentoAndIdLocacion (Long idLocacion, Integer idUbicacion);
	
	
//	@Query(value="select * from HR.VW_DEPARTMENTS a where  a.LOCATION_ID= :idUbicacion  and   a.DEPARTMENT_ID = :idLocacion ", nativeQuery=true)
	
//	idDepartamento  idLocacion
//	@Query("select d from Departments d where   (d.idDepartamento = :idDepartamento) and (idLocacion = :idLocacion)   ")
//	List<Departments>  findByCodDepart (Long idLocacion, Integer  idUbicacion);
	List<Departments> findByIdDepartamentoAndIdLocacion(Long inventoryIdList,Integer idLocacion);
//	List<Departments> findByIdDepartamnetoAndIdLocacion(@Param("idDepartamento") Long inventoryIdList,@Param("idLocacion") Integer idLocacion);
//	List<Departments>  findByIdLocacionAndIdDepartamento (Long idLocacion, Integer  idUbicacion);
	
	
	/// metodo que no funciona
//	List<Departments>  findByCodDepart (DepartmentsPK  depPK);
	
	@Query(value="select :nombreDepartamento from HR.VW_DEPARTMENTS a where  a.DEPARTMENT_ID= :idDepartamento", nativeQuery=true)
	String getidLocation (Long idDepartamento, String nombreDepartamento );
	
	
	List<Departments> findByIdLocacion(Integer idLocacion);
	
	
	 
	
}
