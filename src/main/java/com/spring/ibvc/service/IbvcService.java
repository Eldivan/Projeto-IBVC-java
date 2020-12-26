package com.spring.ibvc.service;

import java.util.List;

import com.spring.ibvc.model.Evento;

public interface IbvcService {
	
	List<Evento>findAll();
	Evento findById(Long id);
	Evento save(Evento evento);
	
	
}
