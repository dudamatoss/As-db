package com.BancoDeDados.AS_DB.repositories;

import com.BancoDeDados.AS_DB.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor,Integer> {
}
