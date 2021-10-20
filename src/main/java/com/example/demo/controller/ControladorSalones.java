package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaceServices.ISalonesServices;

import com.example.demo.modelo.Salones;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@RequestMapping
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class ControladorSalones {

	@Autowired
	private ISalonesServices service;
	
		@GetMapping("/listarSalones")
		public List<Salones> listar() {
			List<Salones> salones= service.listar();
			return salones;
		}

		@GetMapping("/nuevoSalon")
		public Salones agregar(Model model) {
			Salones s= new Salones();
			return s;
		}
		
		@PostMapping("/guardarSalon")
		public int save(@RequestBody Salones s) {
			int var=service.save(s);
			return var;
		}
		
		
		@GetMapping("/eliminarSalon/{id}")
		public int eliminar (@PathVariable("id") int id) {
			int var=service.delete(id);
			return var;
		}
}
