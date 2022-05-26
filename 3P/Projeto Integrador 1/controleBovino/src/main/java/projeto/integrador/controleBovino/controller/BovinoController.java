package projeto.integrador.controleBovino.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.integrador.controleBovino.modelo.Bovino;
import projeto.integrador.controleBovino.repository.BovinoRepository;

@RestController()
@RequestMapping("/bovino")
public class BovinoController {
	
	@Autowired
	private BovinoRepository bovinoRepository;
	
	@GetMapping()
	public List<Bovino> listarTodos() {
		return bovinoRepository.findAll();
	}
	
	@GetMapping("/relatorio")
	public List<Bovino> listarAbate() {
		List<Bovino> bovinosLst = bovinoRepository.findAll();
		
		List<Bovino> bovinosAAbater =  new ArrayList<Bovino>();
		
		for (Bovino bovino : bovinosLst) {
			if (bovino.getNascimento().plus(5, ChronoUnit.YEARS).isBefore(LocalDate.now()) ||
					bovino.getLitrosLeite() < 40 || 
					(bovino.getLitrosLeite() < 70 && bovino.getQuilosRacao() > 50) ||
					bovino.getPeso().compareTo(new BigDecimal(270)) > 0) {
				bovinosAAbater.add(bovino);
			}
		}
		
		return bovinosAAbater;
	}
	
	@PostMapping
	public String criarBovino() {
		boolean criou = false;
		
		Bovino bovino = new Bovino("124", 52.0, 44.0, new BigDecimal(232), LocalDate.now().minus(7, ChronoUnit.DAYS));
		
		Bovino save = bovinoRepository.save(bovino);
		
		if (save != null)
			criou = true;
		
		return criou ? "Criou caralho" : "Fez merda aí Otário";
	}

}
