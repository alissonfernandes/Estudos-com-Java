package br.com.springwebmvc.controller;

import br.com.springwebmvc.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PessoaController {
    
    @GetMapping("/pessoa")
    public ModelAndView pessoa(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pessoa");
        Pessoa pessoa = new Pessoa("Bruno", 21);
        
        List<Pessoa> pessoas = new ArrayList();
        pessoas.add(pessoa);
        
        modelAndView.addObject("allPessoa",pessoas);
        return modelAndView;
    }
    
    @GetMapping("/new-pessoa")
    public ModelAndView newPessoa(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-pessoa");
        Pessoa pessoa = new Pessoa();
        modelAndView.addObject("pessoa", pessoa);
        return modelAndView;
    }
}
