package attornatus.avaliacao.back.end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import attornatus.avaliacao.back.end.requestDTO.PageRequestDTO;
import attornatus.avaliacao.back.end.requestDTO.PessoaRequestDTO;
import attornatus.avaliacao.back.end.responseDTO.PessoaResponseDTO;
import attornatus.avaliacao.back.end.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;
    
    @PostMapping
    public ResponseEntity<PessoaResponseDTO> criarPessoa(@RequestBody PessoaRequestDTO pessoaRequest) {
        return ResponseEntity.ok().body(pessoaService.criarPessoa(pessoaRequest));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaRequestDTO pessoaRequest) throws NotFoundException {
        return ResponseEntity.ok().body(pessoaService.atualizarPessoa(id, pessoaRequest));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> consultarPessoa(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok().body(pessoaService.consultarPessoa(id));
    }
    
    @GetMapping
    public ResponseEntity<Page<PessoaResponseDTO>> listarPessoas(PageRequestDTO pageRequestDTO) {
        return ResponseEntity.ok().body(pessoaService.listarPessoas(pageRequestDTO));
    }
}

