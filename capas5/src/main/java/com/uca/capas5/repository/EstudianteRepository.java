package com.uca.capas5.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas5.domain.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{
	
	public List<Estudiante> findByNombre(String cadena) throws DataAccessException;
	
	public List<Estudiante> findByApellidoStartingWith(String cadena) throws DataAccessException;

}
