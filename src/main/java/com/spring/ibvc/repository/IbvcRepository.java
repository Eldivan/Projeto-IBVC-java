package com.spring.ibvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ibvc.model.Evento;

@Repository
public interface IbvcRepository extends JpaRepository<Evento, Long>{

}
