package attornatus.avaliacao.back.end.responseDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import attornatus.avaliacao.back.end.model.Endereco;
import attornatus.avaliacao.back.end.model.Pessoa;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoResponseDTO {

    private Long id;
    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;
    private boolean principal;
    
    @JsonIgnore
    private Pessoa pessoa;
    
    public static EnderecoResponseDTO of(Endereco endereco) {
        return EnderecoResponseDTO.builder()
                .id(endereco.getId())
                .logradouro(endereco.getLogradouro())
                .cep(endereco.getCep())
                .numero(endereco.getNumero())
                .cidade(endereco.getCidade())
                .principal(endereco.isPrincipal())
                .pessoa(endereco.getPessoa())
                .build();
    }

}
