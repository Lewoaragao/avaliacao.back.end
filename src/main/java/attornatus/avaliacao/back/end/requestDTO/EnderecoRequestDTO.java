package attornatus.avaliacao.back.end.requestDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import attornatus.avaliacao.back.end.model.Pessoa;
import lombok.Data;

@Data
public class EnderecoRequestDTO {

    private Long id;
    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;
    private boolean principal;

    @JsonIgnore
    private Pessoa pessoa;

}
