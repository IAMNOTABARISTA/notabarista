package com.example.demo;

import com.example.demo.Notabarista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotabaristaRepository extends JpaRepository<Notabarista, Integer>, JpaSpecificationExecutor<Notabarista> {

}