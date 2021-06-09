package br.com.apirest.rest;

import br.com.apirest.exception.PessoaNotFoundException;
import br.com.apirest.model.Pessoa;
import br.com.apirest.repository.PessoaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaResource {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    @GetMapping("/pessoa")
    public List<Pessoa> getAllPessoa(){
        return pessoaRepository.findAll();
    }
    
    @GetMapping("/pessoa/{id}")
    public Pessoa getPessoa(@PathVariable("id") Long id){
        final Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        
        if(pessoa.isPresent()){
            return pessoa.get();
        }else{
            throw new PessoaNotFoundException();
        }
    }
}
