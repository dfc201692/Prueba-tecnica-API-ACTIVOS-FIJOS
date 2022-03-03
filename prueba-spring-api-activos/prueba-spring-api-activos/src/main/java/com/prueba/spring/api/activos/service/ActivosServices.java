package com.prueba.spring.api.activos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.spring.api.activos.model.Activos;
import com.prueba.spring.api.activos.repository.ActivosRepository;

@Service
public class ActivosServices implements IActivosServices {

	@Autowired()
	private ActivosRepository ActivosReposistory;
	
	@Override
	public List<Activos> searchAll() {
		return (List<Activos>) ActivosReposistory.findAll();
	}

	@Override
	public String addNew(Activos activo) {
		ActivosReposistory.save(activo);
		return "Registro Ingresado";
	}

	@Override
	public Activos searchId(Long id) {
		return ActivosReposistory.findById(id).get();
	}

	@Override
	public String deleteId(Long id) {
		ActivosReposistory.deleteById(id);		
		return "Activo Eliminado";
	}

}
