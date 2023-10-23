package br.com.contas.demo.repository;

import br.com.contas.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Client_Repository extends JpaRepository<Client, Long> {

    Optional<Client> findByNome(String name);
    Optional<Client> findById(Long id);



}
