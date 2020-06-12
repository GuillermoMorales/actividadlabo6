package com.uca.capas5.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas5.dao.EstudianteDAO;
import com.uca.capas5.domain.Estudiante;
import com.uca.capas5.service.EstudianteService;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@RequestMapping("/")
	public ModelAndView initMain2()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main2");
		return mav;
	}
	
	@RequestMapping(value="/mostrarEstudiante2", method=RequestMethod.POST)
	public ModelAndView finOnedos(@RequestParam(value="codigo")int id)
	{
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = estudianteService.findOne(id);
		mav.addObject("estudiante",estudiante);
		mav.setViewName("estudiante2");
		return mav;
	}
	
	//Mostrar lista de Estudiantes 
	@RequestMapping("/estudiante")
	public ModelAndView initMain()
	{
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try
		{
			estudiantes = estudianteService.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("main");
		
		return mav;
	}
	
	@RequestMapping(value="/mostrarEstudiante",method=RequestMethod.POST)
	public ModelAndView findOne(@RequestParam(value="codigo")int id)
	{
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = null;
		try
		{
			estudiante = estudianteService.findOne(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mav.addObject("estudiante",estudiante);
		mav.setViewName("estudiante");
		return mav;
	}
	
	@RequestMapping("/filtrarEstudiante")
	public ModelAndView filtrarEstudiante(@RequestParam(value="nombre")String cadena)
	{
		ModelAndView mav = new ModelAndView();		
		List<Estudiante> estudiantes = null;
		try
		{
			estudiantes = estudianteService.filtrar(cadena);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/empezarEstudiante")
	public ModelAndView empezarEstudiante(@RequestParam(value="apellido")String cadena)
	{
		ModelAndView mav = new ModelAndView();		
		List<Estudiante> estudiantes = null;
		try
		{
			estudiantes = estudianteService.empezar(cadena);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("main");
		return mav;
	}
	
	
	
	@RequestMapping("/save")
	public ModelAndView guardar(@Valid @ModelAttribute Estudiante estudiante, BindingResult result)
	{
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors())
		{
			mav.setViewName("agregarEstudiante");
		}
		else
		{
			estudianteService.save(estudiante);
			List<Estudiante> estudiantes = null;
			try
			{
				estudiantes = estudianteService.findAll();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			mav.addObject("estudiantes", estudiantes);
			mav.setViewName("listaEstudiante");
		}
		
		
		return mav;

}
	@RequestMapping(value="/borrarEstudiante", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam (value="codigo")int id)
	{
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try
		{
			estudianteService.delete(id);
			estudiantes = estudianteService.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/insertarEstudiante")
	public ModelAndView inicio()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("agregarEstudiante");
		return mav;
	}
	
	@RequestMapping("/buscareditar")
	public ModelAndView buscar16(@RequestParam Integer codigo) {
		ModelAndView mav = new ModelAndView();
		Estudiante e = estudianteService.findOne(codigo);
		mav.addObject("estudiante", e);
		mav.setViewName("editar");
		return mav;
	}
	
	@RequestMapping("/editarEstudiante")
	public ModelAndView editarEstudiantet(@ModelAttribute Estudiante estudiante) {
		ModelAndView mav = new ModelAndView();
		//Mando a llamar al servicio encargado de guardar a la entidad
		estudianteService.save(estudiante);
		List<Estudiante> estudiantes = null;
		try
		{			
			estudiantes = estudianteService.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("main");
		mav.addObject("resultado", 1);
		return mav;
	}
}
