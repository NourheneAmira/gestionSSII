package com.example.ssii.repository;


import com.example.ssii.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {

} 
