package it.gpedulla.hellomvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.gpedulla.hellomvc.model.Studente;
import it.gpedulla.hellomvc.service.GestioneStudenti;
import jakarta.websocket.server.PathParam;

@Controller
public class IndexController {

	private GestioneStudenti gestioneStudenti = new GestioneStudenti();
	
	@GetMapping("/students")
	public String studenti(Model model) {
		Studente mario = new Studente();
		mario.setId(1L);
		mario.setName("Mario");
		Studente giuseppe = new Studente();
		giuseppe.setId(2L);
		giuseppe.setName("Giuseppe");
		Studente irene = new Studente();
		irene.setId(3L);
		irene.setName("Irene");
		
		
		List<Studente> studentiList = new ArrayList<>();
		studentiList.add(mario);
		studentiList.add(giuseppe);
		studentiList.add(irene);
		
		
		model.addAttribute("studentiList", studentiList);
		
		return "studenti";
	}
	
	
	@GetMapping("/greeting-redirect")
	public String redirect() {
		return "redirect:/students";
	}
	
	@GetMapping("/greeting")
	public String greeting() {
		return "greeting";
	}
	
	@GetMapping("/jsonvalue")
	@ResponseBody
	public String jsonvalue() {
		return "pippo";
	}

	
	@GetMapping("/ricerca/{id}")
	public String ricercaId(@PathVariable("id") Long id, Model model) {
		Studente studente = gestioneStudenti.getById(id);
		model.addAttribute("studente", studente);
		model.addAttribute("ricercaId", true);
		model.addAttribute("ricercaName", false);
		return "ricerca";
	}
	
	@GetMapping("/ricercaname")
	public String ricercaId(@RequestParam("name") String name, Model model) {
		List<Studente> students = gestioneStudenti.getByName(name);
		model.addAttribute("studentiList", students);
		model.addAttribute("ricercaId", false);
		model.addAttribute("ricercaName", true);
		return "ricerca";
	}
}
