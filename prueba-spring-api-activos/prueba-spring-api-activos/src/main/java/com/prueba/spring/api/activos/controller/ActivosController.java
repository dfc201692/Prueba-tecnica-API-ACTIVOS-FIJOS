package com.prueba.spring.api.activos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.spring.api.activos.dto.ResponseDto;
import com.prueba.spring.api.activos.model.Activos;
import com.prueba.spring.api.activos.service.IActivosServices;
import com.prueba.spring.api.activos.utilis.Contantes;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(value = "activos")
public class ActivosController {
	
	@Autowired()
	private IActivosServices ActivosServices;
	
	@GetMapping(value="/todo")
	private ResponseDto BuscarTodo(){
		ResponseDto resInfo = new ResponseDto();
		try {	
			List<Activos> lista =  ActivosServices.searchAll();
			resInfo.setCode(404);
			resInfo.setMsg(Contantes.MSG_ERROR_404);
			if(lista.size()>0) {
				resInfo.setCode(200);
				resInfo.setMsg(Contantes.MSG_EXITOSO_200);
				resInfo.setInfo(lista);
			}
			return resInfo;
		} catch (Exception e) {
			resInfo.setCode(500);
			resInfo.setMsg(e.getMessage());
			return resInfo;
		}
	}
	
	@PostMapping(value = "/nuevo")
	private ResponseDto AgregarActivo(Activos activo) {
		ResponseDto resInfo = new ResponseDto();
		try {	
			resInfo.setCode(200);
			resInfo.setMsg(Contantes.MSG_SAVE_200);
			ActivosServices.addNew(activo);
			return resInfo;
		} catch (Exception e) {
			resInfo.setCode(500);
			resInfo.setMsg(e.getMessage());
			return resInfo;
		}
	}
	
	@PutMapping(value="/editar")
	private ResponseDto EditarActivo(Activos activo) {
		ResponseDto resInfo = new ResponseDto();
		try {			
			resInfo.setCode(400);
			resInfo.setMsg(Contantes.MSG_ERROR_400);
			if(activo.getId()>0) {
				Activos activoInfo = ActivosServices.searchId(activo.getId());
				if(activoInfo.getId()>0) {
					activoInfo = activo; 
					ActivosServices.addNew(activoInfo);
					resInfo.setCode(200);
					resInfo.setMsg(Contantes.MSG_EDIT_200);
				}
			}
			return resInfo;
		} catch (Exception e) {
			resInfo.setCode(500);
			resInfo.setMsg(e.getMessage());
			return resInfo;
		}
	}
	
	@GetMapping(value="/buscar/{id}")
	private ResponseDto BuscarId(@PathVariable(value = "id") Long id) {
		ResponseDto resInfo = new ResponseDto();
		try {			
			Activos activoInfo = ActivosServices.searchId(id);
			resInfo.setCode(404);
			resInfo.setMsg(Contantes.MSG_ERROR_404);
			if(activoInfo.getId()>0) {
				List<Activos> listActivos = new ArrayList<Activos>();
				listActivos.add(activoInfo);
				resInfo.setCode(200);
				resInfo.setMsg(Contantes.MSG_EXITOSO_200);
				resInfo.setInfo(listActivos);
			}
			return resInfo;
		} catch (Exception e) {
			resInfo.setCode(500);
			resInfo.setMsg(e.getMessage());
			return resInfo;
		}
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	private ResponseDto EliminarActivo(@PathVariable(value ="id") Long id) {
		ResponseDto resInfo = new ResponseDto();
		try {			
			Activos activoInfo = ActivosServices.searchId(id);
			resInfo.setCode(404);
			resInfo.setMsg(Contantes.MSG_ERROR_404);
			if(activoInfo.getId()>0) {
				ActivosServices.deleteId(id);
				resInfo.setCode(200);
				resInfo.setMsg(Contantes.MSG_DELETE_200);
			}
			return resInfo;
		} catch (Exception e) {
			resInfo.setCode(500);
			resInfo.setMsg(e.getMessage());
			return resInfo;
		}
	}

}
