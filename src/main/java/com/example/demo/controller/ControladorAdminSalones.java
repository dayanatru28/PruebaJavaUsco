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

import com.example.demo.interfaceServices.IAdminSalonesServices;
import com.example.demo.interfaceServices.ICursoServices;
import com.example.demo.interfaceServices.ISalonesServices;
import com.example.demo.modelo.AdminSalones;
import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Salones;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@RestController
@RequestMapping
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")

public class ControladorAdminSalones {
	@Autowired
	private IAdminSalonesServices services;
	@Autowired
	private ISalonesServices servicesSalones;
	@Autowired
	private ICursoServices servicesCurso;
	
	
		@GetMapping("/listarAdminSalones")
		public List<AdminSalones> listar() {
			List<AdminSalones> salones= services.listar();
			return salones;
		}
		
		@GetMapping("/nuevoAdminSalones")
		public Map<String,Object> agregar() {
			Map<String,Object> map=new HashMap<>();
			List<Curso> cursos= servicesCurso.listar();
			map.put("cursos",cursos);
			List<Salones> salones= servicesSalones.listar();
			map.put("salones",salones);
			map.put("adminSalones", new AdminSalones());
			return map;
		}

		@PostMapping("/guardarAdminSalones")
		public int save(@RequestBody AdminSalones p) {
			int var = services.save(p);
			return var;
		}
		
		@GetMapping("/editarAdminSalones/{id}")
		public Map<String,Object> editar(@PathVariable("id") int id) {
			
			Map<String,Object> map=new HashMap<>();
			List<Curso> cursos= servicesCurso.listar();
			map.put("cursos",cursos);
			List<Salones> salones= servicesSalones.listar();
			map.put("salones",salones);
			Optional<AdminSalones>adminSalones= services.listarId(id);
			map.put("adminSalones",adminSalones);
			return map;
		}
		
		@GetMapping("/eliminarAdminSalones/{id}")
		public int eliminar(@PathVariable("id") int id) {
			int var=services.delete(id);	
			return var;
		}

}
