package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.entity.MedicoSucursal;
import com.veterinaria.repository.MedicoSucursalRepository;


@Service
public class MedicoSucursalService {
	@Autowired
	private MedicoSucursalRepository medicoSucursalRepository;

		public List<MedicoSucursal> findAll(){
			return medicoSucursalRepository.findAll();
		}
		public Optional<MedicoSucursal> findById(Long id){
			return medicoSucursalRepository.findById(id);
		}
		public MedicoSucursal save(MedicoSucursal medicoSucursal) {
			return medicoSucursalRepository.save(medicoSucursal);
		}
		public void deleteById(Long id) {
			medicoSucursalRepository.deleteById(id);
		}
}
