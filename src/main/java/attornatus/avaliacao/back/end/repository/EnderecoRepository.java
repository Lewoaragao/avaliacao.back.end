package attornatus.avaliacao.back.end.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import attornatus.avaliacao.back.end.model.Endereco;
import attornatus.avaliacao.back.end.model.Pessoa;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	Page<Endereco> findByPessoa(Pessoa pessoa, Pageable pageable);
}
