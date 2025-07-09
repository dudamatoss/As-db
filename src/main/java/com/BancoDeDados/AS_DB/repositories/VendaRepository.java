package com.BancoDeDados.AS_DB.repositories;

import com.BancoDeDados.AS_DB.model.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Vendas,Integer> {
}
