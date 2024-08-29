package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.entity.Sucursal;
import com.veterinaria.repository.SucursalRepository;


@Service
public class SucursalService {
	@Autowired
	private SucursalRepository sucursalRepository;

		public List<Sucursal> findAll(){
			return sucursalRepository.findAll();
		}
		public Optional<Sucursal> findById(Long id){
			return sucursalRepository.findById(id);
		}
		public Sucursal save(Sucursal sucursal) {
			return sucursalRepository.save(sucursal);
		}
		public void deleteById(Long id) {
			sucursalRepository.deleteById(id);
		}
		public List<Sucursal>obtenerSucursalesOrdenadas() {
           return sucursalRepository.findByOrderByNombreAsc();
        }
}