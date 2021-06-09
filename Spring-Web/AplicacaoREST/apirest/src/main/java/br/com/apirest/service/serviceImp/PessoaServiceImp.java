package br.com.apirest.service.serviceImp;

import br.com.apirest.model.Pessoa;
import br.com.apirest.repository.PessoaRepository;
import br.com.apirest.service.PessoaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImp implements PessoaService{
    
    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).get();
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    
}
