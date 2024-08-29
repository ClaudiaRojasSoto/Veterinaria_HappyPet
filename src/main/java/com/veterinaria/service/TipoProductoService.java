package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.entity.TipoProducto;
import com.veterinaria.repository.TipoProductoRepository;

@Service
public class TipoProductoService {
	@Autowired
	private TipoProductoRepository tipoProductoRepository;

		public List<TipoProducto> findAll(){
			return tipoProductoRepository.findAll();
		}
		public Optional<TipoProducto> findById(Long id){
			return tipoProductoRepository.findById(id);
		}
		public TipoProducto save(TipoProducto tipoProducto) {
			return tipoProductoRepository.save(tipoProducto);
		}
		public void deleteById(Long id) {
			tipoProductoRepository.deleteById(id);
		}
}
