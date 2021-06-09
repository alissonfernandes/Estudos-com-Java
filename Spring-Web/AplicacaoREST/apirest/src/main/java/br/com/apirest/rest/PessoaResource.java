package br.com.apirest.rest;

import br.com.apirest.model.Pessoa;
import br.com.apirest.service.PessoaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaResource {
    
    @Autowired
    private PessoaService pessoaRepository;
    
    @GetMapping("/pessoa")
    public List<Pessoa> getAllPessoa(){
        return pessoaRepository.findAll();
    }
    
    @GetMapping("/pessoa/{id}")
    public Pessoa getPessoa(@PathVariable("id") Long id){
        return pessoaRepository.findById(id);
    }
}
