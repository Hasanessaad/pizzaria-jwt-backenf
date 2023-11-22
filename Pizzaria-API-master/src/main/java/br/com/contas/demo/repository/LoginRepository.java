package br.com.contas.demo.repository;
import java.util.Optional;

import br.com.contas.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<User, Long>{

    public Optional<User> findByUsername(String login);

}
