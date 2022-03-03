package com.prueba.spring.api.activos.service;

import java.util.List;
import java.util.Optional;

import com.prueba.spring.api.activos.model.Activos;

public interface IActivosServices {
	
	List<Activos> searchAll();
	
	String addNew(Activos activo);
	
	Activos searchId(Long id);
	
	String deleteId(Long id);
}
