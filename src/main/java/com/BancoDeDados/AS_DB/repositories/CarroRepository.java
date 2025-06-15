package com.BancoDeDados.AS_DB.repositories;

import com.BancoDeDados.AS_DB.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface CarroRepository extends JpaRepository<Carro,Integer> {

}
