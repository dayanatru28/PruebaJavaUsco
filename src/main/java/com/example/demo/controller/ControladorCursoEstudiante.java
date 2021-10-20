package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.interfaceServices.ICursoEstudianteServices;
import com.example.demo.interfaceServices.ICursoServices;
import com.example.demo.interfaceServices.IEstudianteServices;
import com.example.demo.modelo.Curso;
import com.example.demo.modelo.CursoEstudiante;
import com.example.demo.modelo.Estudiante;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@RequestMapping
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class ControladorCursoEstudiante {
	@Autowired
	private ICursoEstudianteServices service;
	@Autowired
	private ICursoServices serviceCurso;
	@Autowired
	private IEstudianteServices serviceEst;
	

		@GetMapping("/listarCursoEstudiante")
		public List<CursoEstudiante> listar() {
			List<CursoEstudiante> cursosEst= service.listar();
			return cursosEst;
		}
		
		@GetMapping("/nuevoCursoEst")
		public Map<String,Object> agregar() {
			Map<String,Object> map=new HashMap<>();
			List<Curso> cursos= serviceCurso.listar();
			List<Estudiante> estudiantes= serviceEst.listar();
			map.put("cursos", cursos);
			map.put("estudiantes", estudiantes);
			map.put("cursoEstudiante", new CursoEstudiante());
			return map;
		}
		
		@PostMapping("/guardarCursoEst/")
		public int save(@RequestBody CursoEstudiante p) {
			int var= service.save(p);
			return var;
		}
		
		
		@GetMapping("/eliminarCursoEst/{id}")
		public int eliminar(@PathVariable("id") int id) {
			int var=service.delete(id);
			return var;
		}
}
