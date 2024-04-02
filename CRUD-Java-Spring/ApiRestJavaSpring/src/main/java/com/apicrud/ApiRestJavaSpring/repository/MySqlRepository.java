package com.apicrud.ApiRestJavaSpring.repository;

import com.apicrud.ApiRestJavaSpring.model.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MySqlRepository extends JpaRepository<Frete,Integer>  {

    Page<Frete> retornaFretePorDestino(String destino, Pageable pageable);
}
