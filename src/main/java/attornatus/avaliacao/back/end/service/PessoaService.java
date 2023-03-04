package attornatus.avaliacao.back.end.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import attornatus.avaliacao.back.end.model.Pessoa;
import attornatus.avaliacao.back.end.repository.PessoaRepository;
import attornatus.avaliacao.back.end.requestDTO.PageRequestDTO;
import attornatus.avaliacao.back.end.requestDTO.PessoaRequestDTO;
import attornatus.avaliacao.back.end.responseDTO.PessoaResponseDTO;

@Service
@SuppressWarnings("unused")
public class PessoaService {

	private static final String ERR_PESSOA_NOT_FOUND = null;

	@Autowired
	private PessoaRepository pessoaRepository;

	public PessoaResponseDTO criarPessoa(PessoaRequestDTO pessoaRequest) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaRequest.getNome());
		pessoa.setDataNascimento(pessoaRequest.getDataNascimento());
		pessoa.setEnderecos(pessoaRequest.getEnderecos());
		return PessoaResponseDTO.of(pessoaRepository.save(pessoa));
	}

	public PessoaResponseDTO atualizarPessoa(Long id, PessoaRequestDTO pessoaRequest) throws NotFoundException {
		Pessoa pessoa = validarPessoaExistente(id);
		BeanUtils.copyProperties(pessoaRequest, pessoa, "id");
		pessoaRepository.save(pessoa);
		return PessoaResponseDTO.of(pessoa);
	}

	public PessoaResponseDTO consultarPessoa(Long id) throws NotFoundException {
		Pessoa pessoa = validarPessoaExistente(id);
		return PessoaResponseDTO.of(pessoa);
	}

	public Page<PessoaResponseDTO> listarPessoas(PageRequestDTO pageRequestDTO) {
		return pessoaRepository.findAll(pageRequestDTO).map(PessoaResponseDTO::of);
	}

	public void deletarTodasPessoas() {
		pessoaRepository.deleteAll();
	}

	public Pessoa validarPessoaExistente(Long id) throws NotFoundException {
		return pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}
}
