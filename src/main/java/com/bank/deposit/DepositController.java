package com.bank.deposit;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class DepositController {
	@Autowired
	private IDepositService service;
	
	@GetMapping("/list")
	public List<Deposit> listar(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Deposit> buscarPorId(Long id){
		return service.findById(id);
	}
	
	@PostMapping()
	public ResponseEntity<Map<String, Object>> guardar(@RequestBody Deposit deposit){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("Transacción", "Deposito");
		result.put("Mensaje", "Deposito realizado");
		
		Deposit depositsave = service.save(deposit);
		result.put("Deposito realizado", depositsave);
		//Enviar a kafka
		//producer.sendMessage(salesave);
		//
		return ResponseEntity.created(URI.create("/".concat(depositsave.getId().toString())))
				.contentType(MediaType.APPLICATION_JSON).body(result); 
	} 

}
