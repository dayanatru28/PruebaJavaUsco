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

import com.example.demo.interfaceServices.IDocenteServices;
import com.example.demo.modelo.Docente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@RequestMapping
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class ControladorDocente {
	@Autowired
	private IDocenteServices service;
	
	@GetMapping("/listarDocentes")
	public List<Docente> listar(Model model) {
		List<Docente> docentes= service.listar();
		return docentes;
	}

	@GetMapping("/nuevoDocente")
	public Docente agregar(Model model) {
		Docente d = new Docente();
		return d;
	}
	
	@PostMapping("/guardarDocente")
	public int save(@RequestBody Docente d) {
		int var=service.save(d);
		return var;
	}
	
	@GetMapping("/editarDocente/{id}")
	public Optional<Docente> editar(@PathVariable("id") int id) {
		Optional<Docente>docente= service.listarId(id);
		return docente;
	}
	
	@GetMapping("/eliminarDocente/{id}")
	public int eliminar(@PathVariable("id") int id) {
		int var=service.delete(id);
		return var;
	}

}
