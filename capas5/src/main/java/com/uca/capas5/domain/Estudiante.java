package com.uca.capas5.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	
	@Id
	@GeneratedValue(generator="estudiante_id_estudiante_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "estudiante_id_estudiante_seq", sequenceName = "public.estudiante_id_estudiante_seq", allocationSize = 1)	
	@Column(name="id_estudiante")
	private Integer codigoestudiante;
	
	@Size(message="El campo no debe de tener más de 30 caracteres", max=30)
	@NotEmpty(message="El campo no debe estar vacío")
	@Column(name="nombre")
	private String nombre;
	
	@Size(message="El campo no debe de tener más de 30 caracteres", max=30)
	@NotEmpty(message="El campo no debe estar vacío")
	@Column(name="apellido")
	private String apellido;
	
	@Min(value=18,message="No puede ser menor a 18 años")
	@javax.validation.constraints.NotNull(message="El campo no puede estar vacío")
	@Column(name="edad")
	private Integer edad;
	
	@Column(name="estado")
	private Boolean estado;
	
	@OneToMany(mappedBy="estudiante",fetch=FetchType.EAGER)
	private List<Computadora> computadoras;
	
	public List<Computadora> getComputadoras() {
		return computadoras;
	}

	public void setComputadoras(List<Computadora> computadoras) {
		this.computadoras = computadoras;
	}

	public Estudiante()
	{
		
	}

	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	//Delegate para activo o inactivo
	public String getEstadoDelegate()
	{
		if(this.estado == null)
		{
			return "";
		}
		else
		{
			if(this.estado) return "ACTIVO";
			else return "INACTIVO";
		}
	}

	public Integer getCodigoestudiante() {
		return codigoestudiante;
	}

	public void setCodigoestudiante(Integer codigoestudiante) {
		this.codigoestudiante = codigoestudiante;
	}
		
	
}
