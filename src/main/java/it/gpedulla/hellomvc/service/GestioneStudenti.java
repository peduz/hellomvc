package it.gpedulla.hellomvc.service;

import java.util.ArrayList;
import java.util.List;

import it.gpedulla.hellomvc.model.Studente;

public class GestioneStudenti {

	
	public List<Studente> getAllStudents() {
		List<Studente> studenti = new ArrayList<>();
		
		Studente mario = new Studente();
		mario.setId(1L);
		mario.setName("Mario");
		
		Studente irene = new Studente();
		irene.setId(2L);
		irene.setName("Irene");
		
		Studente giuseppe = new Studente();
		giuseppe.setId(3L);
		giuseppe.setName("Giuseppe");
		
		Studente giuseppe2 = new Studente();
		giuseppe2.setId(4L);
		giuseppe2.setName("Giuseppe");
		
		
		studenti.add(mario);
		studenti.add(irene);
		studenti.add(giuseppe);
		studenti.add(giuseppe2);
		return studenti;
	}
	
	public Studente getById(Long id) {
		for(Studente s : getAllStudents()) {
			if(s.getId().equals(id)) {
				return s;
			}
		}
		return null;
	}
	
	public List<Studente> getByName(String name) {
		List<Studente> listaStudenti2 = new ArrayList<>();
		for(Studente s : getAllStudents()) {
			if(s.getName().equals(name)) {
				listaStudenti2.add(s);
			}
		}
		return listaStudenti2;
	}
	
}
