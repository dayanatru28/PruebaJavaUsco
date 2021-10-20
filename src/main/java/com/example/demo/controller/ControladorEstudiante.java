package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaceServices.IEstudianteServices;
import com.example.demo.modelo.Estudiante;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@RequestMapping
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class ControladorEstudiante {
	
	@Autowired
	private IEstudianteServices service;
	
	//Definir ruta
	@GetMapping("/listarEstudiantes")
	public List<Estudiante> listar() {
		List<Estudiante> estudiante= service.listar();
		return estudiante ;
	}

	@GetMapping("/nuevoEstudiante")
	public Estudiante agregar(Model model) {
		Estudiante e =new Estudiante();
		return e;
	}
	
	@PostMapping("/guardarEstudiante")
	public int save(@RequestBody Estudiante e) {
		int var= service.save(e);
		return var;
	}
	
	@GetMapping("/editarEstudiante/{id}")
	public Optional<Estudiante> editar(@PathVariable("id") int id) {
		Optional<Estudiante>estudiante= service.listarId(id);
		return estudiante;
	}
	
	@GetMapping("/eliminarEstudiante/{id}")
	public int eliminar(@PathVariable("id") int id) {
		int var= service.delete(id);
		return var;
	}
}
