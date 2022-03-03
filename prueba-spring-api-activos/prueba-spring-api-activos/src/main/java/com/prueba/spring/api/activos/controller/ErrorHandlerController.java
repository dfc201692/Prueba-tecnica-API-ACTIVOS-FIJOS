package com.prueba.spring.api.activos.controller;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.prueba.spring.api.activos.dto.ResponseDto;
import com.prueba.spring.api.activos.utilis.Contantes;

@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(NotFoundException.class)
	public ResponseDto errorNoFound(Exception ex) {
		ResponseDto resInfo = new ResponseDto();
		resInfo.setCode(500);
		resInfo.setMsg(ex.getMessage());
		return resInfo;
	}
}
