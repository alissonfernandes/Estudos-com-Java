package br.com.springwebmvc.repository;

import br.com.springwebmvc.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepository {
    
    List<Pessoa> pessoas;
    
    public PessoaRepository(){
        pessoas = new ArrayList<>();
    }
     
    public List<Pessoa> getAllPessoa(){
        return pessoas;
    }
    
    public void add(final Pessoa pessoa){
        this.pessoas.add(pessoa);
    }
}
