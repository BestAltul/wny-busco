package com.wnybusco.depew.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wnybusco.depew.model.Fleet;

@Repository
public interface FleetRepository extends JpaRepository<Fleet,Integer>{

}
