package br.com.contas.demo.repository;

import br.com.contas.demo.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Adress_repository extends JpaRepository< Adress, Long> {


}
