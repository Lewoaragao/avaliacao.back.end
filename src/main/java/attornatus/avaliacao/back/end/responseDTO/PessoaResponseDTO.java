package attornatus.avaliacao.back.end.responseDTO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Transient;

import attornatus.avaliacao.back.end.model.Endereco;
import attornatus.avaliacao.back.end.model.Pessoa;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PessoaResponseDTO {

	private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private List<Endereco> enderecos;
    
    public static PessoaResponseDTO of(Pessoa pessoa) {
        return PessoaResponseDTO.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .dataNascimento(pessoa.getDataNascimento())
                .enderecos(pessoa.getEnderecos())
                .build();
    }
    
    @Transient
    public Endereco getEnderecoPrincipal() {
        for (Endereco endereco : enderecos) {
            if (endereco.isPrincipal()) {
                return endereco;
            }
        }
        return null;
    }

}
