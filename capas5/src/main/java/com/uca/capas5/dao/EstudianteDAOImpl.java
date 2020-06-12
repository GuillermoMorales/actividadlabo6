package com.uca.capas5.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas5.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO{
	
	@PersistenceContext(unitName="capas5")
	private EntityManager entityManager;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException
	{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.estudiante");
		javax.persistence.Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
		List<Estudiante> resulset = query.getResultList();
		
		return resulset;
	}
	
	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException
	{
		try
		{
			if(estudiante.getCodigoestudiante() == null)
			{
				entityManager.persist(estudiante);
			}
			else
			{
				entityManager.merge(estudiante);
				entityManager.flush();
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	@Transactional
	public void delete(Integer codigoEstudiante) throws DataAccessException
	{
		Estudiante estudiante = entityManager.find(Estudiante.class, codigoEstudiante);
		entityManager.remove(estudiante);
	}
	
	
	@Override
	public Estudiante findOne(Integer code) throws DataAccessException
	{
		Estudiante estudiante = entityManager.find(Estudiante.class, code);
		return estudiante;
	}
	
}
