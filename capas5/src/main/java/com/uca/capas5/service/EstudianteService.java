package com.uca.capas5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas5.domain.Estudiante;


public interface EstudianteService {

	public List<Estudiante> findAll()throws DataAccessException;
	
	public Estudiante findOne(Integer code) throws DataAccessException;
	
	public void save(Estudiante estudiante) throws DataAccessException;
	
	public void delete(Integer codigoEstudiante) throws DataAccessException;

	public List<Estudiante> filtrar(String cadena) throws DataAccessException;

	public List<Estudiante> empezar(String cadena) throws DataAccessException;
	
	
}
