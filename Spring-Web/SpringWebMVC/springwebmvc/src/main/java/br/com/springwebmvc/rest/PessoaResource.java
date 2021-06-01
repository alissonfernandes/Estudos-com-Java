package br.com.springwebmvc.rest;

import br.com.springwebmvc.model.Pessoa;
import br.com.springwebmvc.repository.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaResource {
    
    @Autowired
    private PessoaRepository repositoryPessoa;
    
    @GetMapping("/api/pessoa")
    public List<Pessoa> getAllPessoa(){
        return repositoryPessoa.getAllPessoa();
    }
    
    @GetMapping("/api/pessoa/{id}")
    public Pessoa getPessoa(@PathVariable("id") int id){
        return repositoryPessoa.getId(id);
    }
    
}
