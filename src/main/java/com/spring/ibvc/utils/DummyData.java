	package com.spring.ibvc.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.ibvc.model.Evento;
import com.spring.ibvc.repository.IbvcRepository;

@Component
public class DummyData {
	@Autowired
	IbvcRepository ibvcRepository;
		
	   //@PostConstruct
		public void saveEventos(	) {
			List<Evento> eventolist = new ArrayList<>();
			
			Evento evento1 = new Evento();
			evento1.setNome("Baile da Cidade");
			evento1.setLocal("Salao de festa");
			evento1.setHora("22:00");
			//evento1.setData(LocalDate.now());
			
			
			
			Evento evento2 = new Evento();
			evento2.setNome("Baile de Formatura ");
			evento2.setLocal("Salao da Igreja");
			evento2.setHora("20:00");
			//evento2.setData(LocalDate.now());
			
			eventolist.add(evento1);
			eventolist.add(evento2);
			
			for (Evento evento : eventolist) {
				Evento eventoSaved = ibvcRepository.save(evento);
				System.out.println(eventoSaved.getId());
			}
			
		}
	
}
