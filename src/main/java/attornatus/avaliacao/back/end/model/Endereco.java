package attornatus.avaliacao.back.end.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import attornatus.avaliacao.back.end.requestDTO.EnderecoRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_endereco")
public class Endereco {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(nullable = false)
    private String logradouro;
    
	@Column(nullable = false)
    private String cep;
    
	@Column(nullable = false)
    private Integer numero;
    
	@Column(nullable = false)
    private String cidade;
    
	@Column(nullable = false, columnDefinition = "boolean default false")
    private boolean principal;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pessoa_id")
    @JsonIgnore
    private Pessoa pessoa;
    
    public static Endereco of(EnderecoRequestDTO enderecoRequest) {
        return Endereco.builder()
                .logradouro(enderecoRequest.getLogradouro())
                .cep(enderecoRequest.getCep())
                .numero(enderecoRequest.getNumero())
                .cidade(enderecoRequest.getCidade())
                .principal(enderecoRequest.isPrincipal())
                .pessoa(enderecoRequest.getPessoa())
                .build();
    }

}
