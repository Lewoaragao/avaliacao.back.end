package attornatus.avaliacao.back.end.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import attornatus.avaliacao.back.end.model.Pessoa;
import attornatus.avaliacao.back.end.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    
    public Pessoa atualizarPessoa(Long id, Pessoa pessoa) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        if (optionalPessoa.isPresent()) {
            Pessoa pessoaAtual = optionalPessoa.get();
            pessoaAtual.setNome(pessoa.getNome());
            pessoaAtual.setDataNascimento(pessoa.getDataNascimento());
            pessoaAtual.setEnderecos(pessoa.getEnderecos());
            return pessoaRepository.save(pessoaAtual);
        } else {
            throw new RuntimeException("Pessoa não encontrada");
        }
    }
    
    public Optional<Pessoa> consultarPessoa(Long id) {
        return pessoaRepository.findById(id);
    }
    
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }
}

