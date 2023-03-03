package attornatus.avaliacao.back.end.responseDTO;

import attornatus.avaliacao.back.end.model.Pessoa;
import lombok.Data;

@Data
public class EnderecoResponseDTO {

    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private Boolean principal;
    private Pessoa pessoa;

}
