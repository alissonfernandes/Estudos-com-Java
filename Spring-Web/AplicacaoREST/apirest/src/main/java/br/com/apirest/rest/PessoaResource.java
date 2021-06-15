package br.com.apirest.rest;

import br.com.apirest.model.Pessoa;
import br.com.apirest.repository.PessoaRepository;
import br.com.apirest.service.PessoaService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaResource {
    
    @Autowired
    private  PessoaService service;
    
    @GetMapping("/api/pessoa")
    public List<Pessoa> getAllPessoa(){
        return service.findAll();
    }
    
    @GetMapping("/api/pessoa/{id}")
    public ResponseEntity getPessoa(@PathVariable("id") Long id){
        final Pessoa pessoa = service.findById(id);
        return ResponseEntity.ok(pessoa);
    }
    
    @PostMapping("/api/pessoa")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pessoa> createPessoa(@Valid @RequestBody Pessoa pessoa){
        return new ResponseEntity<Pessoa>(service.save(pessoa), HttpStatus.CREATED);
    }
    
    @PutMapping("/api/pessoa/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable("id") Long id, @RequestBody Pessoa dto){
        return ResponseEntity.ok(service.update(id, dto));
    }
    
    @DeleteMapping("/api/pessoa/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePessoa(@PathVariable("id") Long id){
       service.delete(id);
    }
}
