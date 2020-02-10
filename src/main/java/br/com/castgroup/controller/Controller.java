package br.com.castgroup.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.castgroup.models.Left;
import br.com.castgroup.models.Right;
import br.com.castgroup.services.Services;

@RestController
@RequestMapping(value = "/v1")
public class Controller {
	@Autowired
	private Services services;
	
	/**
	 * Método que salva o JSON na tabela TABLE_LEFT e atualiza caso já exista algum
	 * registro na base de dados.
	 * 
	 * @author Tiago Aschoff
	 * @return Left
	 */
	@PostMapping("/diff/{id}/left")
	public Left setLeft(@PathVariable(value = "id") long id, @RequestBody Left left) {
		return services.setLeft(id, left);
	}

	/**
	 * Método que salva o JSON na tabela TABLE_RIGHT e atualiza caso já exista algum
	 * registro na base de dados.
	 * 
	 * @author Tiago Aschoff
	 * @return Right
	 */
	@PostMapping("/diff/{id}/right")
	public Right setRight(@PathVariable(value = "id") long id, @RequestBody Right right) {
		return services.setRight(id, right);
	}

	/**
	 * Método que realiza a comparação dos JSON e retornar as inconsistencias.
	 * 
	 * @author Tiago Aschoff
	 * @return ResponseEntity<Map<String, String>>
	 */
	@GetMapping("/diff")
	public ResponseEntity<Map<String, String>> getDiff() {
		return services.getDiff();
	}

}