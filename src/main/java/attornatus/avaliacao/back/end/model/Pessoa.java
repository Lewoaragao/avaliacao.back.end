package attornatus.avaliacao.back.end.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import attornatus.avaliacao.back.end.requestDTO.PessoaRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_pessoa")
public class Pessoa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private LocalDate dataNascimento;
    
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;
    
    public static Pessoa of(PessoaRequestDTO pessoaRequest) {
        return Pessoa.builder()
                .nome(pessoaRequest.getNome())
                .dataNascimento(pessoaRequest.getDataNascimento())
                .enderecos(pessoaRequest.getEnderecos())
                .build();
    }
}
