package com.uca.capas5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas5.dao.EstudianteDAO;
import com.uca.capas5.domain.Estudiante;
import com.uca.capas5.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	@Autowired
	EstudianteDAO estudianteDAO;
	@Autowired
	EstudianteRepository estudianteRepository;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException
	{
		return estudianteRepository.findAll();
	}
	
	@Override
	public Estudiante findOne(Integer code) throws DataAccessException{
		return estudianteRepository.getOne(code);
	}
	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException
	{
		estudianteRepository.save(estudiante);
	}
	
	@Override
	@Transactional
	public void delete (Integer codigoEstudiante) throws DataAccessException
	{
		estudianteRepository.deleteById(codigoEstudiante);
	}
	
	@Override
	@Transactional
	public List<Estudiante> filtrar (String cadena) throws DataAccessException
	{
		return estudianteRepository.findByNombre(cadena);
	}
	
	@Override
	@Transactional
	public List<Estudiante> empezar (String cadena) throws DataAccessException
	{
		return estudianteRepository.findByApellidoStartingWith(cadena);
	}
	
	

}
