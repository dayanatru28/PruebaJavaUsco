package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaceServices.ICursoServices;
import com.example.demo.interfaceServices.IDocenteServices;
import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Docente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@RequestMapping
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class ControladorCurso {
	@Autowired	
	private ICursoServices service;
	@Autowired
	private IDocenteServices serviceDoc;
	
	@GetMapping("/listarCursos")
	public List<Curso> listar() {
		List<Curso> cursos= service.listar();
		return cursos;
	}
	
	@GetMapping("/nuevoCurso")
	public Map<String,Object> agregar() {
		Map<String,Object> map=new HashMap<>();
		List<Docente> docentes= serviceDoc.listar();
		map.put("docentes",docentes);
		map.put("curso", new Curso());
		return map;
	}
	
	@PostMapping("/guardarCurso")
	public int save(@RequestBody Curso c) {
		int var= service.save(c);
		return var;
	}
	
	@GetMapping("/editarCurso/{codigo}")
	public Map<String,Object> editar(@PathVariable("codigo") String codigo) {
		List<Docente> docentes= serviceDoc.listar();
		Map<String,Object> map=new HashMap<>();
		map.put("docentes",docentes);
		Optional<Curso>curso= service.listarId(codigo);
		map.put("curso",curso);
		return map;
	}
	
	@GetMapping("/eliminarCurso/{codigo}")
	public int eliminar(@PathVariable("codigo") String codigo) {
		int var= service.delete(codigo);
		return var;
	}


}
