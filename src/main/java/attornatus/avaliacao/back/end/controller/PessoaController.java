package attornatus.avaliacao.back.end.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import attornatus.avaliacao.back.end.model.Pessoa;
import attornatus.avaliacao.back.end.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;
    
    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.criarPessoa(pessoa);
    }
    
    @PutMapping("/{id}")
    public Pessoa atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return pessoaService.atualizarPessoa(id, pessoa);
    }
    
    @GetMapping("/{id}")
    public Pessoa consultarPessoa(@PathVariable Long id) {
        Optional<Pessoa> optionalPessoa = pessoaService.consultarPessoa(id);
        if (optionalPessoa.isPresent()) {
            return optionalPessoa.get();
        } else {
            throw new RuntimeException("Pessoa não encontrada");
        }
    }
    
    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }
}

