package attornatus.avaliacao.back.end.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import attornatus.avaliacao.back.end.model.Endereco;
import attornatus.avaliacao.back.end.model.Pessoa;
import attornatus.avaliacao.back.end.repository.EnderecoRepository;
import attornatus.avaliacao.back.end.repository.PessoaRepository;
import attornatus.avaliacao.back.end.requestDTO.EnderecoRequestDTO;
import attornatus.avaliacao.back.end.requestDTO.PageRequestDTO;
import attornatus.avaliacao.back.end.responseDTO.EnderecoResponseDTO;

@Service
public class EnderecoService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Transactional
	public EnderecoResponseDTO criarEndereco(Long pessoaId, EnderecoRequestDTO enderecoRequest)
			throws NotFoundException {
		Pessoa pessoa = pessoaService.validarPessoaExistente(pessoaId);
		enderecoRequest.setPessoa(pessoa);
		Endereco endereco = Endereco.of(enderecoRequest);
		Endereco novoEndereco = enderecoRepository.save(endereco);
		List<Endereco> listEndereco = pessoa.getEnderecos();
		listEndereco.add(novoEndereco);
		pessoaRepository.save(pessoa);
		return EnderecoResponseDTO.of(novoEndereco);
	}

	public Page<EnderecoResponseDTO> listarEnderecos(Long pessoaId, PageRequestDTO pageRequestDTO)
			throws NotFoundException {
		Pessoa pessoa = pessoaService.validarPessoaExistente(pessoaId);
		Page<Endereco> enderecosPage = enderecoRepository.findByPessoa(pessoa, pageRequestDTO);
		Page<EnderecoResponseDTO> enderecosPageDTO = enderecosPage.map(EnderecoResponseDTO::of);
		return enderecosPageDTO;
	}

	public void deletarTodosEnderecos() {
		enderecoRepository.deleteAll();
	}

	@Transactional
	public EnderecoResponseDTO definirEnderecoPrincipal(Long pessoaId, Long enderecoId) throws NotFoundException {
		Pessoa pessoa = pessoaService.validarPessoaExistente(pessoaId);
		pessoa.getEnderecos().forEach(endereco -> {
			if (endereco.getId().equals(enderecoId)) {
				endereco.setPrincipal(true);
			} else {
				endereco.setPrincipal(false);
			}
		});
		pessoaRepository.save(pessoa);
		return EnderecoResponseDTO.of(enderecoRepository.findById(enderecoId).get());
	}

	public EnderecoResponseDTO consultarEnderecoPrincipal(Long pessoaId) throws NotFoundException {
		Pessoa pessoa = pessoaService.validarPessoaExistente(pessoaId);
		for (Endereco endereco : pessoa.getEnderecos()) {
			if (endereco.isPrincipal()) {
				return EnderecoResponseDTO.of(endereco);
			}
		}
		return null;
	}
}
