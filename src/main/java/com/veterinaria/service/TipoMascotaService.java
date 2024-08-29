package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.entity.TipoMascota;
import com.veterinaria.repository.TipoMascotaRepository;

@Service
public class TipoMascotaService {
	@Autowired
	private TipoMascotaRepository tipoMascotaRepository;

		public List<TipoMascota> findAll(){
			return tipoMascotaRepository.findAll();
		}
		public Optional<TipoMascota> findById(Long id){
			return tipoMascotaRepository.findById(id);
		}
		public TipoMascota save(TipoMascota tipoMascota) {
			return tipoMascotaRepository.save(tipoMascota);
		}
		public void deleteById(Long id) {
			tipoMascotaRepository.deleteById(id);
		}
}
