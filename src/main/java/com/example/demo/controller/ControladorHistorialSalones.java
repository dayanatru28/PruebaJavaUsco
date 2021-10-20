package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaceServices.IAdminSalonesServices;
import com.example.demo.modelo.AdminSalones;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@RequestMapping
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class ControladorHistorialSalones {
	
	@Autowired
	private IAdminSalonesServices services;

	@GetMapping("/buscarSalon/{id}")
	public Map<String,List<AdminSalones>> listar(@PathVariable("id") int id) {
		java.util.Date fecha = new Date();
		Map<String,List<AdminSalones>> map=new HashMap<>();
		List<AdminSalones> datosMenores= services.listarReportesMenores(id,fecha);
		map.put("datosMenores", datosMenores);
		List<AdminSalones> datosMayores= services.listarReportesMayores(id,fecha);
		map.put("datosMayores", datosMayores);
		return map;
	}

}
