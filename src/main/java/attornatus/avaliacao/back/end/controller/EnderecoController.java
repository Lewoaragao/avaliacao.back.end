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

import attornatus.avaliacao.back.end.requestDTO.EnderecoRequestDTO;
import attornatus.avaliacao.back.end.requestDTO.PageRequestDTO;
import attornatus.avaliacao.back.end.responseDTO.EnderecoResponseDTO;
import attornatus.avaliacao.back.end.service.EnderecoService;

@RestController
@RequestMapping("/api/pessoas/{pessoaId}/enderecos")
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;
    
    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> criarEndereco(@PathVariable Long pessoaId, @RequestBody EnderecoRequestDTO enderecoRequest) throws NotFoundException {
        return ResponseEntity.ok().body(enderecoService.criarEndereco(pessoaId, enderecoRequest));
    }
    
    @PutMapping("/{enderecoId}/principal")
    public ResponseEntity<EnderecoResponseDTO> definirEnderecoPrincipal(@PathVariable Long pessoaId, @PathVariable Long enderecoId) throws NotFoundException {
    	return ResponseEntity.ok().body(enderecoService.definirEnderecoPrincipal(pessoaId, enderecoId));
    }
    
    @GetMapping("/principal")
    public ResponseEntity<EnderecoResponseDTO> consultarEnderecoPrincipal(@PathVariable Long pessoaId) throws NotFoundException {
    	return ResponseEntity.ok().body(enderecoService.consultarEnderecoPrincipal(pessoaId));
    }
    
    @GetMapping
    public ResponseEntity<Page<EnderecoResponseDTO>> listarEnderecos(@PathVariable Long pessoaId, PageRequestDTO pageRequestDTO) throws NotFoundException {
    	return ResponseEntity.ok().body(enderecoService.listarEnderecos(pessoaId, pageRequestDTO));
    }
}