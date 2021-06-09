package br.com.apirest.repository;

import br.com.apirest.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
