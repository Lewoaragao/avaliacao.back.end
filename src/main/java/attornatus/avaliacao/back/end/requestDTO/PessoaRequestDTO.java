package attornatus.avaliacao.back.end.requestDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import attornatus.avaliacao.back.end.model.Endereco;
import lombok.Data;

@Data
public class PessoaRequestDTO {

	private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private List<Endereco> enderecos = new ArrayList<>();

}
