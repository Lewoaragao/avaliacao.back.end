package attornatus.avaliacao.back.end.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import attornatus.avaliacao.back.end.requestDTO.PageRequestDTO;
import attornatus.avaliacao.back.end.requestDTO.PessoaRequestDTO;
import attornatus.avaliacao.back.end.responseDTO.PessoaResponseDTO;
import attornatus.avaliacao.back.end.service.PessoaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaServiceTest {

	@Autowired
	private PessoaService pessoaService;

	@Test
	public void testCriarPessoa() {
		PessoaRequestDTO pessoaRequest = new PessoaRequestDTO();
		pessoaRequest.setNome("João");
		pessoaRequest.setDataNascimento(LocalDate.of(1990, 1, 1));
		PessoaResponseDTO pessoaCriada = pessoaService.criarPessoa(pessoaRequest);
		assertNotNull(pessoaCriada);
		assertNotNull(pessoaCriada.getId());
		assertEquals(pessoaRequest.getNome(), pessoaCriada.getNome());
		assertEquals(pessoaRequest.getDataNascimento(), pessoaCriada.getDataNascimento());
	}

	@Test
	public void testAtualizarPessoa() throws NotFoundException {
		PessoaRequestDTO pessoaRequest = new PessoaRequestDTO();
		pessoaRequest.setNome("João");
		pessoaRequest.setDataNascimento(LocalDate.of(1990, 1, 1));
		PessoaResponseDTO pessoaCriada = pessoaService.criarPessoa(pessoaRequest);
		pessoaCriada.setNome("Maria");
		pessoaCriada.setDataNascimento(LocalDate.of(1990, 2, 2));
		PessoaRequestDTO pessoaCriadaRequest = new PessoaRequestDTO();
		BeanUtils.copyProperties(pessoaCriada, pessoaCriadaRequest, "id");
		PessoaResponseDTO pessoaAtualizada = pessoaService.atualizarPessoa(pessoaCriada.getId(), pessoaCriadaRequest);
		assertNotNull(pessoaAtualizada);
		assertEquals(pessoaCriada.getId(), pessoaAtualizada.getId());
		assertEquals(pessoaCriada.getNome(), pessoaAtualizada.getNome());
		assertEquals(pessoaCriada.getDataNascimento(), pessoaAtualizada.getDataNascimento());
	}

	@Test
	public void testConsultarPessoa() throws NotFoundException {
		PessoaRequestDTO pessoaRequest = new PessoaRequestDTO();
		pessoaRequest.setNome("João");
		pessoaRequest.setDataNascimento(LocalDate.of(1990, 1, 1));
		PessoaResponseDTO pessoaCriada = pessoaService.criarPessoa(pessoaRequest);
		PessoaResponseDTO pessoaConsultada = pessoaService.consultarPessoa(pessoaCriada.getId());
		assertTrue(pessoaConsultada != null);
		assertEquals(pessoaCriada.getId(), pessoaConsultada.getId());
		assertEquals(pessoaCriada.getNome(), pessoaConsultada.getNome());
		assertEquals(pessoaCriada.getDataNascimento(), pessoaConsultada.getDataNascimento());
	}

	@Test
    public void testListarPessoas() {
		pessoaService.deletarTodasPessoas();
        PessoaRequestDTO pessoaUmDTO = new PessoaRequestDTO();
        pessoaUmDTO.setNome("João");
        pessoaUmDTO.setDataNascimento(LocalDate.of(1990, 1, 1));
        pessoaService.criarPessoa(pessoaUmDTO);
        PessoaRequestDTO pessoaDoisDTO = new PessoaRequestDTO();
        pessoaDoisDTO.setNome("Maria");
        pessoaDoisDTO.setDataNascimento(LocalDate.of(1991, 2, 2));
        pessoaService.criarPessoa(pessoaDoisDTO);
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        Page<PessoaResponseDTO> pessoas = pessoaService.listarPessoas(pageRequestDTO);
        assertEquals(2, pessoas.getContent().size());
    }
}