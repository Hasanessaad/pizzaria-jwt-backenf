package br.com.contas.demo.repository;

import br.com.contas.demo.entity.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long> {

    Sabor findByNome(String nome);


}
