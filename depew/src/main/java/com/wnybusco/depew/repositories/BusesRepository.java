package com.wnybusco.depew.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wnybusco.depew.model.BigBus;

@Repository
public interface BusesRepository extends JpaRepository<BigBus,Integer>{

}
