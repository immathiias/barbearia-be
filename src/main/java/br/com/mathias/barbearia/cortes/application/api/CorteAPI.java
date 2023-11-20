package br.com.mathias.barbearia.cortes.application.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/corte")
public interface CorteAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	CorteResponse postCorte(@RequestBody @Valid CorteRequest corteRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<CorteListResponse> getTodosCortes();

}
