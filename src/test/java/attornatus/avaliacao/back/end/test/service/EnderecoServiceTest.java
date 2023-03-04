package attornatus.avaliacao.back.end.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import attornatus.avaliacao.back.end.requestDTO.EnderecoRequestDTO;
import attornatus.avaliacao.back.end.requestDTO.PageRequestDTO;
import attornatus.avaliacao.back.end.requestDTO.PessoaRequestDTO;
import attornatus.avaliacao.back.end.responseDTO.EnderecoResponseDTO;
import attornatus.avaliacao.back.end.responseDTO.PessoaResponseDTO;
import attornatus.avaliacao.back.end.service.EnderecoService;
import attornatus.avaliacao.back.end.service.PessoaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnderecoServiceTest {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private EnderecoService enderecoService;

	@Test
	public void testCriarEndereco() throws NotFoundException {
		PessoaRequestDTO pessoaRequest = new PessoaRequestDTO();
		pessoaRequest.setNome("João");
		pessoaRequest.setDataNascimento(LocalDate.of(1990, 1, 1));
		PessoaResponseDTO pessoaCriada = pessoaService.criarPessoa(pessoaRequest);
		EnderecoRequestDTO enderecoRequest = new EnderecoRequestDTO();
		enderecoRequest.setLogradouro("Rua A");
		enderecoRequest.setCep("12345-678");
		enderecoRequest.setNumero(10);
		enderecoRequest.setCidade("São Paulo");
		EnderecoResponseDTO enderecoCriado = enderecoService.criarEndereco(pessoaCriada.getId(), enderecoRequest);
		assertNotNull(enderecoCriado);
		assertNotNull(enderecoCriado.getId());
		assertEquals(enderecoRequest.getLogradouro(), enderecoCriado.getLogradouro());
		assertEquals(enderecoRequest.getCep(), enderecoCriado.getCep());
		assertEquals(enderecoRequest.getNumero(), enderecoCriado.getNumero());
		assertEquals(enderecoRequest.getCidade(), enderecoCriado.getCidade());
	}

	@Test
	public void testListarEnderecos() throws NotFoundException {
		enderecoService.deletarTodosEnderecos();
		PessoaRequestDTO pessoaRequest = new PessoaRequestDTO();
		pessoaRequest.setNome("João");
		pessoaRequest.setDataNascimento(LocalDate.of(1990, 1, 1));
		PessoaResponseDTO pessoaCriada = pessoaService.criarPessoa(pessoaRequest);
		EnderecoRequestDTO enderecoRequestUm = new EnderecoRequestDTO();
		enderecoRequestUm.setLogradouro("Rua A");
		enderecoRequestUm.setCep("12345-678");
		enderecoRequestUm.setNumero(10);
		enderecoRequestUm.setCidade("São Paulo");
		enderecoService.criarEndereco(pessoaCriada.getId(), enderecoRequestUm);
		EnderecoRequestDTO enderecoRequestDois = new EnderecoRequestDTO();
		enderecoRequestDois.setLogradouro("Rua B");
		enderecoRequestDois.setCep("87654-321");
		enderecoRequestDois.setNumero(20);
		enderecoRequestDois.setCidade("Rio de Janeiro");
		enderecoService.criarEndereco(pessoaCriada.getId(), enderecoRequestDois);
		PageRequestDTO pageRequest = new PageRequestDTO();
		Page<EnderecoResponseDTO> enderecos = enderecoService.listarEnderecos(pessoaCriada.getId(), pageRequest);
		assertEquals(2, enderecos.getContent().size());
	}

	@Test
	public void testDefinirEnderecoPrincipal() throws NotFoundException {
		PessoaRequestDTO pessoaRequest = new PessoaRequestDTO();
		pessoaRequest.setNome("João");
		pessoaRequest.setDataNascimento(LocalDate.of(1990, 1, 1));
		PessoaResponseDTO pessoaCriada = pessoaService.criarPessoa(pessoaRequest);
		EnderecoRequestDTO enderecoRequestUm = new EnderecoRequestDTO();
		enderecoRequestUm.setLogradouro("Rua A");
		enderecoRequestUm.setCep("12345-678");
		enderecoRequestUm.setNumero(10);
		enderecoRequestUm.setCidade("São Paulo");
		enderecoService.criarEndereco(pessoaCriada.getId(), enderecoRequestUm);
		EnderecoRequestDTO enderecoRequestDois = new EnderecoRequestDTO();
		enderecoRequestDois.setLogradouro("Rua B");
		enderecoRequestDois.setCep("87654-321");
		enderecoRequestDois.setNumero(20);
		enderecoRequestDois.setCidade("Rio de Janeiro");
		EnderecoResponseDTO enderecoCriadoDois = enderecoService.criarEndereco(pessoaCriada.getId(), enderecoRequestDois);
		enderecoService.definirEnderecoPrincipal(pessoaCriada.getId(), enderecoCriadoDois.getId());
		PessoaResponseDTO pessoaAtualizada = pessoaService.consultarPessoa(pessoaCriada.getId());
		assertTrue(pessoaAtualizada != null);
		assertNotNull(pessoaAtualizada.getEnderecoPrincipal());
		assertEquals(enderecoCriadoDois.getId(), pessoaAtualizada.getEnderecoPrincipal().getId());
	}
}
