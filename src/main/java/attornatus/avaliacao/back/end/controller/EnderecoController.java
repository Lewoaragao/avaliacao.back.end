package attornatus.avaliacao.back.end.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import attornatus.avaliacao.back.end.model.Endereco;
import attornatus.avaliacao.back.end.service.EnderecoService;

@RestController
@RequestMapping("/api/pessoas/{pessoaId}/enderecos")
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;
    
    @PostMapping
    public Endereco criarEndereco(@PathVariable Long pessoaId, @RequestBody Endereco endereco) {
        return enderecoService.criarEndereco(pessoaId, endereco);
    }
    
    @PutMapping("/{enderecoId}/principal")
    public void definirEnderecoPrincipal(@PathVariable Long pessoaId, @PathVariable Long enderecoId) {
        enderecoService.definirEnderecoPrincipal(pessoaId, enderecoId);
    }
    
    @GetMapping
    public List<Endereco> listarEnderecos(@PathVariable Long pessoaId) {
    	return enderecoService.listarEnderecos(pessoaId);
    }
}