package com.spring.ibvc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ibvc.model.Evento;
import com.spring.ibvc.repository.IbvcRepository;
import com.spring.ibvc.service.IbvcService;

@Service
public class IbvcServiceImpl implements IbvcService {

	@Autowired
	IbvcRepository ibvcRepository;
	
	@Override
	public List<Evento> findAll() {
		
		return ibvcRepository.findAll();
	}

	@Override
	public Evento findById(Long id) {
		
		return ibvcRepository.findById(id).get();
	}

	@Override
	public Evento save(Evento evento) {
		
		return ibvcRepository.save(evento);	
	}

}
