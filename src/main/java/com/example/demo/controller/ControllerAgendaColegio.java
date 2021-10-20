package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaceServices.IAdminSalonesServices;
import com.example.demo.interfaceServices.ICursoEstudianteServices;
import com.example.demo.modelo.AdminSalones;
import com.example.demo.modelo.CursoEstudiante;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@RequestMapping
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class ControllerAgendaColegio {
	@Autowired
	private IAdminSalonesServices services;
	@Autowired
	private ICursoEstudianteServices servicesCursoEst;
	
	@GetMapping("/")
	public List<AdminSalones> index() {
		List<AdminSalones> salones= services.listar();
		return salones;

	}
	@GetMapping("/listarEstCurso/{codigo}")
	public List<CursoEstudiante> listarEstCurso(@PathVariable("codigo") String codigo) {
		List<CursoEstudiante> listado=servicesCursoEst.listarEst(codigo);
		return listado;
	}
}
