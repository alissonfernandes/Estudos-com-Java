package br.com.apirest.service;

import br.com.apirest.model.Pessoa;
import java.util.List;

public interface PessoaService {
    
    List<Pessoa> findAll();
    Pessoa findById(Long id);
    Pessoa save(Pessoa pessoa);
}
