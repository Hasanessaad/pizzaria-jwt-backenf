package br.com.contas.demo.repository;

import br.com.contas.demo.entity.Delivery;
import br.com.contas.demo.entity.MetodoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
List<Delivery> findByMetodoEntrega (MetodoEntrega metodoEntrega);

}
