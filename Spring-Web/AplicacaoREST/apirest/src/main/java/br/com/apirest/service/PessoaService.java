package br.com.apirest.service;
//Camada de servico

import br.com.apirest.exception.PessoaNotFoundException;
import br.com.apirest.model.Pessoa;
import br.com.apirest.repository.PessoaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository repository;
    
    public List<Pessoa> findAll(){
        return repository.findAll();
    }
    
    public Pessoa findById(final Long id){
        final Optional<Pessoa> entity = repository.findById(id);
        
        if(entity.isPresent()){
            return entity.get();
        }else{
            throw new PessoaNotFoundException();
        }
    }
    
    public Pessoa save(Pessoa pessoa){
        return repository.save(pessoa);
    }
    
    public Pessoa update(final Long id, final Pessoa dto){
        final Optional<Pessoa> entityPessoa  = repository.findById(id);
        final Pessoa pessoa;
        
        if(entityPessoa.isPresent()){
            pessoa = entityPessoa.get();
        }else{
            throw new PessoaNotFoundException();
        }
        
        pessoa.setNome(dto.getNome());
        pessoa.setIdade(dto.getIdade());
        pessoa.setSexo(dto.getSexo());
        
        return repository.save(pessoa);
    }
    
    public void delete(final Long id){
        final Optional<Pessoa> entityPessoa = repository.findById(id);
        
        if(entityPessoa.isPresent()){
            repository.deleteById(id);
        }else{
            throw new PessoaNotFoundException();
        }
   }
    
}
