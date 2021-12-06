package com.albo.controlop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albo.controlop.model.Recinto;
import com.albo.controlop.service.IRecintoService;


@RestController
@RequestMapping("/recinto")
public class RecintoController {

	@Autowired
	private IRecintoService recintoService;

	/**
	 * Método que lista los recintos
	 * 
	 * @return Devuelve una lista de Recintos.
	 */
	@GetMapping(value = "/lista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recinto>> listaRecinto() {
		List<Recinto> lista = new ArrayList<>();

		lista = recintoService.findAll();

		return new ResponseEntity<List<Recinto>>(lista, HttpStatus.OK);
	}
}
