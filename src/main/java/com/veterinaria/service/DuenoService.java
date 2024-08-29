package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.entity.Dueno;
import com.veterinaria.repository.DuenoRepository;

@Service
public class DuenoService {
@Autowired
private DuenoRepository duenoRepository;

	public List<Dueno> findAll(){
		return duenoRepository.findAll();
	}
	public Optional<Dueno> findById(Long id){
		return duenoRepository.findById(id);
	}
	public Dueno save(Dueno dueno) {
		return duenoRepository.save(dueno);
	}
	public void deleteById(Long id) {
		duenoRepository.deleteById(id);
	}
}
