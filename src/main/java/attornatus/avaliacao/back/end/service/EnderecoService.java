package attornatus.avaliacao.back.end.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import attornatus.avaliacao.back.end.model.Endereco;
import attornatus.avaliacao.back.end.model.Pessoa;
import attornatus.avaliacao.back.end.repository.PessoaRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    public Endereco criarEndereco(Long pessoaId, Endereco endereco) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(pessoaId);
        if (optionalPessoa.isPresent()) {
            Pessoa pessoa = optionalPessoa.get();
            endereco.setPessoa(pessoa);
            pessoa.getEnderecos().add(endereco);
            pessoaRepository.save(pessoa);
            return endereco;
        } else {
            throw new RuntimeException("Pessoa não encontrada");
        }
    }
    
    public List<Endereco> listarEnderecos(Long pessoaId) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(pessoaId);
        if (optionalPessoa.isPresent()) {
            return optionalPessoa.get().getEnderecos();
        } else {
            throw new RuntimeException("Pessoa não encontrada");
        }
    }
    
    public void definirEnderecoPrincipal(Long pessoaId, Long enderecoId) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(pessoaId);
        if (optionalPessoa.isPresent()) {
            Pessoa pessoa = optionalPessoa.get();
            pessoa.getEnderecos().forEach(endereco -> {
                if (endereco.getId().equals(enderecoId)) {
                    endereco.setPrincipal(true);
                } else {
                    endereco.setPrincipal(false);
                }
            });
            pessoaRepository.save(pessoa);
        } else {
            throw new RuntimeException("Pessoa não encontrada");
        }
    }
}

