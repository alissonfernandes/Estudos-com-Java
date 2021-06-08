package br.com.springwebmvc.controller;

import br.com.springwebmvc.model.Pessoa;
import br.com.springwebmvc.repository.PessoaRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PessoaController {
    
    @Autowired()
    private PessoaRepository repository;
    
    @GetMapping("/pessoa")
    public ModelAndView pessoa(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pessoa");        
        modelAndView.addObject("allPessoa", repository.getAllPessoa());
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
    
    @PostMapping("/pessoa")
    public String createPessoa(@Valid @ModelAttribute Pessoa pessoa, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "new-pessoa";
        }
        repository.add(pessoa);
        attributes.addFlashAttribute("message", "Pessoa cadastrado com sucesso.");
        return "redirect:pessoa";
    }
}
